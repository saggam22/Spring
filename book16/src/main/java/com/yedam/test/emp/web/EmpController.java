package com.yedam.test.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.test.emp.service.EmpService;
import com.yedam.test.emp.service.EmpVO;

@Controller
public class EmpController {

    @Autowired
    EmpService empService;

    // 목록조회
    @RequestMapping("empList")
    public String empList(Model model, EmpVO empVO) {
        model.addAttribute("empList", empService.getEmpList(empVO));
        return "emp/getEmpList";
    }
    
 
}


