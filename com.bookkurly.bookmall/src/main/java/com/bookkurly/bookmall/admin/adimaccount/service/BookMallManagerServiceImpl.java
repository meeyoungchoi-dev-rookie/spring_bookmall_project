package com.bookkurly.bookmall.admin.adimaccount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookkurly.bookmall.admin.adimaccount.dao.BookMallManagerDAO;
import com.bookkurly.bookmall.admin.adimaccount.entity.BookMallManager;

@Service
public class BookMallManagerServiceImpl implements BookMallMangerService{

	@Autowired
	private BookMallManagerDAO bookMallMangerdao;
	
	
	@Override
	public BookMallManager logincheck(BookMallManager bm) {
		return bookMallMangerdao.selectOne(bm);
	}

}
