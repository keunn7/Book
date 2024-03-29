package com.goodee.book.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
 
@Service
//필요한 것만 사용해서 생성하는 annotaion
@RequiredArgsConstructor
public class BookService {
	
	private final BookRepository bookRepository;
	
	public List<BookDto> selectBookList(){
		//1. repository에게 전체목록 조회를 요청 
		// findAll == SELECT * FROM content_list
		List<Book> books = bookRepository.findAll();
		//2. 전체 목록 자료형 List<Book> -> List<BookDto>
		List<BookDto> resultList = new ArrayList<>();
		for(Book book : books) {
			BookDto bookDto = BookDto.builder()
					.writer(book.getG_writer())
					.content(book.getG_content())
					.reg_date(book.getG_reg_date())
					.build();
		
			
			resultList.add(bookDto);
		
		} 
		
		//3. controller에게 List<BookDto> 값 반환 
		return resultList;
	}
	
	//2.Service
	@Transactional
	public void saveBook(BookDto dto) {
		bookRepository.save(dto.toEntity());
	}
}
