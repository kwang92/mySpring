package controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Message;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	public String webSocketForm() {
		return "webSocketEx2";
	}
	
	@RequestMapping("/test2")
	public String stompForm() {
		return "stomp";
	}
	
	@CrossOrigin
	@MessageMapping("/greeting/{memberid}/{targetid}")
	@SendTo("/topic/msg/{targetid}")
	public Message stompTest(String message, @DestinationVariable(value = "memberid") String memberid, @DestinationVariable(value = "targetid") String targetid) {
		/*
		 *  application-destination-prefix선언으로 인해
		 *  /client/greeting으로 들어온 요청을 처리
		*/
		Message msg = new Message();
		msg.setBody(memberid+" : "+message);
		
		return msg;
	}
	
	@CrossOrigin
	@MessageMapping("/userLogin/{memberid}")
	@SendTo("/topic/msg/all")
	public String login(@DestinationVariable(value = "memid") String loginId) {
		return loginId;
	}
}
