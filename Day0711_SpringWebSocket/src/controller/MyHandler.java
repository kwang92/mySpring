package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Component
public class MyHandler extends TextWebSocketHandler{
	private Map<String, WebSocketSession> usersMap;
	private List<WebSocketSession> connectedUser;
	public MyHandler() {
		connectedUser = new ArrayList<WebSocketSession>();
		usersMap = new HashMap<String, WebSocketSession>();
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		connectedUser.remove(session);
		System.out.println("연결종료");
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 클라이언트당 하나의 WebSocketSession 객체가 생성됨
		connectedUser.add(session);
		System.out.println(session.getId()+"연결생성");		
		
		
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(message.getPayload());
		
		if(json.get("type") != null && json.get("type").equals("register")) {
			usersMap.put(json.get("memberid")+"", session);
		} else {
			String sender = "";
			for(String key : usersMap.keySet()) {
				System.out.println("key : "+key);
				if(session.equals(usersMap.get(key))) {
					sender = key;
					System.out.println("sender : "+sender);
					break;
				}
			}
			String targetUser = json.get("target").toString();
			WebSocketSession targetSession = usersMap.get(targetUser);
			targetSession.sendMessage(new TextMessage(sender+" : "+json.get("message").toString()));
		}
	
	}

}
