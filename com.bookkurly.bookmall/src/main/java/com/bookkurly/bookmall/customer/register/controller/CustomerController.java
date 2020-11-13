package com.bookkurly.bookmall.customer.register.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookkurly.bookmall.customer.jang.dto.OrderDetail;
import com.bookkurly.bookmall.customer.jang.entity.JangEntity;
import com.bookkurly.bookmall.customer.jang.service.JangServiceImpl;
import com.bookkurly.bookmall.customer.register.dto.LoginForm;
import com.bookkurly.bookmall.customer.register.dto.RegisterForm;
import com.bookkurly.bookmall.customer.register.entity.Customer;
import com.bookkurly.bookmall.customer.register.service.CustomerServiceImpl;

@Controller
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;

	@Autowired
	private JangServiceImpl jangService;
	
	
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
		session.setAttribute("customId", loginresult.getCustomId());

		model.addAttribute("loginSession", session.getAttribute("customId"));

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
	
	@GetMapping("/customer/mypage")
	public String mypage() {
		return "customers/mypage";
	}
	
	
	@PostMapping("/mypage/search")
	public String searchOrder(HttpServletRequest request, Model model) {
		String myOrderSerialNum = (String)request.getParameter("myOrderSerialNum");
		System.out.println("search: " + request.getParameter("myOrderSerialNum"));
		
		List<JangEntity> myOrders = jangService.selectAll(myOrderSerialNum);
		
		System.out.println("myOrders: " + myOrders.toString());
		
		model.addAttribute("myOrders", myOrders);
		model.addAttribute("myOrderSerialNum", myOrderSerialNum);
		
		return "customers/mypage";
	}
	
	
	@RequestMapping(value="/order/detail/{myOrderSerialNum}/{bookTitle}", produces="text/plain;charset=UTF-8")
	public String orderDetail(@PathVariable String myOrderSerialNum, @PathVariable String bookTitle, Model model) {
		OrderDetail orderDetail = new OrderDetail(myOrderSerialNum, bookTitle);
		System.out.println("orderDetail: " + orderDetail.toString());
		
		JangEntity jangEntityDetail = jangService.selectOrderDetail(orderDetail);
		System.out.println("jangEntityDetail: " + jangEntityDetail.toString());
		model.addAttribute("jangEntityDetail", jangEntityDetail);
		
		return "customers/mypage_detail";
	}
	
}
