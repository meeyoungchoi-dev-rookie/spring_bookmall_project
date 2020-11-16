package com.bookkurly.bookmall.customer.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookkurly.bookmall.customer.category.dao.PurchaseReviewDAO;
import com.bookkurly.bookmall.customer.category.entity.PurchaseReview;

@Service
public class PurchaseReviewServiceImpl implements PurchaseReviewService {

	@Autowired
	private PurchaseReviewDAO purchaseReviewDAO;
	
	
	@Override
	public Integer insertPurchaseReview(PurchaseReview purchaseReview) {
		return purchaseReviewDAO.insertPurchaseReview(purchaseReview);
	}

}
