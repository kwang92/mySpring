package dao;

import java.util.HashMap;
import java.util.Map;

import common.Constant;

public class MessageDaoTest {
	public static void main(String[] args) {
		MessageDao dao = new MessageDao();
		
		Map<String, Object> param = new HashMap<String, Object>();
		
//		param.put(Constant.Message.ID, "rkm92");
//		param.put(Constant.Message.PASSWORD,"1234");
//		param.put(Constant.Message.NAME, "류광민");
//		param.put(Constant.Message.MESSAGE, "안녕하세요 류광민입니다. 테스트 메시지 입니다.");
//		
//		dao.insertMsg(param);
		
		for(Map<String, Object> info : dao.selectAll()) {
			for(String key : info.keySet()) {
				System.out.println(key+" : "+info.get(key));
			}
			System.out.println("========================================");
		}
	}
}
