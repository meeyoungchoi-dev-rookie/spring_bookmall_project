package com.bookkurly.bookmall.customer.jang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookkurly.bookmall.customer.jang.dto.JangForm;
import com.bookkurly.bookmall.customer.jang.service.JangServiceImpl;


@Controller
public class JangController {

	@Autowired
	private JangServiceImpl jangService;
	
	
	static String jangId;
	
	
	@PostMapping("/book/jangbaguni")
	public String insertJang(JangForm jangForm , HttpSession session) {
		String jangNum = "";
		System.out.println("jangForm: " + jangForm.toString());
		
		String userId = (String)session.getAttribute("userId");
		System.out.println("userId: " + userId);
		
		
		if (session.getAttribute("userJangSession") == null) {
			String sessionName = userId + "jang";
			session.setAttribute("userJangSession", sessionName);
			System.out.println("최조 장바구니 세션 : " + session.getAttribute("userJangSession") + " jangForm: " + jangForm.toString());
			jangNum = jangService.createJangSerialNum();
			System.out.println("jangNum: " + jangNum);
			jangId = jangNum;
			session.setAttribute("jangId", jangId);
			jangForm.setOrderSerialNum(jangNum);
			
			System.out.println("주문수량: " + jangForm.getOrderCnt());
			System.out.println("주문한 책 번호: " + jangForm.getBookSeq());
			
			
			
			
			System.out.println("최초 장바구니에 담긴 상품: " + jangForm.toString() );
			
		} else {
			
				System.out.println("jangId: " + jangId);
				System.out.println("주문수량: " + jangForm.getOrderCnt());
				jangForm.setOrderSerialNum(jangId);
				System.out.println("두번째부터 장바구니 담을때: " + session.getAttribute("userJangSession") + " , jangForm: " + jangForm.toString());
		}
		
		
		
		
		return "";
	}
	
	
}
