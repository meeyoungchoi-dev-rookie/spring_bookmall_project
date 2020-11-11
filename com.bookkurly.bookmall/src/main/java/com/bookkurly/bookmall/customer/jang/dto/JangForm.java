package com.bookkurly.bookmall.customer.jang.dto;

public class JangForm {
	private String orderSerialNum;
	private Integer bookSeq;
	private String userId;
	private Integer orderCnt;
	private Integer bookOrderCntPrice;
	

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getOrderCnt() {
		return orderCnt;
	}

	public void setOrderCnt(Integer orderCnt) {
		this.orderCnt = orderCnt;
	}

	public String getOrderSerialNum() {
		return orderSerialNum;
	}

	public void setOrderSerialNum(String orderSerialNum) {
		this.orderSerialNum = orderSerialNum;
	}

	public JangForm(String orderSerialNum, Integer bookSeq, String userId, Integer orderCnt,
			Integer bookOrderCntPrice) {
		super();
		this.orderSerialNum = orderSerialNum;
		this.bookSeq = bookSeq;
		this.userId = userId;
		this.orderCnt = orderCnt;
		this.bookOrderCntPrice = bookOrderCntPrice;
	}

	@Override
	public String toString() {
		return "JangForm [orderSerialNum=" + orderSerialNum + ", bookSeq=" + bookSeq + ", userId=" + userId
				+ ", orderCnt=" + orderCnt + ", bookOrderCntPrice=" + bookOrderCntPrice + "]";
	}

}
