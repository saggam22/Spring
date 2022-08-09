package com.example.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.web.employee.EmployeesRepository;

@SpringBootTest
public class EmpRepoTest {

	@Autowired EmployeesRepository repo;
	@Test
	public void selectTest() {
		System.out.println(repo.findById(100));
	}
}
