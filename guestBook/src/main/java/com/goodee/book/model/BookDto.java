package com.goodee.book.model;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {

	private String writer;
	private String content;
	private LocalDateTime reg_date;
	
	@Builder
	public BookDto(String writer, 
			String content, LocalDateTime reg_date) {
		this.writer = writer;
		this.content = content;
		this.reg_date = reg_date;
	}
	
	//insert, update
	public Book toEntity() {
		return Book.builder()
				.g_writer(writer)
				.g_content(content)
				.build();	
	}
	
	//select
	public BookDto toDto(Book book) {
		return BookDto.builder()
				.writer(book.getG_writer())
				.content(book.getG_content())
				.reg_date(book.getG_reg_date())
				.build();
	}
	
}