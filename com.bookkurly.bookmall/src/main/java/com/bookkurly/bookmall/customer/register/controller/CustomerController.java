package com.bookkurly.bookmall.customer.register.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookkurly.bookmall.customer.register.dto.LoginForm;
import com.bookkurly.bookmall.customer.register.dto.RegisterForm;
import com.bookkurly.bookmall.customer.register.entity.Customer;
import com.bookkurly.bookmall.customer.register.service.CustomerServiceImpl;

@Controller
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;

	@GetMapping("/customer/login")
	public String login() {
		return "customers/login";
	}

	@PostMapping("/customer/logincheck")
	public String loginCheck(LoginForm loginForm, HttpServletRequest request, Model model) {
		System.out.println("loginForm: " + loginForm.toString());
		Customer login = loginForm.toEntity();
		System.out.println("login: " + login.toString());
		Customer loginresult = customerService.checkLogin(login);
		System.out.println("login: " + loginresult.toString());

		HttpSession session = request.getSession();
		session.setAttribute("userId", loginresult.getCustomId());

		model.addAttribute("loginSession", session.getAttribute("userId"));

		return "redirect:/shopping";
	}

	@GetMapping("/customer/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/shopping";
	}

	@GetMapping("/customer/register")
	public String register() {
		return "customers/register";
	}

	@PostMapping("/customer/register")
	public String regist(RegisterForm registerForm) {
		System.out.println("registerForm: " + registerForm.toString());

		Customer registCustomer = registerForm.toEntity();
		System.out.println("registCustomer: " + registCustomer);

		customerService.regist(registCustomer);
		System.out.println("회원가입성공");

		return "redirect:/customer/login";
	}
}
