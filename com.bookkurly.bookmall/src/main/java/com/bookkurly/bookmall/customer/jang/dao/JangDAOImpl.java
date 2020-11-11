package com.bookkurly.bookmall.customer.jang.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookkurly.bookmall.customer.jang.dto.JangInfo;
import com.bookkurly.bookmall.customer.jang.entity.JangEntity;

@Repository
public class JangDAOImpl implements JangDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void insertToJang(JangEntity entity) {
		sqlSession.insert("JangDAO.insertJangBook", entity);
		
	}

	@Override
	public List<JangEntity> getCustomerJangList(JangInfo jangInfo) {
		return sqlSession.selectList("JangDAO.getCustomerJangList", jangInfo);
	}

}
