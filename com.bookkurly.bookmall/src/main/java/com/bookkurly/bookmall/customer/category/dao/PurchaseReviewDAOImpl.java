package com.bookkurly.bookmall.customer.category.dao;

import java.util.List;

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


	@Override
	public PurchaseReview find(Integer purchaseReviewSeq) {
		return sqlSession.selectOne("PurchaseReviewDAO.find", purchaseReviewSeq);
	}


	@Override
	public Integer update(PurchaseReview before) {
		return sqlSession.update("PurchaseReviewDAO.update", before);
	}


	@Override
	public Integer delete(Integer purchaseReviewSeq) {
		return sqlSession.delete("PurchaseReviewDAO.delete", purchaseReviewSeq);
	}


	@Override
	public List<PurchaseReview> findPurchaseReview(String myOrderSerialNum) {
		return sqlSession.selectList("PurchaseReviewDAO.findPurchaseReview", myOrderSerialNum);
	}


	@Override
	public Integer deleteReviews(String myOrderSerialNum) {
		return sqlSession.delete("PurchaseReviewDAO.deleteReviews", myOrderSerialNum);
	}
	
	
	

}
