package com.example.web.customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends JpaRepository<Customer, Long> {
	
	//인터페이스를 상속받으면 기본내장되어있는 save함수 사용 가능
	
	//클래스일 경우 사용
	//@PersistenceContext
	//EntityManager em;
	
	//public void save(Customer cust) {
	//	em.persist(cust);
	//}
}
