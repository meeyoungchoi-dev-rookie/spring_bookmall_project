package com.bookkurly.bookmall.customer.category.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookkurly.bookmall.admin.adimaccount.entity.AdminMainCategory;
import com.bookkurly.bookmall.admin.adimaccount.entity.AdminSubCategory;
import com.bookkurly.bookmall.customer.category.entity.Book;
import com.bookkurly.bookmall.customer.category.entity.MainCategory;
import com.bookkurly.bookmall.customer.category.entity.SubCategory;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MainCategory> selectList() {
		
		return sqlSession.selectList("MainCateDAO.selectMainCategorys");
	}

	@Override
	public List<SubCategory> selectList(Integer mainCateSeq) {
		
		return sqlSession.selectList("MainCateDAO.selectSubCategorys", mainCateSeq);
	}

	@Override
	public List<Book> selectList2(Integer subCateSeq) {
		
		return sqlSession.selectList("BookDAO.selectBooks", subCateSeq);
	}

	@Override
	public String selectSubcateName(Integer subCateSeq) {
		
		return sqlSession.selectOne("MainCateDAO.selectSubCateName", subCateSeq);
	}

	@Override
	public String selectMaincateName(Integer subCateSeq) {
		return sqlSession.selectOne("MainCateDAO.selectMainCateName", subCateSeq);
	}

	@Override
	public String selectMainCate(Integer mainCateSeq) {
		return sqlSession.selectOne("MainCateDAO.selectMainCate", mainCateSeq);
	}

	@Override
	public List<SubCategory> selectSubCateList(MainCategory mainCategory) {
		return sqlSession.selectList("MainCateDAO.selectSubCate", mainCategory);
	}

	@Override
	public List<Book> countAllBooksInSubCateName(SubCategory subCategory) {
		return sqlSession.selectList("MainCateDAO.selectBookCountInSubcate", subCategory);
	}

	@Override
	public Book findBook(Integer bookSeq) {
		return sqlSession.selectOne("MainCateDAO.selectBook", bookSeq);
	}

	@Override
	public Integer insertMainCate(AdminMainCategory adminMainCategoryEntity) {
		return sqlSession.insert("MainCateDAO.insertMainCate", adminMainCategoryEntity);
	}

	@Override
	public Integer findMainCateSeq(String mainCateName) {
		return sqlSession.selectOne("MainCateDAO.findMainCateSeq", mainCateName);
	}

	@Override
	public Integer insertSubCategory(AdminSubCategory adminSubCategory) {
		return sqlSession.insert("MainCateDAO.insertSubCate", adminSubCategory);
	}

	@Override
	public Integer findBookSeq(Book book) {
		return sqlSession.selectOne("MainCateDAO.selectBookSeq", book);
	}

	@Override
	public String findMainCateName(Integer mainCateSeq) {
		return sqlSession.selectOne("MainCateDAO.selectMainCateName", mainCateSeq);
	}

	@Override
	public Integer selectMainCateSeq(Integer subCateSeq) {
		return sqlSession.selectOne("MainCateDAO.selectMainCateSeq", subCateSeq);
	}

	@Override
	public Integer updateBook(Book book) {
		return sqlSession.update("MainCateDAO.updateBook", book);
	}

	@Override
	public Integer insertBook(Book book) {
		return sqlSession.insert("MainCateDAO.insertBook", book);
	}

	

	
	
	
	

}
