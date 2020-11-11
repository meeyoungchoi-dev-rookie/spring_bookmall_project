package com.bookkurly.bookmall.customer.category.dao;

import java.util.List;

import com.bookkurly.bookmall.customer.category.entity.Book;

public interface BookDAO {
	public List<Book> selectList(Integer subCateSeq);

	public List<Book> selectList2(Integer subCateSeq);

	public Book selectBook(Integer bookSeq);

	public Integer selectBkookPrice(Integer bookSeq);

	public String findBookTitle(Integer bookSeq);

}
