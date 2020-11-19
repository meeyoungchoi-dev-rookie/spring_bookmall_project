package com.bookkurly.bookmall.customer.category.dao;

import java.util.List;

import com.bookkurly.bookmall.admin.adimaccount.entity.AdminMainCategory;
import com.bookkurly.bookmall.admin.adimaccount.entity.AdminSubCategory;
import com.bookkurly.bookmall.customer.category.entity.Book;
import com.bookkurly.bookmall.customer.category.entity.MainCategory;
import com.bookkurly.bookmall.customer.category.entity.SubCategory;

public interface CategoryDAO {

	public List<MainCategory> selectList();

	public List<SubCategory> selectList(Integer mainCateSeq);

	public List<Book> selectList2(Integer subCateSeq);

	public String selectSubcateName(Integer subCateSeq);

	public String selectMaincateName(Integer mainCateSeq);

	public String selectMainCate(Integer mainCateSeq);

	public List<SubCategory> selectSubCateList(MainCategory mainCategory);
	
	public List<Book> countAllBooksInSubCateName(SubCategory subCategory);

	public Book findBook(Integer bookSeq);

	public Integer insertMainCate(AdminMainCategory adminMainCategoryEntity);

	public Integer findMainCateSeq(String mainCateName);

	public Integer insertSubCategory(AdminSubCategory adminSubCategory);

	public Integer findBookSeq(Book book);

	public String findMainCateName(Integer mainCateSeq);

	public Integer selectMainCateSeq(Integer subCateSeq);

	public Integer updateBook(Book book);

	public Integer insertBook(Book book);

	public Integer selectSubCateSeq(Integer bookSeq);

	public String findMokcha(Integer bookSeq);

	public String findFileName(Integer bookSeq);
}
