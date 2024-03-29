package com.goodee.book.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookVo {
	private String g_writer;
	private String g_content;
	private Date g_reg_date;
}

