package com.bookkurly.bookmall.customer.jang.dto;

public class JangDeleteInfo {

	private Integer bookSeq;
	private String orderSerialNum;

	public Integer getBookSeq() {
		return bookSeq;
	}

	public void setBookSeq(Integer bookSeq) {
		this.bookSeq = bookSeq;
	}

	public String getOrderSerialNum() {
		return orderSerialNum;
	}

	public void setOrderSerialNum(String orderSerialNum) {
		this.orderSerialNum = orderSerialNum;
	}

	public JangDeleteInfo(Integer bookSeq, String orderSerialNum) {
		super();
		this.bookSeq = bookSeq;
		this.orderSerialNum = orderSerialNum;
	}

	@Override
	public String toString() {
		return "JangDeleteInfo [bookSeq=" + bookSeq + ", orderSerialNum=" + orderSerialNum + "]";
	}

}
