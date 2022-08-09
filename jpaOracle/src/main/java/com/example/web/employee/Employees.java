package com.example.web.employee;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Employees {
	
	 @Id
	 Integer employee_id;//                               not null number(6)
	 String first_name;//                                         varchar2(20)
	 String last_name;//                                 not null varchar2(25)
	 String email;//                                     not null varchar2(25)
	 String phone_number;//                                       varchar2(20)
	 Date hire_date;//                                 not null date
	 String job_id;//                                    not null varchar2(10)
	 Double salary;//                                             number(8,2)
	 Double commission_pct;//                                     number(2,2)
	 Integer manager_id;//                                         number(6)
	 //Integer department_id;//                                      number(4)

	 @ManyToOne
	 @JoinColumn(name="department_id")
	 Departments departments;
}
