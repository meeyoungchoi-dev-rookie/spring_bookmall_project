package com.bookkurly.bookmall.customer.jang.dao;

import java.util.List;

import com.bookkurly.bookmall.customer.jang.dto.JangInfo;
import com.bookkurly.bookmall.customer.jang.entity.JangEntity;

public interface JangDAO {

	void insertToJang(JangEntity entity);

	List<JangEntity> getCustomerJangList(JangInfo jangInfo);

	
	
}
