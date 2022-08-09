package com.yedam.test.emp.service;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpVO {
    String employeeId;
    String firstName;
    String lastName;
    String email;
    Date   hireDate;
    String jobId;
    String departmentId;
    String managerId;  
    String profile;
    int salary;
    MultipartFile uploadFile;
    
}
