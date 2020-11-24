package com.bookkurly.bookmall.customer.category.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookkurly.bookmall.customer.category.entity.Book;
import com.bookkurly.bookmall.customer.category.entity.MainCategory;
import com.bookkurly.bookmall.customer.category.entity.SubCategory;
import com.bookkurly.bookmall.customer.category.service.BookService;
import com.bookkurly.bookmall.customer.category.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/shopping", method = RequestMethod.GET)
	public String mainCateIndex(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		System.out.println("controller");
		List<MainCategory> mainCategories = categoryService.selectList();

		for (MainCategory mc : mainCategories) {
			System.out.println(mc.toString());
		}
		
		List<Book> books = categoryService.selectList2(1);
		System.out.println("books: " + books.toString());

		session.setAttribute("mainCategories", mainCategories);	
//		model.addAttribute("mainCategories", mainCategories);
		model.addAttribute("books", books);
		
		return "shop/categories";
	}

	@RequestMapping(value = "/subacategory/frontend/{mainCateSeq}", method = RequestMethod.GET)
	public String subcateIndex(@PathVariable Integer mainCateSeq, Model model, HttpSession session) {

		List<MainCategory> mainCategories = (List<MainCategory>) session.getAttribute("mainCategories");
		System.out.println("subcategory/frontend mainCateSeq: " + mainCateSeq);
		List<SubCategory> subcategories = categoryService.selectList(mainCateSeq);
		System.out.println("frontend 서브카테고리");
		for (SubCategory sb : subcategories) {
			System.out.println(sb.toString());
		}

		List<Book> books = null;

		//System.out.println(subcategories.get(0).getSubCateSeq());
		books = categoryService.selectList2(subcategories.get(0).getSubCateSeq());

		System.out.println(books.toString());
		//System.out.println(subcategories.get(1).getSubCateSeq());
		List<Book> books2 = categoryService.selectList2(subcategories.get(1).getSubCateSeq());

		//System.out.println(subcategories.get(2).getSubCateSeq());
		List<Book> books3 = categoryService.selectList2(subcategories.get(2).getSubCateSeq());
		System.out.println(books3.toString());

		model.addAttribute("subcategories", subcategories);
		model.addAttribute("books", books);
		model.addAttribute("books2", books2);
		model.addAttribute("books3",books3);

		model.addAttribute("maincategories", mainCategories);
		return "shop/subcategories";
	}
	
	
	
	@GetMapping("/subacategory/backend/{mainCateSeq}" )
	public String backendCate(@PathVariable Integer mainCateSeq, Model model, HttpSession session) {
		System.out.println("subcategroy/backend: " + mainCateSeq);
		
		session.getAttribute("mainCategories");
		
		List<SubCategory> subcategories = categoryService.selectList(mainCateSeq);
		System.out.println("백엔드 서브카테고리");
		for (SubCategory sb : subcategories) {
			System.out.println(sb.toString());
		}
		
		List<Book> books = null;

		//System.out.println(subcategories.get(0).getSubCateSeq());
		books = categoryService.selectList2(subcategories.get(0).getSubCateSeq());

		System.out.println(books.toString());
		//System.out.println(subcategories.get(1).getSubCateSeq());
		List<Book> books2 = categoryService.selectList2(subcategories.get(1).getSubCateSeq());
		System.out.println("books2: " + books2.toString());

		
		model.addAttribute("subcategories", subcategories);
		model.addAttribute("books", books);
		model.addAttribute("books2", books2);
	
		
		return "shop/subcategories";
	}
	

	@RequestMapping(value = "/maincategory/{mainCateSeq}/subcategory/{subCateSeq}", method = RequestMethod.GET)
	public String subCateBook(@PathVariable Integer mainCateSeq, @PathVariable Integer subCateSeq, Model model) {
		System.out.println("subCateBook()  mainCateSeq: " + mainCateSeq + ", subCateSeq: " + subCateSeq);
		
		String mainCateName = categoryService.selectMaincate(mainCateSeq);
		System.out.println("mainCateName: " + mainCateName);

		String subCateName = categoryService.selectSubcateName(subCateSeq);
		System.out.println("subCateName: " + subCateName);
		
		List<SubCategory> subcategories = categoryService.selectList(mainCateSeq);
		System.out.println("서브카테고리항목: " + subcategories.toString());

		List<Book> subcateBooks = bookService.selectList2(subCateSeq);
		System.out.println(subcateBooks.toString());

		model.addAttribute("subatecategories", subcategories);
		model.addAttribute("subcatebooks", subcateBooks);
		model.addAttribute("subCateName", subCateName);
		model.addAttribute("maincate", mainCateName);

		return "shop/html_books";
	}
	
	@GetMapping("/shop/categories")
	public String goCategories() {
		return "shop/categories";
	}

}
