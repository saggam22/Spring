package com.yedam.test.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yedam.test.book.service.BookService;
import com.yedam.test.book.service.BookVO;

@Controller
public class BookController {
	
	@Autowired BookService service;

	@RequestMapping("bookSave")
	public String bookSave(Model model) {
		model.addAttribute("book", service.getBookNo());
		return "book/bookSave";
	}
	
	@RequestMapping("bookInsert")
	@ResponseStatus(value = HttpStatus.OK)
	public void bookInsert(BookVO vo) {
		service.bookInsert(vo);
	}
	
	@RequestMapping("bookList")
	public String bookList(Model model) {
		model.addAttribute("books", service.bookList());
		return "book/bookList";
	}
	
	@RequestMapping("bookRent")
	public String rentList(Model model) {
		model.addAttribute("rents", service.rentList());
		return "book/bookRent";
	}
}
