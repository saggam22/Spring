package com.yedam.myserver.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.myserver.todo.mapper.TodoMapper;
import com.yedam.myserver.todo.service.TodoService;
import com.yedam.myserver.todo.vo.TodoVO;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired TodoMapper mapper;

	@Override
	public List<TodoVO> findAll() {
		return mapper.findAll();
	}

	@Override
	@Transactional //하나의 트랜잭션으로 묶어줘서 전체 롤백이 됨
	public void persist(TodoVO vo) {
		mapper.persist(vo); //트랜잭션으로 묶어주지 않으면 autocommit
		//mapper.persist(vo); //error -> rollback
	}

	@Override
	public void merge(TodoVO vo) {
		mapper.merge(vo);
	}

	@Override
	public void remove(TodoVO vo) {
		mapper.remove(vo);
	}

}
