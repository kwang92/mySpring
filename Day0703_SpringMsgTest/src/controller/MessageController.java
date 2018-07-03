package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Message;
import service.MessageService;

@Controller
@RequestMapping("message")
public class MessageController {
	
	@Autowired
	private MessageService service;
	
	@ResponseBody
	@RequestMapping("sendMsg")
	public Map<String, Object> sendMessage( @RequestParam Map<String, Object> params) {
		Message msg = new Message();
		msg.setName(params.get("name")+"");
		msg.setPassword(params.get("pwd")+"");
		msg.setMessage(params.get("content")+"");
		service.insertMsg(msg);
//		model.addAttribute("viewData",service.selectList(1));
		
		return service.selectList(1);
	}
	@ResponseBody
	@RequestMapping("getMsgs")
	public Map<String, Object> getMsgs(){
		return service.selectList(1);
	}
	
	
	
	@ResponseBody
	@RequestMapping("pageList")
	public Map<String, Object> numberForList(int page){
		System.out.println(page+"pageList요청으로 들어옴");
		return service.selectList(page);
	}
	
	
	@RequestMapping("messageList")
	public String msgList(Model model, @RequestParam(value = "pageNum", defaultValue = "1")int pageNum) {
		model.addAttribute("viewData",service.selectList(pageNum));
		return "messageList";
	}
	
	@RequestMapping("pwCheck")
	public String checkPw(Model model, @RequestParam Map<String, Object> params) {
		int id = Integer.parseInt(params.get("id")+"");
		String pwd = params.get("password")+"";
		int result = service.deleteMsg(id, pwd);
		String msg = "삭제 실패했습니다";
		if(result > 0) {
			msg = "삭제성공";
		}
		model.addAttribute("msg",msg);
		model.addAttribute("url","messageList");
		return "result";
	}
	
	@RequestMapping("confirmDeletion")
	public String delMsg(Model model, int id) {
		System.out.println("confirm 받음");
		model.addAttribute("id",id);
		return "confirmDeletion";
	}
	
}
