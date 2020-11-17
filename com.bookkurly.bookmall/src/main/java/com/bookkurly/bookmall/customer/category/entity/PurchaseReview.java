package com.bookkurly.bookmall.customer.category.entity;

import java.sql.Date;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;

@Getter
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
	private String writerStatus;
	

	public PurchaseReview() {
		super();
	}

	@Builder
	public PurchaseReview(Integer purchaseReviewSeq, Date purchaseReviewCreatedDate, Date purchaseReviewUpdatedDate,
			String purchaseReviewContent, Integer bookSeq, Integer customSeq, Integer orderSeq, String orderSerialNum, String customId, String writerStatus) {
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
		this.writerStatus = writerStatus;
	}

	@Override
	public String toString() {
		return "PurchaseReview [customId=" + customId + ", purchaseReviewSeq=" + purchaseReviewSeq
				+ ", purchaseReviewCreatedDate=" + purchaseReviewCreatedDate + ", purchaseReviewUpdatedDate="
				+ purchaseReviewUpdatedDate + ", purchaseReviewContent=" + purchaseReviewContent + ", bookSeq="
				+ bookSeq + ", customSeq=" + customSeq + ", orderSeq=" + orderSeq + ", orderSerialNum=" + orderSerialNum
				+ ", writerStatus=" + writerStatus + "]";
	}

	public void rewrite(String purchaseReviewContent) {
		this.purchaseReviewContent = purchaseReviewContent;
		
	}

	
	


	
	


	
	

}
