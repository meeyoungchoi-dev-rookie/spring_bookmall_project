package com.bookkurly.bookmall.customer.category.dto;

import com.bookkurly.bookmall.customer.category.entity.PurchaseReview;

public class PurchaseReviewDTO {
	private String customId;
	private String purchaseReviewContent;
	private Integer bookSeq;
	private Integer customSeq;
	private Integer orderSeq;
	private String orderSerialNum;
	private String writerStatus;
	
	
	
	
	
	public String getWriterStatus() {
		return writerStatus;
	}
	public void setWriterStatus(String writerStatus) {
		this.writerStatus = writerStatus;
	}
	public String getCustomId() {
		return customId;
	}
	public void setCustomId(String customId) {
		this.customId = customId;
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
	public PurchaseReviewDTO(String customId, String purchaseReviewContent, Integer bookSeq, Integer customSeq,
			Integer orderSeq, String orderSerialNum, String writerStatus) {
		super();
		this.customId = customId;
		this.purchaseReviewContent = purchaseReviewContent;
		this.bookSeq = bookSeq;
		this.customSeq = customSeq;
		this.orderSeq = orderSeq;
		this.orderSerialNum = orderSerialNum;
		this.writerStatus = writerStatus;
	}
	

	@Override
	public String toString() {
		return "PurchaseReviewDTO [customId=" + customId + ", purchaseReviewContent=" + purchaseReviewContent
				+ ", bookSeq=" + bookSeq + ", customSeq=" + customSeq + ", orderSeq=" + orderSeq + ", orderSerialNum="
				+ orderSerialNum + ", writerStatus=" + writerStatus + "]";
	}
	
	public PurchaseReview toEntity() {
		return PurchaseReview.builder().customId(customId).purchaseReviewContent(purchaseReviewContent).bookSeq(bookSeq).customSeq(customSeq).orderSeq(orderSeq).orderSerialNum(orderSerialNum)
				.writerStatus(writerStatus)
				.build();
	}
	
	
	
	
}
