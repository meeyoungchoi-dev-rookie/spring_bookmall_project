package com.bookkurly.bookmall.customer.category.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookkurly.bookmall.customer.category.entity.PurchaseReview;

@Repository
public class PurchaseReviewDAOImpl implements PurchaseReviewDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public Integer insertPurchaseReview(PurchaseReview purchaseReview) {
		return sqlSession.insert("PurchaseReviewDAO.insert", purchaseReview);
		
	}
	
	
	

}
