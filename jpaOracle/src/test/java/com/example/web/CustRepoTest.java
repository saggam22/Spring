package com.example.web;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.web.customer.Customer;
import com.example.web.customer.customerRepository;

@SpringBootTest
public class CustRepoTest {
	
	@Autowired customerRepository custRepo;
	
	@Transactional
	@Commit
	//@Test
	public void savetest() {
		Customer cust = new Customer();
		cust.setId(1L);
		cust.setName("홍길동");
		cust.setPhone("2222");
		custRepo.save(cust);
	}
	
	@Transactional
	@Commit
	@Test
	public void updatetest() {
		//null체크하기 위해 optional
		Optional<Customer> cust = custRepo.findById(2L);
		Customer resultCutomer = cust.get();
		resultCutomer.setPhone("3333");
		custRepo.save(resultCutomer);
	}
	
	

}
