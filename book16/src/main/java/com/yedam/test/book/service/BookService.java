package com.yedam.test.book.service;

import java.util.List;

public interface BookService {
	
	public BookVO getBookNo();
	public void bookInsert(BookVO vo);
	public List<BookVO> bookList();
	public List<BookVO> rentList();
}
