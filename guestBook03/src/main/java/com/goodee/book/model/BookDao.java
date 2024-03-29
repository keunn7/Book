package com.goodee.book.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
//데이터베이스와 직접 소통 (Mybatis를 통해서)
	
	
	//목록조회
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "com.goodee.book.BookMapper.";
	
	public List<BookVo> selectBookList(){
		List<BookVo> resultList= new ArrayList<BookVo>();
		try {
			resultList = sqlSession.selectList(namespace +"selectBookList");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
		
	}
	public int insertBook(BookVo vo) {
		int result = 0; 
		try {
			result = sqlSession.insert(namespace + "insertBook", vo);
		} catch (Exception e) {
			
		}
	return result; 
	}
}