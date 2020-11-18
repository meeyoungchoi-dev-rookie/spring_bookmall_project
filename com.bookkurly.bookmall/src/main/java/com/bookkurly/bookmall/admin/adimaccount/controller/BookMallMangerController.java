package com.bookkurly.bookmall.admin.adimaccount.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bookkurly.bookmall.admin.adimaccount.dto.AdminMainCategoryForm;
import com.bookkurly.bookmall.admin.adimaccount.dto.BookMallManagerForm;
import com.bookkurly.bookmall.admin.adimaccount.entity.AdminMainCategory;
import com.bookkurly.bookmall.admin.adimaccount.entity.AdminSubCategory;
import com.bookkurly.bookmall.admin.adimaccount.entity.BookMallManager;

import com.bookkurly.bookmall.admin.adimaccount.service.BookMallMangerService;
import com.bookkurly.bookmall.customer.category.dto.BookDTO;
import com.bookkurly.bookmall.customer.category.entity.Book;
import com.bookkurly.bookmall.customer.category.entity.MainCategory;
import com.bookkurly.bookmall.customer.category.entity.SubCategory;
import com.bookkurly.bookmall.customer.category.service.CategoryService;
import com.bookkurly.bookmall.customer.jang.dto.ManagerOrderDelivery;
import com.bookkurly.bookmall.customer.jang.entity.JangEntity;
import com.bookkurly.bookmall.customer.jang.entity.OrderNumber;
import com.bookkurly.bookmall.customer.jang.service.JangServiceImpl;
import com.bookkurly.bookmall.customer.register.service.CustomerService;
import com.bookkurly.bookmall.customer.register.service.CustomerServiceImpl;

@Controller
public class BookMallMangerController {

	@Resource(name = "uploadPath")
	String uploadPath;// "/resources"

	@Autowired
	private BookMallMangerService bookMallManagerService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private JangServiceImpl jangService;
	
	@Autowired
	private CustomerServiceImpl CustomerService;

	@GetMapping("/manager/page")
	public String index() {
		return "redirect:/admin/login";
	}

	@GetMapping("/admin/login")
	public String login() {
		System.out.println("/admin/login");
		return "admin/login";
	}

	@PostMapping("/admin/logincheck")
	public String logincheck(BookMallManagerForm bookMallManagerForm, HttpServletRequest request, Model model) {
		System.out.println("/admin/logincheck: admin login= " + bookMallManagerForm.toString());

		BookMallManager bm = bookMallManagerForm.toEntity();
		System.out.println(bm.toString());

		bm = bookMallManagerService.logincheck(bm);
		System.out.println(bm.toString());

		HttpSession session = request.getSession();
		session.setAttribute("adminlogin", bm.getAdminId());
		System.out.println(session.getAttribute("adminlogin"));
		return "redirect:/admin/manager";
	}

	@GetMapping("/admin/manager")
	public String manage(HttpSession session, Model model) {
		System.out.println("/admin/manager");
		session.getAttribute("adminlogin");
		return "admin/manager";
	}

	@GetMapping("/admin/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/manager/page";
	}

	@GetMapping("/manager/maincategories")
	public String showMainCategories(Model model) {
		System.out.println("/manager/categories");
		List<MainCategory> mainCategories = categoryService.selectList();
		System.out.println("mainCategories: " + mainCategories.toString());

		model.addAttribute("mainCategories", mainCategories);
		return "admin/main_cate_page";
	}

	@GetMapping("/manager/maincategory/{mainCateSeq}")
	public String detailMaincategory(@PathVariable Integer mainCateSeq, Model model) {
		System.out.println("/manager/maincategory/" + mainCateSeq);

		// 1. 메인카테고리 이름 알아내기
		String mainCateName = categoryService.findMainCateName(mainCateSeq);
		System.out.println("mainCateName: " + mainCateName);

		// 2.
		List<SubCategory> subCategories = categoryService.selectList(mainCateSeq);
		System.out.println("subCategories: " + subCategories.toString());

		// 3.
		for (int i = 0; i < subCategories.size(); i++) {
			List<Book> books = categoryService.selectList2(subCategories.get(i).getSubCateSeq());
			Integer booksCount = books.size();
			subCategories.get(i).setSubCateBookCount(booksCount);
		}

		model.addAttribute("mainCateName", mainCateName);
		model.addAttribute("subCategories", subCategories);
		model.addAttribute("mainCateSeq", mainCateSeq);

		return "admin/sub_cate_page";
	}

	@GetMapping("/manager/subcate/{subCateSeq}")
	public String detailSubCateBook(@PathVariable Integer subCateSeq, Model model) {
		System.out.println("/manager/book/" + subCateSeq);

		// 1.
		List<Book> books = categoryService.selectList2(subCateSeq);
		System.out.println("books: " + books.toString());

		// 2. 도서가 속한 서브카테고리
		String subCateName = categoryService.selectSubcateName(subCateSeq);
		System.out.println("subCateName: " + subCateName);

		// 3.
		Integer mainCateSeq = categoryService.selectMainCateSeq(subCateSeq);
		System.out.println("mainCateSeq: " + mainCateSeq);

		// 4.
		String mainCateName = categoryService.findMainCateName(mainCateSeq);
		System.out.println("mainCateName: " + mainCateName);

		for (int i = 0; i < books.size(); i++) {
			books.get(i).setSubCateName(subCateName);
		}

		System.out.println("books: " + books.toString());

		model.addAttribute("books", books);
		model.addAttribute("subCateName", subCateName);
		model.addAttribute("mainCateName", mainCateName);
		model.addAttribute("subCateSeq", subCateSeq);
		model.addAttribute("mainCateSeq", mainCateSeq);
		return "admin/books";
	}

