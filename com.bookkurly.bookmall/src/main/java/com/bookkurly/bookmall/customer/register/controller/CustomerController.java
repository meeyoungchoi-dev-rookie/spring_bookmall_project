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

import com.bookkurly.bookmall.customer.category.entity.Book;
import com.bookkurly.bookmall.customer.category.entity.PurchaseReview;
import com.bookkurly.bookmall.customer.category.service.BookServiceImpl;
import com.bookkurly.bookmall.customer.category.service.CategoryServiceImpl;
import com.bookkurly.bookmall.customer.category.service.PurchaseReviewServiceImpl;
import com.bookkurly.bookmall.customer.jang.dto.OrderDetail;
import com.bookkurly.bookmall.customer.jang.dto.OrderRefund;
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

	@Autowired
	private PurchaseReviewServiceImpl purchaseService;
	
	@Autowired
	private BookServiceImpl bookService;
	
	@Autowired
	private CategoryServiceImpl categoryService;
	

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
		
		
		Integer mainCateSeq = categoryService.findMainCateSeq("백엔드");
		System.out.println("mainCateSeq: " + mainCateSeq);

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
		String myOrderSerialNum = (String) request.getParameter("myOrderSerialNum");
		System.out.println("search: " + request.getParameter("myOrderSerialNum"));

		List<JangEntity> myOrders = jangService.selectAll(myOrderSerialNum);

		System.out.println("myOrders: " + myOrders.toString());

		model.addAttribute("myOrders", myOrders);
		model.addAttribute("myOrderSerialNum", myOrderSerialNum);
		model.addAttribute("allOrderDeleteStatus", myOrders.get(0).getAllOrderDeleteStatus());

		return "customers/mypage";
	}

	@RequestMapping(value = "/order/detail/{myOrderSerialNum}/{bookTitle}", produces = "text/plain;charset=UTF-8")
	public String orderDetail(@PathVariable String myOrderSerialNum, @PathVariable String bookTitle, Model model) {
		OrderDetail orderDetail = new OrderDetail(myOrderSerialNum, bookTitle);
		

		JangEntity jangEntityDetail = jangService.selectOrderDetail(orderDetail);
		
		
		if (orderDetail == null && jangEntityDetail == null) {
			model.addAttribute("jangEntityDetail", null);
		} else if (orderDetail != null && jangEntityDetail != null) {
			System.out.println("orderDetail: " + orderDetail.toString());
			System.out.println("jangEntityDetail: " + jangEntityDetail.toString());
			model.addAttribute("jangEntityDetail", jangEntityDetail);

		}
		
		
		return "customers/mypage_detail";
	}

	@GetMapping("/order/delete/{myOrderSerialNum}")
	public String deleteOrders(@PathVariable String myOrderSerialNum, Model model) {
		System.out.println("/order/delete/" + myOrderSerialNum);

		List<PurchaseReview> reviews = purchaseService.findPurchaseReview(myOrderSerialNum);

		List<JangEntity> orderDeleteJangs = null;
		
		if (reviews == null) {
			orderDeleteJangs = jangService.selectAll(myOrderSerialNum);
			System.out.println("orderDeleteJangs: " + orderDeleteJangs);
			
			for (int i = 0; i < orderDeleteJangs.size(); i++) {
				int bookOrderCnt = orderDeleteJangs.get(i).getBookOrderCnt();
				Book book = bookService.selectBook(orderDeleteJangs.get(i).getBookSeq());
				book.setBookAmount(book.getBookAmount() + bookOrderCnt);
				System.out.println("결제 취소후 책 재고수량: " + book.getBookAmount());
				Integer bookUpdateSuccess = bookService.updateBookAmount(book);
				System.out.println("책 재고수량 변견성공여부: " + bookUpdateSuccess);
			}
			
			Integer deleteOrderSuccess = jangService.deleteOrders(myOrderSerialNum);
			System.out.println("전체 결제 취소 상태변경 성공여부: " + deleteOrderSuccess);
	
		} else {
			System.out.println("reviews: " + reviews.toString());
			Integer deletePurchaseReviews = purchaseService.deleteReviews(myOrderSerialNum);
			System.out.println("결제번호 관련 댓글 삭제 성공여부: " + deletePurchaseReviews);
			orderDeleteJangs = jangService.selectAll(myOrderSerialNum);
			System.out.println("orderDeleteJangs: " + orderDeleteJangs);
			
			for (int i = 0; i < orderDeleteJangs.size(); i++) {
				int bookOrderCnt = orderDeleteJangs.get(i).getBookOrderCnt();
				Book book = bookService.selectBook(orderDeleteJangs.get(i).getBookSeq());
				book.setBookAmount(book.getBookAmount() + bookOrderCnt);
				System.out.println("결제 취소후 책 재고수량: " + book.getBookAmount());
				Integer bookUpdateSuccess = bookService.updateBookAmount(book);
				System.out.println("책 재고수량 변견성공여부: " + bookUpdateSuccess);
			}
			
			
			Integer deleteOrderSuccess = jangService.deleteOrders(myOrderSerialNum);
			System.out.println("댓글 삭제후 전체 결제 취소 성공여부: " + deleteOrderSuccess);
			
		
			
		}
		
		model.addAttribute("deletejangs", orderDeleteJangs);

		return "customers/mypage_delete_order";
	}
	
	@PostMapping("/orders/refund")
	public String refund(OrderRefund orderRefund, Model model) {
		System.out.println("/orders/refund: " + orderRefund.toString());
		
		Integer bookSeq = orderRefund.getBookSeq();
		Book book = bookService.selectBook(bookSeq);
		System.out.println("책 정보: " + book.toString());
		
		book.setBookAmount(orderRefund.getBookOrderCnt() + book.getBookAmount());
		Integer bookAmountUpdateSuccess = bookService.updateBookAmount(book);
		System.out.println("도서 재고수량 수정성공여부: " + bookAmountUpdateSuccess);
		
		book = bookService.selectBook(bookSeq);
		System.out.println("도서 환불 성공후 책 정보: " + book.toString());
		
		Integer refundOrderSuccess = jangService.refundOrder(orderRefund);
		System.out.println("도서환불성공여부: " + refundOrderSuccess);
		
		List<JangEntity> myOrders = jangService.selectAll(orderRefund.getOrderSerialNum());
		model.addAttribute("myOrders", myOrders);
		model.addAttribute("myOrderSerialNum", orderRefund.getOrderSerialNum());
		
		return "redirect:/customers/mypage_detail/" + orderRefund.getOrderSerialNum();
	}
	
	
	@GetMapping("/customers/mypage_detail/{orderSerialNum}")
	public String mypage(@PathVariable String orderSerialNum, Model model) {
		List<JangEntity> myOrders = jangService.selectAll(orderSerialNum);
		model.addAttribute("myOrders", myOrders);
		model.addAttribute("myOrderSerialNum", orderSerialNum);
		return "customers/mypage";
	}

}
