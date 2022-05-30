package co.micol.prj.student.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.student.service.StudentService;
import co.micol.prj.student.vo.StudentVO;

@Controller
public class StudentController {
	@Autowired
	StudentService studentDao; //DAO 객체를 자동 주입
	
	@RequestMapping("/studentList.do")
	public String studentList(Model model) {
		model.addAttribute("students", studentDao.studentSelectList());
		return "student/studentList";
	}
	
	@RequestMapping("/studentSelect.do") //한명의 데이터 조회
	public String studentSelect(StudentVO vo, Model model) {
		model.addAttribute("student", studentDao.studentSelect(vo));
		return "student/studentSelect";
	}
}