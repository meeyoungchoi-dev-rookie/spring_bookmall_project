package com.bookkurly.bookmall.customer.jang.entity;

import java.sql.Date;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
@Entity
public class JangEntity {

	private Integer orderSeq;
	private String orderSerialNum;
	private Date orderDate;
	private String orderPaymentStatus;
	private Integer bookOrderCnt;
	private Integer bookOrderCntPrice;
	private Integer bookSeq;
	private Integer customSeq;
	private String bookTitle;
	private String orderDeliveryStatus;
	private String allOrderDeleteStatus;
	private String productRefundstatus;


	@Override
	public String toString() {
		return "JangEntity [orderSeq=" + orderSeq + ", orderSerialNum=" + orderSerialNum + ", orderDate=" + orderDate
				+ ", orderPaymentStatus=" + orderPaymentStatus + ", bookOrderCnt=" + bookOrderCnt
				+ ", bookOrderCntPrice=" + bookOrderCntPrice + ", bookSeq=" + bookSeq + ", customSeq=" + customSeq
				+ ", bookTitle=" + bookTitle + ", orderDeliveryStatus=" + orderDeliveryStatus
				+ ", allOrderDeleteStatus=" + allOrderDeleteStatus + ", productRefundstatus=" + productRefundstatus
				+ "]";
	}


	@Builder
	public JangEntity(Integer orderSeq, String orderSerialNum, Date orderDate, String orderPaymentStatus,
			Integer bookOrderCnt, Integer bookOrderCntPrice, Integer bookSeq, Integer customSeq, String bookTitle,
			String orderDeliveryStatus, String allOrderDeleteStatus, String productRefundstatus) {
		super();
		this.orderSeq = orderSeq;
		this.orderSerialNum = orderSerialNum;
		this.orderDate = orderDate;
		this.orderPaymentStatus = orderPaymentStatus;
		this.bookOrderCnt = bookOrderCnt;
		this.bookOrderCntPrice = bookOrderCntPrice;
		this.bookSeq = bookSeq;
		this.customSeq = customSeq;
		this.bookTitle = bookTitle;
		this.orderDeliveryStatus = orderDeliveryStatus;
		this.allOrderDeleteStatus = allOrderDeleteStatus;
		this.productRefundstatus = productRefundstatus;
	}


	
	
}
