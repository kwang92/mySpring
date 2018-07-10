package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.MemberServiceImp;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberServiceImp service;
	
	@RequestMapping("/checkMember")
	public String checkMember(@RequestParam Map<String, String> params, HttpSession session) {
		String url = "";
		String input_Id = params.get("ID");
		String input_Pwd = params.get("PWD");
		if(service.checkMember(input_Id, input_Pwd)) {
			session.setAttribute("user", service.getMember(input_Id));
			System.out.println("보드목록으로 이동");
			url = "redirect:/board/boardList";
		} else {
			System.out.println("로그인");
			url = "redirect:login";
		}
		
		return url;
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/board/boardList";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "login";
	}
}
