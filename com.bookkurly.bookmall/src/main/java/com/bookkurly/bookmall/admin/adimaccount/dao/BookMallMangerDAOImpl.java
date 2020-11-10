package com.bookkurly.bookmall.admin.adimaccount.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookkurly.bookmall.admin.adimaccount.entity.BookMallManager;

@Repository
public class BookMallMangerDAOImpl implements BookMallManagerDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public BookMallManager selectOne(BookMallManager bm) {
		System.out.println("b");
		return sqlSession.selectOne("BookMallDAO.logincheck", bm);
	}

}