	@GetMapping("/manager/book/{bookSeq}")
	public String bookInSubcate(@PathVariable Integer bookSeq, Model model) {
		System.out.println("/manager/book=> bookSeq: " + bookSeq);

		Book book = categoryService.findBook(bookSeq);
		System.out.println("수정된 book: " + book.toString());

		String subCateName = categoryService.selectSubcateName(book.getSubCateSeq());
		book.setSubCateName(subCateName);
		System.out.println("subCateName: " + book.getSubCateName());

		// 3.
		Integer mainCateSeq = categoryService.selectMainCateSeq(book.getSubCateSeq());
		System.out.println("mainCateSeq: " + mainCateSeq);

		// 4.
		String mainCateName = categoryService.findMainCateName(mainCateSeq);
		System.out.println("mainCateName: " + mainCateName);

		model.addAttribute("book", book);
		model.addAttribute("mainCateName", mainCateName);
		model.addAttribute("subCateName", book.getSubCateName());
		return "admin/book_detail";
	}

	@PostMapping("/manager/book/edit/{bookSeq}")
	public String edit(@PathVariable Integer bookSeq, Model model) {
		System.out.println("/manager/book/update");

		Book book = categoryService.findBook(bookSeq);
		System.out.println("book: " + book.toString());

		String subCateName = categoryService.selectSubcateName(book.getSubCateSeq());
		book.setSubCateName(subCateName);
		System.out.println("subCateName: " + book.getSubCateName());

		// 3.
		Integer mainCateSeq = categoryService.selectMainCateSeq(book.getSubCateSeq());
		System.out.println("mainCateSeq: " + mainCateSeq);

		// 4.
		String mainCateName = categoryService.findMainCateName(mainCateSeq);
		System.out.println("mainCateName: " + mainCateName);

		model.addAttribute("book", book);
		model.addAttribute("mainCateName", mainCateName);
		model.addAttribute("subCateName", subCateName);

		return "admin/book_update";
	}

	@PostMapping("/manager/book/update/{bookSeq}")
	public String update(@PathVariable Integer bookSeq, BookDTO bookdto, Model model , MultipartFile file, HttpServletRequest request) throws IOException {
		System.out.println("/manager/book/update/" + bookSeq);

		System.out.println("수정후 book: " + bookdto.toString());

		System.out.println("uploadPath: " + uploadPath);
		System.out.println("파일이름: " + file.getOriginalFilename());
		
		bookdto.setBookImageName(file);
		
		System.out.println("파일크기: " + file.getSize());

		System.out.println("컨텍트 타입: " + file.getContentType());// 어떤 종류의 파일인지를 알려준다

		String savedName = file.getOriginalFilename();
		System.out.println("originalFileName: " + savedName);
		
		Book book = bookdto.toEntity(bookdto.getBookSeq(),file.getOriginalFilename());
		System.out.println("book: " + book.toString());

		String resourcesPath = request.getSession().getServletContext().getRealPath(uploadPath);
		System.out.println("resourcesPath: " + resourcesPath);

		File target = new File(resourcesPath, savedName);
		System.out.println("target: " + target.toString());

		FileCopyUtils.copy(file.getBytes(), target);
		System.out.println("resourcesPath: " + resourcesPath);
		
		Integer updateSuccess = categoryService.updateBook(book);
		System.out.println("update 성공: " + updateSuccess);

		return "redirect:/manager/book/" + bookSeq;
	}

	@GetMapping("/manager/create")
	public String create() {
		return "admin/main_cate";
	}

	@PostMapping("/manager/maincate")
	public String createMancate(AdminMainCategoryForm adminMainCategoryForm) {
		System.out.println("adminMainCategoryForm: " + adminMainCategoryForm.toString());

		AdminMainCategory adminMainCategoryEntity = adminMainCategoryForm.toEntity();
		System.out.println("adminMainCategoryEntity: " + adminMainCategoryEntity.toString());

		Integer mainCateAddSuccess = categoryService.insertMainCate(adminMainCategoryEntity);
		System.out.println("메인카테 추가 성공: " + mainCateAddSuccess);

		return "redirect:/manager/maincategories";
	}

	@GetMapping("/manager/add/subcategory/{mainCateSeq}")
	public String addSubcategory(@PathVariable Integer mainCateSeq, Model model) {
		System.out.println("/manager/add/subcategory/" + mainCateSeq);
		String mainCateName = categoryService.findMainCateName(mainCateSeq);

		System.out.println("mainCateName: " + mainCateName);

		model.addAttribute("mainCateName", mainCateName);
		model.addAttribute("mainCateSeq", mainCateSeq);
		return "admin/add_subcate";
	}

