package com.example.web.employee;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Departments {
	
	@Id
	Integer department_id;//                             not null number(4)
	String department_name;//                          not null varchar2(30)
	Integer manager_id;//                                         number(6)
	Integer location_id;//                                        number(4)

	@OneToMany
	List<Employees> employees;
}
