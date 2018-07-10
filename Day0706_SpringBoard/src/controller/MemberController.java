package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IMemberDao;
import model.Member;
import service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService service;
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	@RequestMapping("/join")
	public String joinMember(@RequestParam Map<String, String> params) {
		Member member = new Member();
		member.setId(params.get("ID"));
		member.setPassword(params.get("PASSWORD"));
		member.setName(params.get("NAME"));
		member.setEmail(params.get("EMAIL"));
		String url;
		if(service.insertMember(member) > 0) {
			url = "loginForm";
		} else {
			url = "joinForm";
		}
		return url;
	}
	@RequestMapping("/login")
	public String loginMember(@RequestParam Map<String, String> params, HttpServletRequest req) {
		String inputId = params.get("ID");
		String inputPwd = params.get("PASSWORD");
		Member member = service.selectOne(inputId);
		
		if(member != null) {
			if(member.getPassword().equals(inputPwd)) {
				req.getSession().setAttribute("user", member);
			}
		}
		String url = "redirect:/board/mainForm";
		return url;
	}
}
