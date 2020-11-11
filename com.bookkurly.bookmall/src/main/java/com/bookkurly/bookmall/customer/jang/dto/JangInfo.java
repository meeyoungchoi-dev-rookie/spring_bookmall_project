package com.bookkurly.bookmall.customer.jang.dto;

public class JangInfo {

	private Integer customSeq;
	private String orderSerialNum;
	
	public Integer getCustomSeq() {
		return customSeq;
	}

	public void setCustomSeq(Integer customSeq) {
		this.customSeq = customSeq;
	}

	public String getOrderSerialNum() {
		return orderSerialNum;
	}

	public void setOrderSerialNum(String orderSerialNum) {
		this.orderSerialNum = orderSerialNum;
	}

	public JangInfo(Integer customSeq, String orderSerialNum) {
		super();
		this.customSeq = customSeq;
		this.orderSerialNum = orderSerialNum;
	}

	@Override
	public String toString() {
		return "JangInfo [customSeq=" + customSeq + ", orderSerialNum=" + orderSerialNum + "]";
	}

	

}
