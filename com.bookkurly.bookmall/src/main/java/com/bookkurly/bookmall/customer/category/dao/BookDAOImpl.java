package com.bookkurly.bookmall.customer.category.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookkurly.bookmall.customer.category.entity.Book;

@Repository
public class BookDAOImpl  implements BookDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<Book> selectList(Integer subCateSeq) {
		return sqlSession.selectList("BookDAO.selectBooks", subCateSeq);
	}


	@Override
	public List<Book> selectList2(Integer subCateSeq) {
		return sqlSession.selectList("BookDAO.selectBooksByCate", subCateSeq);
	}


	@Override
	public Book selectBook(Integer bookSeq) {
		return sqlSession.selectOne("BookDAO.selectBook", bookSeq);
	}

	@Override
	public Integer selectBkookPrice(Integer bookSeq) {
		return sqlSession.selectOne("BookDAO.selectBookPrice", bookSeq);
	}

	
}
