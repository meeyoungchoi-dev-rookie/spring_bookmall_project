package com.bookkurly.bookmall.customer.jang.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookkurly.bookmall.customer.jang.entity.JangEntity;

@Repository
public class JangDAOImpl implements JangDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void insertToJang(JangEntity entity) {
		sqlSession.insert("JangDAO.insertJangBook", entity);
		
	}

}