	@PostMapping("/manager/add/subcate")
	public String createSubcate(AdminSubCategory adminSubCategory) {
		System.out.println("/manager/ad/subcate");
		System.out.println("adminSubCategory: " + adminSubCategory);

		Integer subCateInsertSuccess = categoryService.insertSubCategory(adminSubCategory);
		System.out.println("subCateInsertSuccess: " + subCateInsertSuccess);

		return "redirect:/manager/maincategories";
	}

	@GetMapping("/manager/add/book/{mainCateSeq}/{subCateSeq}")
	public String addBook(@PathVariable Integer mainCateSeq, @PathVariable Integer subCateSeq, Model model) {
		System.out.println("/manager/add/book/" + mainCateSeq + "/" + subCateSeq);

		String mainCateName = categoryService.findMainCateName(mainCateSeq);
		System.out.println("mainCateName: " + mainCateName);

		String subCateName = categoryService.selectSubcateName(subCateSeq);
		System.out.println("subCateName: " + subCateName);

		model.addAttribute("mainCateName", mainCateName);
		model.addAttribute("subCateName", subCateName);
		model.addAttribute("subCateSeq", subCateSeq);

		return "admin/add_book";
	}

	@PostMapping("/manager/add/book")
	public String insertBook(BookDTO bookdto, MultipartFile file, HttpServletRequest request) throws IOException {
		System.out.println("/manager/add/book");
		System.out.println("uploadPath: " + uploadPath);
		System.out.println("파일이름: " + file.getOriginalFilename());
		
		bookdto.setBookImageName(file);
		System.out.println("bookdto: " + bookdto.toString());
		
		Book book = bookdto.toEntity(bookdto.getBookSeq(),file.getOriginalFilename());
		System.out.println("디비에 저장하기 위한 book: "  + book.toString());
		
		System.out.println("파일크기: " + file.getSize());

		System.out.println("컨텍트 타입: " + file.getContentType());// 어떤 종류의 파일인지를 알려준다

		String savedName = file.getOriginalFilename();
		System.out.println("originalFileName: " + savedName);


		String resourcesPath = request.getSession().getServletContext().getRealPath(uploadPath);
		System.out.println("resourcesPath: " + resourcesPath);

		File target = new File(resourcesPath, savedName);
		System.out.println("target: " + target.toString());

		FileCopyUtils.copy(file.getBytes(), target);
		System.out.println("resourcesPath: " + resourcesPath);

		
		Integer insertSuccess = categoryService.insertBook(book);
		System.out.println("디비에 저장성공: " + insertSuccess);
	
		return "redirect:/manager/subcate/" + book.getSubCateSeq();
	}
	
	
	@GetMapping("/manager/orders")
	public String controlOrder(Model model) {
		List<OrderNumber> orderSerialNumbers = jangService.selectOrderSerialNums();
		
		for (OrderNumber str : orderSerialNumbers) {
			System.out.println("주문고유번호: " + str.getOrderSeq() + " : " + str.getOrderSerialNum());
		}
		
		model.addAttribute("orderNumbers", orderSerialNumbers);
		
		return "admin/orders";
	}
	
	
	@GetMapping("/manager/orders/{orderSerialNum}")
	public String orderDetail(@PathVariable String orderSerialNum, Model model) {
		System.out.println("/manager/orders/" + orderSerialNum);
		
		List<JangEntity> jangs = jangService.selectAll(orderSerialNum);
		System.out.println("jangs: " + jangs.toString());
		
		for (int i = 0; i < jangs.size(); i++) {
			if (jangs.get(i).getBookTitle() == null) {
				Book book = categoryService.findBook(jangs.get(i).getBookSeq());
				jangs.get(i).setBookTitle(book.getBookTitle());
			}
		}
		
		for (int i = 0; i < jangs.size(); i++) {
			if (jangs.get(i).getOrderDeliveryStatus() == null) {
				jangs.get(i).setOrderDeliveryStatus("false");
			}
		}
		
	
		System.out.println("update후 jangs: " + jangs.toString());
		
		String customerId = CustomerService.selectCustomerId(jangs.get(0).getCustomSeq());
		
		
		model.addAttribute("jangs", jangs);
		model.addAttribute("customerId", customerId);
		model.addAttribute("orderSerialNum", orderSerialNum);
		
		return "admin/orders_detail";
	}
	
	@PostMapping("/manager/update/orderDeliverStatus")
	public String updateOrderDeliverStatus(ManagerOrderDelivery managerOrderDelivery) {
		managerOrderDelivery.setOrderDeliveryStatus("true");
		System.out.println("marnagerOrderDelivery: " + managerOrderDelivery);
		
		Integer deliveryUpdateSuccess = jangService.updateOrderDeliveryStatement(managerOrderDelivery);
		System.out.println("deliveryUpdateSuccess: " + deliveryUpdateSuccess);
		
		return "redirect:/manager/orders/" + managerOrderDelivery.getOrderSerialNum();
	}
	

}
