package com.goodee.book.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Entity
@Table(name ="content_list")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
	@Id
    @Column(name="g_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long g_no;
	
    @Column(name="g_writer", length = 20, nullable = false)
    private String g_writer;
    
    @Column(name="g_content", length = 100)
    private String g_content;
	
    @Column(name="g_reg_date")
    @CreationTimestamp
    private LocalDateTime g_reg_date;
    
    @Builder
    public Book(String g_writer, String g_content) {
    	this.g_writer = g_writer;
    	this.g_content = g_content;
    }
  
}
