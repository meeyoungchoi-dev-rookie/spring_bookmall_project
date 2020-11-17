package com.bookkurly.bookmall.customer.category.dao;

import com.bookkurly.bookmall.customer.category.entity.PurchaseReview;

public interface PurchaseReviewDAO {
	public Integer insertPurchaseReview(PurchaseReview purchaseReview);

	public PurchaseReview find(Integer purchaseReviewSeq);

	public Integer update(PurchaseReview before);

	public Integer delete(Integer purchaseReviewSeq);

}
