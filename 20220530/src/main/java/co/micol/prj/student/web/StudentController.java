package co.micol.prj.student.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.micol.prj.student.service.StudentService;
import co.micol.prj.student.vo.StudentVO;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentDao;
	
	@RequestMapping("/studentList.do")
	public String StudentList(Model model) {
		model.addAttribute("students", studentDao.studentSelectList());
		return "student/studentList";
	}
	
	@RequestMapping("/studentJoinForm.do")
	public String studentJoinForm() {
		return "student/studentJoinForm";
	}
	
	@PostMapping("/studentJoin.do")
	public String studentJoin(StudentVO vo, Model model) { //form에서 가지고 있는 파라메터 값이 자동으로 vo에 담겨서 활용가능
		//이때, StudentVO의 변수명과 input태그의 name이 같아야한다.
		int n = studentDao.StudentInsert(vo);
		if (n != 0) {
			model.addAttribute("message", "회원가입성공!");
		} else {
			model.addAttribute("message", "회원가입실패!");
		}
		return "student/studentJoin";
	}
	
	@GetMapping("/ajaxIdCheck.do")
	@ResponseBody
	public String ajaxIdCheck(String id) {
		boolean b = studentDao.idCheck(id);
		String data = "N";  //이미 사용중인 아이디
		if (!b) {
			data = "Y";  //사용할 수 있는 아이디
		}
		return data;
	}
}
