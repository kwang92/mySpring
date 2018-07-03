package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService service;
	
	@RequestMapping("/memberList")
	public String getAllMembers(Model model) {
		model.addAttribute("mList",service.selectAll());
		return "memberListPage";
	}
}
