package com.yedam.test.book.mapper;

import java.util.List;

import com.yedam.test.book.service.BookVO;

public interface BookMapper {

	public BookVO getBookNo();
	public void bookInsert(BookVO vo);
	public List<BookVO> bookList();
	public List<BookVO> rentList();
}
