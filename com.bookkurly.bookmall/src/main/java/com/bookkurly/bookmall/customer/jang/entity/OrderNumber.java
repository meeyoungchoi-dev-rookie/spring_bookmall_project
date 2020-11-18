package com.bookkurly.bookmall.customer.jang.entity;

import javax.persistence.Entity;

import lombok.Getter;

@Getter
@Entity
public class OrderNumber {
	private Integer orderSeq;
	private String orderSerialNum;
	
	@Override
	public String toString() {
		return "OrderNumber [orderSeq=" + orderSeq + ", orderSerialNum=" + orderSerialNum + "]";
	}

}
