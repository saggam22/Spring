package com.yedam.myserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.emp.vo.Employee;

@RestController
public class AjaxController {
	
	@GetMapping("req")
	public String reGet() {
		return "get test";
	}
	
	@PostMapping("req")
	@ResponseBody //자바객체를 json String으로 변환
	//@RequestBody -> json String 파싱해서 vo객체 변화
	public String rePost(@RequestBody Employee vo) throws InterruptedException {
		//Thread.sleep(3000);
		System.out.println(vo.getFirst_name());
		return "post test";
	}
}
