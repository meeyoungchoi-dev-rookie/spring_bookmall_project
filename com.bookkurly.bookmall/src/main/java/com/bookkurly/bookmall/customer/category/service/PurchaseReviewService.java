package com.bookkurly.bookmall.customer.category.service;

import com.bookkurly.bookmall.customer.category.entity.PurchaseReview;

public interface PurchaseReviewService {
	public Integer insertPurchaseReview(PurchaseReview purchaseReview);

	public PurchaseReview find(Integer purchaseReviewSeq);

	public Integer update(PurchaseReview before);

	public Integer delete(Integer purchaseReviewSeq);
}
