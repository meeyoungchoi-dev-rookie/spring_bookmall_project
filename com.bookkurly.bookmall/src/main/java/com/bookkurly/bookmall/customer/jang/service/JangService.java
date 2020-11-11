package com.bookkurly.bookmall.customer.jang.service;

import java.util.List;

import com.bookkurly.bookmall.customer.jang.dto.JangInfo;
import com.bookkurly.bookmall.customer.jang.entity.JangEntity;

public interface JangService {
	
	String createJangSerialNum();
	
	public void insertToJang(JangEntity entity);
	
	public List<JangEntity> getCustomerJangList(JangInfo jangInfo);

}
