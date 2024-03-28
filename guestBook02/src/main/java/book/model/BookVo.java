package book.model;

import java.util.Date;

public class BookVo {
	
	
	
	public BookVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BookVo(String writer, String content, Date reg_date) {
		super();
		this.writer = writer;
		this.content = content;
		this.reg_date = reg_date;
	}
	
	private String writer;
	private String content;
	private Date reg_date;
	public String getWriter() {
		return writer;
	}
	
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
}
