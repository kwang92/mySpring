package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.Constant;
import common.Constant.Board;
import model.Member;
import service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	// 화면 이동 요청
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	@RequestMapping("/updateForm")
	public String updateForm(Model model, HttpSession session) {
		Map<String, Object> current = (HashMap<String, Object>)session.getAttribute("user");

		model.addAttribute("member", current);
		return "updateForm";
	}
	@RequestMapping("/main")
	public String mainPage() {
		return "main";
	}
	@RequestMapping("/memberList")
	public String memberList(Model model) {
		model.addAttribute("mList",service.getAllMembers());
		return "memberList";
	}
	
	
	/*
	 *  Redirect 시 파라미터에 RedirectAttributes를 적어주고
	 *  인자로 넘어온 객체에 addFlashAttribute()를 이용해 속성을 추가해줘서 redirect에 값을 보내 줄 수 있다. 
	 * 
	 * 
	 * 
	 */
	
	
	// 데이터 처리 요청
	@RequestMapping("/login")
	public String login(HttpSession session,String id, int password) {
		String url = "redirect:";
		Map<String, Object> loginUser = service.getMemberInfo(id);
		if(service.getMemberInfo(id) != null) {
			int realPwd = Integer.parseInt((String)service.getMemberInfo(id).get(Constant.Member.PASSWORD));			
			if(realPwd == password) {
				url += "main";
				session.setAttribute("user", loginUser);
				System.out.println("로그인성공");
			} else {
				url += "loginForm";
			}
		} else {
			url += "loginForm";
		}
		return url;
	}
	
	@RequestMapping("/join")
	public String join(@RequestParam Map<String, Object> param) {
		service.addMember(param);
		// addMember가  실패하면 밑에를 실행하면 안됨. 트랙잭션 취소
		System.out.println("밑에 실행");
		Map<String, Object> board = new HashMap<String, Object>();
		board.put(Board.NUM, 33);
		board.put(Board.TITLE, "가입인사입니다.");
		board.put(Board.NAME, param.get(common.Constant.Member.NAME));
		board.put(Board.PASS, param.get(common.Constant.Member.PASSWORD));
		board.put(Board.EMAIL, param.get(common.Constant.Member.EMAIL));
		board.put(Board.CONTENT, "안녕하세요 가입인사입니다.");
		service.insertBoard(board);
		return "redirect:loginForm";
	}
	
	@RequestMapping("update")
	public String update(@RequestParam Map<String, Object> param) {
		service.modifyMember(param);
		return "redirect:main";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:main";
	}
	
	@RequestMapping("writeBoard")
	public String writeBoard(@RequestParam Map<String, Object> param) {
		
		return "";
	}
}
