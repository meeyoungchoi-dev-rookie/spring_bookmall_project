package com.bookkurly.bookmall.customer.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookkurly.bookmall.admin.adimaccount.entity.AdminMainCategory;
import com.bookkurly.bookmall.admin.adimaccount.entity.AdminSubCategory;
import com.bookkurly.bookmall.customer.category.dao.CategoryDAO;
import com.bookkurly.bookmall.customer.category.entity.Book;
import com.bookkurly.bookmall.customer.category.entity.MainCategory;
import com.bookkurly.bookmall.customer.category.entity.SubCategory;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDAO categoryDao;

	@Override
	public List<MainCategory> selectList() {
		System.out.println("categorySerivce.selectlist()");
		return categoryDao.selectList();
	}

	@Override
	public List<SubCategory> selectList(Integer mainCateSeq) {
		
		return categoryDao.selectList(mainCateSeq);
	}

	@Override
	public List<Book> selectList2(Integer subCateSeq) {
		
		return categoryDao.selectList2(subCateSeq);
	}

	@Override
	public String selectSubcateName(Integer subCateSeq) {
		return categoryDao.selectSubcateName(subCateSeq);
	}

	@Override
	public String selectMaincateName(Integer subCateSeq) {
		return categoryDao.selectMaincateName(subCateSeq);
		
	}

	@Override
	public String selectMaincate(Integer mainCateSeq) {
		return categoryDao.selectMainCate(mainCateSeq);
	}

	@Override
	public List<SubCategory> selectSubCateList(MainCategory mainCategory) {
		return categoryDao.selectSubCateList(mainCategory);
	}

	@Override
	public List<Book> countAllBooksInSubCateName(SubCategory subCategory) {
		return categoryDao.countAllBooksInSubCateName(subCategory);
	}

	@Override
	public Book findBook(Integer bookSeq) {
		return categoryDao.findBook(bookSeq);
	}

	@Override
	public Integer insertMainCate(AdminMainCategory adminMainCategoryEntity) {
		return categoryDao.insertMainCate(adminMainCategoryEntity);
	}

	@Override
	public Integer findMainCateSeq(String mainCateName) {
		return categoryDao.findMainCateSeq(mainCateName);
	}

	@Override
	public Integer insertSubCategory(AdminSubCategory adminSubCategory) {
		return categoryDao.insertSubCategory(adminSubCategory);
	}

	@Override
	public Integer findBookSeq(Book book) {
		return categoryDao.findBookSeq(book);
	}

	@Override
	public String findMainCateName(Integer mainCateSeq) {
		return categoryDao.findMainCateName(mainCateSeq);
	}

	@Override
	public Integer selectMainCateSeq(Integer subCateSeq) {
		return categoryDao.selectMainCateSeq(subCateSeq);
	}

	@Override
	public Integer updateBook(Book book) {
		return categoryDao.updateBook(book);
	}

	@Override
	public Integer insertBook(Book book) {
		return categoryDao.insertBook(book);
	}

	
	

}
