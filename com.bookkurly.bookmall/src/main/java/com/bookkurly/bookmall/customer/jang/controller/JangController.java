package com.bookkurly.bookmall.customer.jang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookkurly.bookmall.customer.category.service.BookServiceImpl;
import com.bookkurly.bookmall.customer.jang.dto.JangForm;
import com.bookkurly.bookmall.customer.jang.entity.JangEntity;
import com.bookkurly.bookmall.customer.jang.service.JangServiceImpl;
import com.bookkurly.bookmall.customer.register.service.CustomerServiceImpl;

@Controller
public class JangController {

	@Autowired
	private JangServiceImpl jangService;

	@Autowired
	private BookServiceImpl bookService;

	@Autowired
	private CustomerServiceImpl customerService;

	static String jangId;
	static Integer customSeq;

	@PostMapping("/book/jangbaguni")
	public String insertJang(JangForm jangForm, HttpSession session) {
		String jangNum = "";
		System.out.println("jangForm: " + jangForm.toString());

		String userId = (String) session.getAttribute("userId");
		System.out.println("userId: " + userId);

		if (session.getAttribute("userJangSession") == null) {
			String sessionName = userId + "jang";
			session.setAttribute("userJangSession", sessionName);
			System.out.println(
					"최조 장바구니 세션 : " + session.getAttribute("userJangSession") + " jangForm: " + jangForm.toString());
			jangNum = jangService.createJangSerialNum();
			System.out.println("jangNum: " + jangNum);
			jangId = jangNum;
			session.setAttribute("jangId", jangId);
			jangForm.setOrderSerialNum(jangNum);

			System.out.println("주문수량: " + jangForm.getBookOrderCnt());
			System.out.println("주문한 책 번호: " + jangForm.getBookSeq());

			Integer bookPrice = bookService.selectBookPrice(jangForm.getBookSeq());
			System.out.println("책 한권 당 가격: " + bookPrice);
			Integer bookOrderCntPrice = jangForm.getBookOrderCnt() * bookPrice;
			System.out.println("책 주문 수량 별 가격: " + bookOrderCntPrice);

			jangForm.setBookOrderCntPrice(bookOrderCntPrice);

			System.out.println("주문한 고객 아이디: " + jangForm.getUserId());
			customSeq = customerService.selectCustomerSeq(jangForm.getUserId());
			System.out.println("주문한 고객 seq: " + customSeq);
			jangForm.setCustomSeq(customSeq);
			jangForm.setOrderPaymentStatus("false");

			System.out.println("최초 장바구니에 담긴 상품: " + jangForm.toString());

			JangEntity entity = jangForm.toEntity();
			System.out.println("최조 장바구니에 담긴 entity: " + entity.toString());
			jangService.insertToJang(entity);

			System.out.println("장바구니 담기 성공");

		} else {

			System.out.println("jangId: " + jangId);
			System.out.println("주문수량: " + jangForm.getBookOrderCnt());
			jangForm.setOrderSerialNum(jangId);

			System.out.println("주문수량: " + jangForm.getBookOrderCnt());
			System.out.println("주문한 책 번호: " + jangForm.getBookSeq());

			Integer bookPrice = bookService.selectBookPrice(jangForm.getBookSeq());
			System.out.println("책 한권 당 가격: " + bookPrice);
			Integer bookOrderCntPrice = jangForm.getBookOrderCnt() * bookPrice;
			System.out.println("책 주문 수량 별 가격: " + bookOrderCntPrice);
			System.out.println("주문한 고객 Id: " + jangForm.getUserId());
			System.out.println("주문한 고객 seq: " + customSeq);
			jangForm.setCustomSeq(customSeq);
			jangForm.setOrderPaymentStatus("false");
			jangForm.setBookOrderCntPrice(bookOrderCntPrice);
			System.out.println("두번째부터 장바구니 담을때: " + session.getAttribute("userJangSession") + " , jangForm: "
					+ jangForm.toString());

			JangEntity entity = jangForm.toEntity();
			System.out.println("최조 장바구니에 담긴 entity: " + entity.toString());

			jangService.insertToJang(entity);
			System.out.println("장바구니 담기 성공");

		}

		return "redirect:/shop/janglist";
	}
	
	
	

}
