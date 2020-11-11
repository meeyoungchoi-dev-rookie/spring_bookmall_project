package com.bookkurly.bookmall.customer.jang.entity;

import java.sql.Date;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class JangEntity {

	private Integer orderSeq;
	private String orderSerialNum;
	private Integer bookOrederCnt;
	private Integer bookSeq;
	private Integer customSeq;
	private Integer bookOrderCntPrice;
	private String orderPaymentStatus;
	private Date orderDate;

	@Builder
	public JangEntity(Integer orderSeq, String orderSerialNum, Integer bookOrederCnt, Integer bookSeq,
			Integer customSeq, Integer bookOrderCntPrice, String orderPaymentStatus, Date orderDate) {
		super();
		this.orderSeq = orderSeq;
		this.orderSerialNum = orderSerialNum;
		this.bookOrederCnt = bookOrederCnt;
		this.bookSeq = bookSeq;
		this.customSeq = customSeq;
		this.bookOrderCntPrice = bookOrderCntPrice;
		this.orderPaymentStatus = orderPaymentStatus;
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "JangEntity [orderSeq=" + orderSeq + ", orderSerialNum=" + orderSerialNum + ", bookOrederCnt="
				+ bookOrederCnt + ", bookSeq=" + bookSeq + ", customSeq=" + customSeq + ", bookOrderCntPrice="
				+ bookOrderCntPrice + ", orderPaymentStatus=" + orderPaymentStatus + ", orderDate=" + orderDate + "]";
	}

}
