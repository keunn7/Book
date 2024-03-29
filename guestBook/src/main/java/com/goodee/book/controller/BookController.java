package com.goodee.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goodee.book.model.BookDto;
import com.goodee.book.model.BookService;


@Controller
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/book")
	public String bookList(Model model) {
		//1.service -> dao -> jpa를 통해서 목록 조회
		List<BookDto> bookDtoList = service.selectBookList();
		//2.화면 정보 전달
		model.addAttribute("bookList", bookDtoList);
		System.out.println("test");
		//3.화면 전환
	 return "book";
	}
	
	@PostMapping("/book")
	public String createBook(BookDto dto) {
		service.saveBook(dto);
		return "redirect:/book";
	}
	
}
