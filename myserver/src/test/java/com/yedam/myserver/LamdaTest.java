package com.yedam.myserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.yedam.myserver.emp.vo.Employee;

public class LamdaTest {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList();
		
		list.add(Employee.builder().email("a@a.c").salary(1000).build()); //생성자 없이 생성자를 만들어줌
		list.add(Employee.builder().email("b@a.c").salary(200).build());
		list.add(Employee.builder().email("c@a.c").salary(3000).build());
		list.add(Employee.builder().email("d@a.c").salary(400).build());
		
		//email정렬하기 위해 객체를 생성하고 class를 생셩해야하므로 번거로움
		Collections.sort(list, new EmpComp());
		for (Employee emp : list) {			
			System.out.println(emp.getEmail() + ":" + emp.getSalary() );
		}
		
		
		//익명클래스 : 클래스 선언과 생성
		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary() - o2.getSalary();
			}});
		
		for (Employee emp : list) {			
			System.out.println(emp.getEmail() + ":" + emp.getSalary() );
		}
		
		
		//람다식 : 부모인터페이스의 오버라이딩 1개인 경우만 가능!
		Collections.sort(list, (Employee o1, Employee o2) -> o1.getSalary() - o2.getSalary());
		
		for (Employee emp : list) {			
			System.out.println(emp.getEmail() + ":" + emp.getSalary() );
		}
		
	}
	
}

class EmpComp implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getEmail().compareTo(o2.getEmail());
	}
}

