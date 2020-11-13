package com.bookkurly.bookmall.customer.jang.dto;

import java.sql.Date;

import com.bookkurly.bookmall.customer.jang.entity.JangEntity;

public class JangForm {
	private String orderSerialNum;
	private Date orderDate;
	private String orderPaymentStatus;
	private Integer bookOrderCnt;
	private Integer bookOrderCntPrice;
	private Integer bookSeq;
	private Integer customSeq;
	private String customId;
	private String bookTitle;
	
	
	

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	
	
	
	

	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public Integer getBookOrderCntPrice() {
		return bookOrderCntPrice;
	}

	public void setBookOrderCntPrice(Integer bookOrderCntPrice) {
		this.bookOrderCntPrice = bookOrderCntPrice;
	}

	public Integer getBookSeq() {
		return bookSeq;
	}

	public void setBookSeq(Integer bookSeq) {
		this.bookSeq = bookSeq;
	}

	public Integer getCustomSeq() {
		return customSeq;
	}

	public void setCustomSeq(Integer customSeq) {
		this.customSeq = customSeq;
	}

	public Integer getBookOrderCnt() {
		return bookOrderCnt;
	}

	public void setBookOrderCnt(Integer bookOrderCnt) {
		this.bookOrderCnt = bookOrderCnt;
	}

	public String getOrderPaymentStatus() {
		return orderPaymentStatus;
	}

	public void setOrderPaymentStatus(String orderPaymentStatus) {
		this.orderPaymentStatus = orderPaymentStatus;
	}

	public String getOrderSerialNum() {
		return orderSerialNum;
	}

	public void setOrderSerialNum(String orderSerialNum) {
		this.orderSerialNum = orderSerialNum;
	}

	public JangForm(String orderSerialNum, Date orderDate, String orderPaymentStatus, Integer bookOrderCnt,
			Integer bookOrderCntPrice, Integer bookSeq, Integer customSeq, String customId, String bookTitle) {
		super();
		this.orderSerialNum = orderSerialNum;
		this.orderDate = orderDate;
		this.orderPaymentStatus = orderPaymentStatus;
		this.bookOrderCnt = bookOrderCnt;
		this.bookOrderCntPrice = bookOrderCntPrice;
		this.bookSeq = bookSeq;
		this.customSeq = customSeq;
		this.customId = customId;
		this.bookTitle = bookTitle;
	}

	public JangEntity toEntity() {
		return JangEntity.builder().orderSerialNum(orderSerialNum).orderDate(orderDate)
				.orderPaymentStatus(orderPaymentStatus).bookOrderCnt(bookOrderCnt).bookOrderCntPrice(bookOrderCntPrice)
				.bookSeq(bookSeq).customSeq(customSeq).bookTitle(bookTitle).build();
	}

	@Override
	public String toString() {
		return "JangForm [orderSerialNum=" + orderSerialNum + ", orderDate=" + orderDate + ", orderPaymentStatus="
				+ orderPaymentStatus + ", bookOrderCnt=" + bookOrderCnt + ", bookSeq=" + bookSeq + ", customSeq="
				+ customSeq + ", customId=" + customId + ", bookOrderCntPrice=" + bookOrderCntPrice + "]";
	}

}
