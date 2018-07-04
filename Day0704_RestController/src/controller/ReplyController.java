package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Reply;
import service.ReplyService;

@Controller
@RequestMapping("/replies")
public class ReplyController {
	// 등록, 수정, 삭제, 목록
	@Autowired
	private ReplyService service;
	
	
	@ResponseBody
	@RequestMapping(value="", method= RequestMethod.POST)	// RequestMapping(value="") 를 하면 컨트롤러의 mapping 이름으로 처리된다.
	public boolean register(Reply reply) {
		boolean res = false;
		System.out.println(reply.getBoardNum());
		System.out.println(reply.getReplyContent());
		System.out.println(reply.getReplyWriter());
		if(service.insertReply(reply) > 0) {
			res = true;
		}
		return res;
	}
	
	// RequestMapping url에 포함 된  변수데이터 받아오기  == @PathVariable
	@RequestMapping(value = "/update", method= RequestMethod.POST)
	public boolean update(Reply reply){
		boolean res = false;
		if(service.updateReply(reply) > 0) {
			res = true;
		}
		return res;
	}
	
	@RequestMapping(value="/{replyNum}", method= RequestMethod.DELETE)
	public boolean delete(@PathVariable("replyNum") int replyNum) {
		boolean res = false;
		if(service.deleteReply(replyNum) > 0 ) {
			res = true;
		}
		return res;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/all/{boardNum}")
	public List<Reply> list(@PathVariable("boardNum") int boardNum){
		return service.selectByBoardNum(boardNum);
	}
}
