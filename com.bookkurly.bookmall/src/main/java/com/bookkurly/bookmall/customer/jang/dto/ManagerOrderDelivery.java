package com.bookkurly.bookmall.customer.jang.dto;

public class ManagerOrderDelivery {
	private String orderSerialNum;
	private String orderDeliveryStatus;
	private Integer bookSeq;

	public String getOrderSerialNum() {
		return orderSerialNum;
	}

	public void setOrderSerialNum(String orderSerialNum) {
		this.orderSerialNum = orderSerialNum;
	}

	public String getOrderDeliveryStatus() {
		return orderDeliveryStatus;
	}

	public void setOrderDeliveryStatus(String orderDeliveryStatus) {
		this.orderDeliveryStatus = orderDeliveryStatus;
	}

	public Integer getBookSeq() {
		return bookSeq;
	}

	public void setBookSeq(Integer bookSeq) {
		this.bookSeq = bookSeq;
	}

	public ManagerOrderDelivery(String orderSerialNum, String orderDeliveryStatus, Integer bookSeq) {
		super();
		this.orderSerialNum = orderSerialNum;
		this.orderDeliveryStatus = orderDeliveryStatus;
		this.bookSeq = bookSeq;
	}

	@Override
	public String toString() {
		return "ManagerOrderDelivery [orderSerialNum=" + orderSerialNum + ", orderDeliveryStatus=" + orderDeliveryStatus
				+ ", bookSeq=" + bookSeq + "]";
	}

}
