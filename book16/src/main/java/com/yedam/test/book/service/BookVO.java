package com.yedam.test.book.service;

import lombok.Data;

@Data
public class BookVO {
	
	Integer bookNo;    
	String bookName;
	String bookCoverimg;
	String bookDate;
	String bookPrice;
	String bookPublisher; 
	String bookInfo;
	
	Integer sum;
	Integer count;
}
