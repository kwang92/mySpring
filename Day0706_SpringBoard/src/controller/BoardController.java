package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IBoardDao;
import model.Board;
import model.Member;
import service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;

	@RequestMapping("/writeForm")
	public String writeForm() {
		System.out.println("게시판작성 요청");
		return "writeBoard";
	}
	@RequestMapping("/modifyForm")
	public String modifyForm() {
		return "modifyForm";
	}
	@RequestMapping("/mainForm")
	public String mainForm() {
		System.out.println("메인폼 요청");
		return "mainForm";
	}
	@RequestMapping("/boardListForm")
	public String bListForm(Model model, @RequestParam(defaultValue = "1")int pageNum) {
		System.out.println("게시판 요청 들어옴");
		System.out.println("컨트롤러 뷰데이터 크기 : "+service.selectList(pageNum));
		
		model.addAttribute("viewData",service.selectList(pageNum));
		return "boardForm";
	}
	//////////////////////////////////////////////
	
	@RequestMapping("/writeBoard")
	public String writeBoard(@RequestParam Map<String, String> params, HttpSession session) {
		String url;
		
		Board board = new Board();
		Member member = (Member)session.getAttribute("user");
		board.setTitle(params.get("TITLE"));
		board.setContent(params.get("CONTENT"));
		board.setName(member.getName());
		board.setId(member.getId());
		board.setPass(member.getPassword());
		board.setEmail(member.getEmail());
		service.insertBoard(board);
		
		return "redirect:boardListForm";
	}
	@RequestMapping("/viewDetail")
	public String viewOne(int num, Model model) {
		model.addAttribute("brd",service.selectOne(num));
		return "boardDetail";
	}
	@RequestMapping("/delBoard")
	public String deleteBoard(int num) {
		System.out.println("삭제 게시번호 : "+num);
		service.deleteBoard(num);
		return "redirect:boardListForm";
	}
	
	public String updateBoard(Board board) {
		service.updateBoard(board);
		return "redirect:boardListForm";
	}
}
