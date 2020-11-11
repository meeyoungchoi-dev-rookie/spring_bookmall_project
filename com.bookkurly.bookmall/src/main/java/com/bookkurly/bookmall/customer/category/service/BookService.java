package com.bookkurly.bookmall.customer.category.service;

import java.util.List;

import com.bookkurly.bookmall.customer.category.entity.Book;

public interface BookService {
	public List<Book> selectList(Integer subCateSeq);

	public List<Book> selectList2(Integer subCateSeq);

	public Book selectBook(Integer bookSeq);
	
	public Integer selectBookPrice(Integer bookSeq); 

	public String findBookTitle(Integer bookSeq);

}
