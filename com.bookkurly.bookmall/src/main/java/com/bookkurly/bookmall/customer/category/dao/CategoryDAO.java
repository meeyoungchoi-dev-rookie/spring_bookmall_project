package com.bookkurly.bookmall.customer.category.dao;

import java.util.List;

import com.bookkurly.bookmall.customer.category.entity.Book;
import com.bookkurly.bookmall.customer.category.entity.MainCategory;
import com.bookkurly.bookmall.customer.category.entity.SubCategory;

public interface CategoryDAO {

	public List<MainCategory> selectList();

	public List<SubCategory> selectList(Integer mainCateSeq);

	public List<Book> selectList2(Integer subCateSeq);

	public String selectSubcateName(Integer subCateSeq);

	public String selectMaincateName(Integer subCateSeq);

	public String selectMainCate(Integer mainCateSeq);
}
