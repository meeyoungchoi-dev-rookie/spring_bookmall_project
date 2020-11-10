package com.bookkurly.bookmall.customer.category.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.sessions.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookkurly.bookmall.customer.category.entity.Book;
import com.bookkurly.bookmall.customer.category.service.BookService;
import com.bookkurly.bookmall.customer.category.service.CategoryService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value ="/book/{bookSeq}/subcateseq/{subCateSeq}", method=RequestMethod.GET)
	public String detail(@PathVariable Integer bookSeq, @PathVariable Integer subCateSeq , Model model ,  HttpServletRequest  request) {
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		String mainCateName = categoryService.selectMaincateName(subCateSeq);
		System.out.println("mainCateName: "  + mainCateName);
		
		
		String subCateName = categoryService.selectSubcateName(subCateSeq);
		System.out.println("subCateName: " + subCateName);
		
		System.out.println("detail/book: bookSeq " + bookSeq);
		Book book = bookService.selectBook(bookSeq);
		System.out.println("book: " + book.toString());
		model.addAttribute("book", book);
		model.addAttribute("subcatename", subCateName);
		model.addAttribute("maincatename", mainCateName);
		model.addAttribute("userId", userId);
		return "shop/book_detail";
	}
}
