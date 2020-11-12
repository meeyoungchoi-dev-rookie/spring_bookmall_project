package com.bookkurly.bookmall.customer.jang.dto;

public class JangUpdate {
	private Integer bookSeq;
	private String bookTitle;
	private Integer bookOrderCnt;
	private String orderSerialNum;
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

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Integer getBookOrderCnt() {
		return bookOrderCnt;
	}

	public void setBookOrderCnt(Integer bookOrderCnt) {
		this.bookOrderCnt = bookOrderCnt;
	}

	public String getOrderSerialNum() {
		return orderSerialNum;
	}

	public void setOrderSerialNum(String orderSerialNum) {
		this.orderSerialNum = orderSerialNum;
	}


	public JangUpdate(Integer bookSeq, String bookTitle, Integer bookOrderCnt, String orderSerialNum,
			Integer bookOrderCntPrice) {
		super();
		this.bookSeq = bookSeq;
		this.bookTitle = bookTitle;
		this.bookOrderCnt = bookOrderCnt;
		this.orderSerialNum = orderSerialNum;
		this.bookOrderCntPrice = bookOrderCntPrice;
	}

	@Override
	public String toString() {
		return "JangUpdate [bookSeq=" + bookSeq + ", bookTitle=" + bookTitle + ", bookOrderCnt=" + bookOrderCnt
				+ ", orderSerialNum=" + orderSerialNum + ", bookOrderCntPrice=" + bookOrderCntPrice + "]";
	}


	
	

}
