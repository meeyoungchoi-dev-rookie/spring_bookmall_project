package com.bookkurly.bookmall.customer.jang.dto;

public class OrderDetail {
	private String myOrderSerialNum;
	private String bookTitle;

	public String getMyOrderSerialNum() {
		return myOrderSerialNum;
	}

	public void setMyOrderSerialNum(String myOrderSerialNum) {
		this.myOrderSerialNum = myOrderSerialNum;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public OrderDetail(String myOrderSerialNum, String bookTitle) {
		super();
		this.myOrderSerialNum = myOrderSerialNum;
		this.bookTitle = bookTitle;
	}

	@Override
	public String toString() {
		return "OrderDetail [myOrderSerialNum=" + myOrderSerialNum + ", bookTitle=" + bookTitle + "]";
	}

}
