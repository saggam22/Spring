package com.yedam.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.test.emp.mapper.EmpMapper;
import com.yedam.test.emp.service.EmpVO;

@SpringBootTest
public class EmpMapperTest {

	@Autowired
	EmpMapper mapper;

	@Test
	public void list() {
		List<EmpVO> list = mapper.getEmpList(null);
		System.out.println(list.get(0));
	}
}
