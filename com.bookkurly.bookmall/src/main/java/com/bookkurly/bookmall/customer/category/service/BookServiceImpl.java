package com.bookkurly.bookmall.customer.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookkurly.bookmall.customer.category.dao.BookDAO;
import com.bookkurly.bookmall.customer.category.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDAO bookDao;

	@Override
	public List<Book> selectList(Integer subCateSeq) {
		return bookDao.selectList(subCateSeq);
	}

	@Override
	public List<Book> selectList2(Integer subCateSeq) {
		return bookDao.selectList2(subCateSeq);
	}

	@Override
	public Book selectBook(Integer bookSeq) {
		return bookDao.selectBook(bookSeq);
	}



}
