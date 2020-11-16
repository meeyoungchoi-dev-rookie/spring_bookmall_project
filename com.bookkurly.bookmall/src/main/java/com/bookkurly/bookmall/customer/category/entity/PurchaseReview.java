package com.bookkurly.bookmall.customer.category.entity;

import java.sql.Date;

import javax.persistence.Entity;

import lombok.Builder;

@Entity
public class PurchaseReview {

	private String customId;
	private Integer purchaseReviewSeq;
	private Date purchaseReviewCreatedDate;
	private Date purchaseReviewUpdatedDate;
	private String purchaseReviewContent;
	private Integer bookSeq;
	private Integer customSeq;
	private Integer orderSeq;
	private String orderSerialNum;
	
	
	
	

	
	

	

	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public Integer getPurchaseReviewSeq() {
		return purchaseReviewSeq;
	}

	public void setPurchaseReviewSeq(Integer purchaseReviewSeq) {
		this.purchaseReviewSeq = purchaseReviewSeq;
	}

	public Date getPurchaseReviewCreatedDate() {
		return purchaseReviewCreatedDate;
	}

	public void setPurchaseReviewCreatedDate(Date purchaseReviewCreatedDate) {
		this.purchaseReviewCreatedDate = purchaseReviewCreatedDate;
	}

	public Date getPurchaseReviewUpdatedDate() {
		return purchaseReviewUpdatedDate;
	}

	public void setPurchaseReviewUpdatedDate(Date purchaseReviewUpdatedDate) {
		this.purchaseReviewUpdatedDate = purchaseReviewUpdatedDate;
	}

	public String getPurchaseReviewContent() {
		return purchaseReviewContent;
	}

	public void setPurchaseReviewContent(String purchaseReviewContent) {
		this.purchaseReviewContent = purchaseReviewContent;
	}

	public Integer getBookSeq() {
		return bookSeq;
	}

	public void setBookSeq(Integer bookSeq) {
		this.bookSeq = bookSeq;
	}

	public Integer getCustomSeq() {
		return customSeq;
	}

	public void setCustomSeq(Integer customSeq) {
		this.customSeq = customSeq;
	}

	public Integer getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}

	public String getOrderSerialNum() {
		return orderSerialNum;
	}

	public void setOrderSerialNum(String orderSerialNum) {
		this.orderSerialNum = orderSerialNum;
	}

	public PurchaseReview() {
		super();
	}

	@Builder
	public PurchaseReview(Integer purchaseReviewSeq, Date purchaseReviewCreatedDate, Date purchaseReviewUpdatedDate,
			String purchaseReviewContent, Integer bookSeq, Integer customSeq, Integer orderSeq, String orderSerialNum, String customId) {
		super();
		this.purchaseReviewSeq = purchaseReviewSeq;
		this.purchaseReviewCreatedDate = purchaseReviewCreatedDate;
		this.purchaseReviewUpdatedDate = purchaseReviewUpdatedDate;
		this.purchaseReviewContent = purchaseReviewContent;
		this.bookSeq = bookSeq;
		this.customSeq = customSeq;
		this.orderSeq = orderSeq;
		this.orderSerialNum = orderSerialNum;
		this.customId = customId;
	}

	@Override
	public String toString() {
		return "PurchaseReview [customId=" + customId + ", purchaseReviewSeq=" + purchaseReviewSeq
				+ ", purchaseReviewCreatedDate=" + purchaseReviewCreatedDate + ", purchaseReviewUpdatedDate="
				+ purchaseReviewUpdatedDate + ", purchaseReviewContent=" + purchaseReviewContent + ", bookSeq="
				+ bookSeq + ", customSeq=" + customSeq + ", orderSeq=" + orderSeq + ", orderSerialNum=" + orderSerialNum
				+ "]";
	}


	
	


	
	

}
