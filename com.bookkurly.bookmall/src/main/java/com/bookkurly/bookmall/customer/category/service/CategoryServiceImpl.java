package com.bookkurly.bookmall.customer.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
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

}
