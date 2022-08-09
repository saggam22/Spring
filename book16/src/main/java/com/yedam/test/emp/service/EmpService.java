package com.yedam.test.emp.service;

import java.util.List;

public interface EmpService {

    public EmpVO getEmp(EmpVO empVO);
    public List<EmpVO> getEmpList(EmpVO empVO);
    public void empInsert(EmpVO empVO);
    public void empUpdate(EmpVO empVO);
}
