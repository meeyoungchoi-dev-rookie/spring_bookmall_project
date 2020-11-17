package com.bookkurly.bookmall.customer.category.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.sessions.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookkurly.bookmall.customer.category.dto.PurchaseReviewDTO;
import com.bookkurly.bookmall.customer.category.entity.Book;
import com.bookkurly.bookmall.customer.category.entity.CheckJang;
import com.bookkurly.bookmall.customer.category.entity.PurchaseReview;
import com.bookkurly.bookmall.customer.category.service.BookService;
import com.bookkurly.bookmall.customer.category.service.CategoryService;
import com.bookkurly.bookmall.customer.category.service.PurchaseReviewService;
import com.bookkurly.bookmall.customer.jang.entity.JangEntity;
import com.bookkurly.bookmall.customer.jang.service.JangService;
import com.bookkurly.bookmall.customer.register.service.CustomerService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private JangService jangService;
	
	@Autowired
	private  PurchaseReviewService purchaseReviewService;
	
	
	
	@RequestMapping(value ="/book/{bookSeq}/subcateseq/{subCateSeq}", method=RequestMethod.GET)
	public String detail(@PathVariable Integer bookSeq, @PathVariable Integer subCateSeq , Model model ,  HttpServletRequest  request) {
		boolean checkreview = false;
		boolean checkJang = false;
		Integer customSeq = 0;
		System.out.println("/book/" + bookSeq + "/subcateseq/" + subCateSeq);
		
		HttpSession session = request.getSession();
		String customId = (String)session.getAttribute("customId");
		
		List<JangEntity> jangs = null;
		if (customId != null) {
			System.out.println("customId: " + customId);
			
			customSeq = customerService.selectCustomerSeq(customId);
			System.out.println("customSeq: " + customSeq);
			CheckJang check = new CheckJang(customSeq, bookSeq);
			
			jangs = jangService.selectJang(check);
			
			
			System.out.println( "jangs: " + jangs.toString());
			
		}
		
		//로그인이 안되있고 그냥 책을 조회할때
		//customSeq = customerService.selectCustomerSeq(customId);
		System.out.println("customSeq: " + customSeq);
		
		
		Integer mainCateSeq = categoryService.selectMainCateSeq(subCateSeq);
		
		
		String mainCateName = categoryService.selectMaincateName(mainCateSeq);
		System.out.println("mainCateName: "  + mainCateName);
		
		
		String subCateName = categoryService.selectSubcateName(subCateSeq);
		System.out.println("subCateName: " + subCateName);
		
		System.out.println("detail/book: bookSeq " + bookSeq);
		Book book = bookService.selectBook(bookSeq);
		System.out.println("book: " + book.toString());
		
		
		List<PurchaseReview> purchaseReviews = bookService.selectPurchaseReview(bookSeq);
		System.out.println("purchaseReviews: " + purchaseReviews.toString());
		
	
		
		model.addAttribute("book", book);
		model.addAttribute("subcatename", subCateName);
		model.addAttribute("maincatename", mainCateName);
		model.addAttribute("userId", customId);
		model.addAttribute("bookSeq", bookSeq);
		model.addAttribute("reviews", purchaseReviews);
		model.addAttribute("jangs", jangs);
		model.addAttribute("customSeq", customSeq);
		return "shop/book_detail";
	}
	
	
	@PostMapping("/review/{bookSeq}")
	public String createReview(@PathVariable Integer bookSeq, PurchaseReviewDTO purchaseReviewDTO) {
		System.out.println("purchaseReviewDTO: " + purchaseReviewDTO.toString());
		
		String customId = purchaseReviewDTO.getCustomId();
		Integer customSeq = customerService.selectCustomerSeq(customId);
		
		purchaseReviewDTO.setCustomSeq(customSeq);
		purchaseReviewDTO.setWriterStatus("true");
		
		CheckJang jangCheck = new CheckJang(customSeq, bookSeq);
		List<JangEntity> jangs = jangService.selectJang(jangCheck);
		
		System.out.println("jangs: " + jangs.toString());
		
		int orderSeq = 0;
		String orderSerialNum = "";
		for (int i = 0; i < jangs.size(); i++) {
			if (jangs.get(i).getBookSeq() == bookSeq) {
				orderSeq = jangs.get(i).getOrderSeq();
				orderSerialNum = jangs.get(i).getOrderSerialNum();
			}
		}
		
		purchaseReviewDTO.setOrderSeq(orderSeq);
		purchaseReviewDTO.setOrderSerialNum(orderSerialNum);
		
		customId = customerService.findCustomerName(purchaseReviewDTO.getCustomSeq());
		purchaseReviewDTO.setCustomId(customId);
		System.out.println("purchaseReviewDTO: " + purchaseReviewDTO.toString());
		PurchaseReview entity = purchaseReviewDTO.toEntity();
		System.out.println("entity: " + entity.toString());
		
		purchaseReviewService.insertPurchaseReview(entity);
		
		Book book = categoryService.findBook(bookSeq);
		System.out.println("book: " + book.toString());
		
		
		return "redirect:/book/" + bookSeq + "/subcateseq/" + book.getSubCateSeq();
	}
	
	@PostMapping("/review/update/{purchaseReviewSeq}")
	public String updateReview(@PathVariable Integer purchaseReviewSeq, PurchaseReviewDTO purchaseReviewDTO) {
		PurchaseReview before = purchaseReviewService.find(purchaseReviewSeq);
		System.out.println("수정전: " + before.toString());
		
		
		System.out.println("purchaseReviewDTO: " + purchaseReviewDTO.toString());
		
		before.rewrite(purchaseReviewDTO.getPurchaseReviewContent());
		System.out.println("수정후: " + before.toString());
		
		Integer updateSuccess = purchaseReviewService.update(before);
		System.out.println("updateSuccess: " + updateSuccess);
		
		
		Integer subCateSeq = categoryService.selectSubCateSeq(before.getBookSeq());
		System.out.println("subCateSeq: " + subCateSeq);
		return "redirect:/book/" + before.getBookSeq() + "/subcateseq/" + subCateSeq;
	}
	
	
	@GetMapping("/review/{purchaseReviewSeq}/delete/{bookSeq}")
	public String deleteReview(@PathVariable Integer purchaseReviewSeq, @PathVariable Integer bookSeq) {
		System.out.println("/review/" + purchaseReviewSeq + "/delete/" + bookSeq);
		
		Integer deleteSuccess = purchaseReviewService.delete(purchaseReviewSeq);
		System.out.println("댓글 삭제 성공여부: " + deleteSuccess);
		
		
		Integer subCateSeq = categoryService.selectSubCateSeq(bookSeq);
		System.out.println("subCateSeq: " + subCateSeq);
		
		return "redirect:/book/" + bookSeq + "/subcateseq/" + subCateSeq;
	}

}
