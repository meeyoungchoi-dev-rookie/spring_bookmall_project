package com.bookkurly.bookmall.customer.category.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
