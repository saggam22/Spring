package com.yedam.myserver.emp.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@JsonInclude(JsonInclude.Include.NON_NULL) //Json으로 return할때 null값 제외
@Data
@Builder //생성자를 만들어줌
@NoArgsConstructor //빈 생성자가 만들어짐
@AllArgsConstructor //모든 생성자가 만들어짐
public class Employee {

	private Integer department_id;
	private Integer manager_id;
	private Integer commission_pct;
	private Integer salary;
	private String job_id;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date hire_date;
	@JsonIgnore //Json으로 return할때 해당 필드들은 제외
	private String phone_number;
	private String email;
	private String last_name;
	@JsonProperty("fname") //필드명 재정의
	private String first_name;
	private Integer employee_id;
	
	//private String department_name;
	private Departments department;

}
