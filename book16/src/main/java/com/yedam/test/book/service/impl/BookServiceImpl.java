package com.yedam.test.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.test.book.mapper.BookMapper;
import com.yedam.test.book.service.BookService;
import com.yedam.test.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired BookMapper mapper;

	@Override
	public void bookInsert(BookVO vo) {
		mapper.bookInsert(vo);
	}

	@Override
	public BookVO getBookNo() {
		return mapper.getBookNo();
	}

	@Override
	public List<BookVO> bookList() {
		return mapper.bookList();
	}

	@Override
	public List<BookVO> rentList() {
		return mapper.rentList();
	}
}
