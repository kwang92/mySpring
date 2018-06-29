package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.StudentService;

@Controller	// Controller - @Component의 역할
public class HelloController {
	
	@Autowired
	private StudentService service;
	
	@RequestMapping("/hello.do")	// RequestMapping - 처리 할 요청에 대한 명시
	public ModelAndView doHello() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello.jsp");
		mav.addObject("msg","Hello World");
		return mav;
	}
	
	@RequestMapping("/studentList.do")
	public ModelAndView showStudentList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("studentList.jsp");
		System.out.println(service.getAllStudents());
		mav.addObject("studentList",service.getAllStudents());
		return mav;
	}
}
