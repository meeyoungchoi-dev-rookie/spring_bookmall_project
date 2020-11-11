package com.bookkurly.bookmall.customer.jang.service;

import com.bookkurly.bookmall.customer.jang.entity.JangEntity;

public interface JangService {
	
	String createJangSerialNum();
	
	public void insertToJang(JangEntity entity);

}
