package com.bookkurly.bookmall.admin.adimaccount.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookkurly.bookmall.admin.adimaccount.dto.AdminMainCategoryForm;
import com.bookkurly.bookmall.admin.adimaccount.dto.BookMallManagerForm;
import com.bookkurly.bookmall.admin.adimaccount.entity.AdminMainCategory;
import com.bookkurly.bookmall.admin.adimaccount.entity.AdminSubCategory;
import com.bookkurly.bookmall.admin.adimaccount.entity.BookMallManager;

import com.bookkurly.bookmall.admin.adimaccount.service.BookMallMangerService;
import com.bookkurly.bookmall.customer.category.entity.Book;
import com.bookkurly.bookmall.customer.category.entity.MainCategory;
import com.bookkurly.bookmall.customer.category.entity.SubCategory;
import com.bookkurly.bookmall.customer.category.service.CategoryService;

@Controller
public class BookMallMangerController {
	
	
	@Autowired
	private BookMallMangerService bookMallManagerService;
	
	
	@Autowired
	private CategoryService categoryService;
	
	
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
		
		BookMallManager bm  = bookMallManagerForm.toEntity();
		System.out.println(bm.toString());
		
		bm = bookMallManagerService.logincheck(bm);
		System.out.println(bm.toString());
		
		HttpSession session = request.getSession();
		session.setAttribute("adminlogin", bm.getAdminId());
		System.out.println( session.getAttribute("adminlogin"));
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
	
	
	@GetMapping("/manager/maincategory/{mainCateName}/detail/{mainCateSeq}")
	public String detailMaincategory(@PathVariable String mainCateName, @PathVariable Integer mainCateSeq, Model model) {
		System.out.println("/manager/maincategory/detail: mainCateName= " + mainCateName + " , mainCateSeq: " + mainCateSeq );
		
		
		MainCategory mainCate = new MainCategory(mainCateSeq, mainCateName);
		System.out.println("mainCate: " + mainCate.toString());
		List<SubCategory> subCategories = categoryService.selectSubCateList(mainCate);
		
		System.out.println("subCategories: " + subCategories.toString());
		System.out.println("==========서브카테고리의 특정 항목에 속한 도서수량============");
		
		for (int i = 0; i < subCategories.size(); i++) {
			int subCateBookCount = 0;
			List<Book> books = categoryService.countAllBooksInSubCateName(subCategories.get(i));
			System.out.println(subCategories.get(i).getSubCateSeq()+ "번 서브카테고리에 속한 도서: " + books.toString());
			subCateBookCount = books.size();
			System.out.println("서브카테고리 " + subCategories.get(i).getSubCateName() + "에 속한 도서수량: " + subCateBookCount);
			subCategories.get(i).setSubCateBookCount(subCateBookCount);
		}
	
		model.addAttribute("subCategories", subCategories);	
		model.addAttribute("mainCate", mainCate);
		return "admin/sub_cate_page";
	}
	
	
	@GetMapping("/manager/subcatename/book/{subCateName}/{subCateSeq}/{mainCateName}")
	public String detailSubCateBook(@PathVariable String subCateName, @PathVariable Integer subCateSeq, @PathVariable String mainCateName ,Model model) {
		System.out.println("/manager/subcatenam/book: subCateName= " + subCateName + " , subCateSeq= " + subCateSeq + " , mainCateName= " + mainCateName);
		
		
		SubCategory subCategory = new SubCategory(subCateSeq, 0, subCateName, 0);
		System.out.println("subCategory: " + subCategory.toString());
		
	
		List<Book> books = categoryService.countAllBooksInSubCateName(subCategory);
		System.out.println("books: " + books.toString());
		
		model.addAttribute("books", books);
		model.addAttribute("mainCateName", mainCateName);
		model.addAttribute("subCateName", subCateName);
		
		return "admin/books";
	}
	
	
	@GetMapping("/manager/book/{bookSeq}/subcateseq/{subCateSeq}/{mainCateName}/{subCateName}")
	public String bookInSubcate(@PathVariable Integer bookSeq, @PathVariable Integer subCateSeq,
			 @PathVariable String mainCateName, @PathVariable String subCateName ,Model model) {
		System.out.println("/manager/book=> bookSeq: " + bookSeq + " , subCateSeq: " + subCateSeq);
		
		Book book = categoryService.findBook(bookSeq);
		book.setSubCateName(subCateName);
		System.out.println("도서정보를 디비에서 가져온후: " + book.toString());
		
		model.addAttribute("book", book);
		model.addAttribute("mainCateName", mainCateName);
		return "admin/book_detail";
	}
	
	
	@PostMapping("/manager/book/update/{bookSeq}/{mainCateName}")
	public String update(@PathVariable Integer bookSeq, @PathVariable String mainCateName, Model model) {
		System.out.println("/manager/book/update");
		
		Book book = categoryService.findBook(bookSeq);
		System.out.println("book: " + book.toString());
		
		System.out.println("mainCateName: " + mainCateName);
		
		String subCateName = categoryService.selectSubcateName(book.getSubCateSeq());
		book.setSubCateName(subCateName);
		System.out.println("subCateName: " + subCateName);

		
		model.addAttribute("book", book);
		model.addAttribute("mainCateName", mainCateName);
		
		return "admin/book_update";
	}
	
	@PostMapping("/manager/book/update/{mainCateName}")
	public String updateBook(Book book, @PathVariable String mainCateName) {
		System.out.println("/manager/book/update/" + mainCateName);
		System.out.println("book: " + book.toString());
		Integer bookSeq = categoryService.findBookSeq(book);
		System.out.println("bookSeq: " + bookSeq);
		return "redirect:/manager/maincategories";
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
	
	
	@GetMapping("/manager/add/subcategory/{mainCateName}")
	public String addSubcategory(@PathVariable String mainCateName, Model model) {
		System.out.println("/manager/add/subcategory/" + mainCateName);
		Integer mainCateSeq = categoryService.findMainCateSeq(mainCateName);
		
		System.out.println("mainCateSeq: " + mainCateSeq);
		
		model.addAttribute("mainCateName", mainCateName);
		model.addAttribute("mainCateSeq", mainCateSeq);
		return "admin/add_subcate";
	}
	
	@PostMapping("/manager/add/subcate")
	public String createSubcate(AdminSubCategory adminSubCategory) {
		System.out.println("/manager/ad/subcate");
		System.out.println("adminSubCategory: " + adminSubCategory);
		
		
		Integer subCateInsertSuccess = categoryService.insertSubCategory(adminSubCategory);
		System.out.println("subCateInsertSuccess: " + subCateInsertSuccess );
		
		return "redirect:/manager/maincategories";
	}
	
	
	
}
