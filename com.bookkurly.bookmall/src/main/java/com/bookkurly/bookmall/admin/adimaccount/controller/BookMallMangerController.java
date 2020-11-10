package com.bookkurly.bookmall.admin.adimaccount.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookkurly.bookmall.admin.adimaccount.dto.BookMallManagerForm;
import com.bookkurly.bookmall.admin.adimaccount.entity.BookMallManager;

import com.bookkurly.bookmall.admin.adimaccount.service.BookMallMangerService;

@Controller
public class BookMallMangerController {
	
	
	@Autowired
	private BookMallMangerService bookMallManagerService;
	
	
	@GetMapping("/manager/page")
	public String index() {
		return "redirect:/admin/login";
	}
	
	
	@GetMapping("/admin/login")
	public String login() {
		return "admin/login";
	}
	
	
	@PostMapping("/admin/logincheck")
	public String logincheck(BookMallManagerForm bookMallManagerForm, HttpServletRequest request, Model model) {
		System.out.println("admin login: " + bookMallManagerForm.toString());
		
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
		  session.getAttribute("adminlogin");
		return "admin/manager";
	}
	
	
	@GetMapping("/admin/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/manager/page";
	}
}
