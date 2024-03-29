package com.goodee.book.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	BookDao dao;
	public List<BookVo> selectBookList(){
		return dao.selectBookList();
	}
	//controller와 dao 사이를 연결해준다
	//dao가 알려준 결과(int)를 controller에게 전달
	//controller로부터 전달 받은 파라미터 BookVo를 dao에게 전달
	//메소드명이 insertBook 
	
	public int insertBook(BookVo vo) {
		return dao.insertBook(vo);
	
	}

}
