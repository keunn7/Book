package com.goodee.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodee.book.model.BookService;
import com.goodee.book.model.BookVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String bookList(Model model) {
		//1. 목록 조회 (Service, Dao)
		List<BookVo> resultList = service.selectBookList();
		
		for(BookVo vo : resultList) {
			System.out.println(vo.getG_writer());
		}
		
		//2. 정보 전달
		//(1) String 화면, Model 객체정보 (new 연산자)
		//(2) ModelAndView 화면과 정보
		//(3) String 화면, Model 객체 정보(매개변수)
		model.addAttribute("resultList", resultList);
		

		//3. 화면 전달 
		return "book";
		
	}
		@RequestMapping(method=RequestMethod.POST)
		public String createBook(BookVo vo){
			//0. 작성자와 내용 정보를 가져와야 함 
			//@RequestParam ("g_writer")String g_writer
			//Map<String,String> map
			//BookVo vo
			//1. 방명록 정보 등록 
			int result =service.insertBook(vo);
			
			//2. 목록화면으로 이동 
			if(result >0) {
				return "redirect:/book";
		
			}else {
				return "error";
			}
			//3. 
}
		

}
