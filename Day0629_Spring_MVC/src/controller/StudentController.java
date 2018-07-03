package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	// 학생관련 요청 처리 Controller
	// /student/studentList
	@Autowired
	private StudentService service;
	
	@RequestMapping("/addPage")
	public String addPage() {
		return "insertStu";
	}
	
	@RequestMapping("/add")
	public String insertStudent(Model model,@RequestParam Map<String, Object> param) {
		// 파라미터?
		int res = service.insertStudent(param);
		String url = "redirect:studentList";
		if(res <= 0) {
			model.addAttribute("errorMsg", "가입실패");
		}
		return url;
	}
	
	@RequestMapping("/selectStudentsByGrade")	
	public String selectStudentsByGrade(Model model, int sgrade) {
		model.addAttribute("sList",service.selectStudentsByGrade(sgrade));
		return "stu";
	}
	
	@RequestMapping("/updateStudent")
	public String updateStudent(Model model, @RequestParam Map<String, Object> param) {
		service.updateStudent(param);
		return "redirect:studentList";	// controller 내부로 요청을 보내는 방법
	}
	
	
	@RequestMapping("/studentList")
	public String showList(Model model) {
		model.addAttribute("sList", service.selectAll());
		return "stu";
	}
}
