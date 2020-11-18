package com.bookkurly.bookmall.customer.jang.dto;

public class OrderRefund {
	private String orderSerialNum;
	private Integer orderSeq;
	private Integer bookOrderCnt;
	private Integer bookSeq;
	private String bookTitle;

	public String getOrderSerialNum() {
		return orderSerialNum;
	}

	public void setOrderSerialNum(String orderSerialNum) {
		this.orderSerialNum = orderSerialNum;
	}

	public Integer getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}

	public Integer getBookOrderCnt() {
		return bookOrderCnt;
	}

	public void setBookOrderCnt(Integer bookOrderCnt) {
		this.bookOrderCnt = bookOrderCnt;
	}

	public Integer getBookSeq() {
		return bookSeq;
	}

	public void setBookSeq(Integer bookSeq) {
		this.bookSeq = bookSeq;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public OrderRefund(String orderSerialNum, Integer orderSeq, Integer bookOrderCnt, Integer bookSeq,
			String bookTitle) {
		super();
		this.orderSerialNum = orderSerialNum;
		this.orderSeq = orderSeq;
		this.bookOrderCnt = bookOrderCnt;
		this.bookSeq = bookSeq;
		this.bookTitle = bookTitle;
	}

	@Override
	public String toString() {
		return "OrderRefund [orderSerialNum=" + orderSerialNum + ", orderSeq=" + orderSeq + ", bookOrderCnt="
				+ bookOrderCnt + ", bookSeq=" + bookSeq + ", bookTitle=" + bookTitle + "]";
	}
}
