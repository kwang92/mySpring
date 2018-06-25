package dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import common.Constant;
import model.Member;
import model.Message;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		MessageDao msg_Dao = context.getBean("messageDao",MessageDao.class);
		MemberDao mem_Dao = context.getBean("memberDao",MemberDao.class);
//		Message msg = new Message();
//		msg.setId(77);
//		msg.setName("테스터");
//		msg.setPassword("1234");
//		msg.setMessage("안녕하세요 테스트 메시지 등록입니다.");
//		dao.insertMsg(msg);
//		System.out.println(dao.selectOne(77));
		
		for(Message message : msg_Dao.selectAll()) {
			System.out.println(message);
		}
		System.out.println("--------------------------------");
//		for(Member member : mem_Dao.selectAll()) {
//			System.out.println(member);
//		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(Constant.Member.NUM, 2);
		param.put(Constant.Member.NAME, "홍길동");
		param.put(Constant.Member.GENDER, "여자");
		param.put(Constant.Member.AGE, 23);
		mem_Dao.addMember(param);
		for(Map<String, Object> map : mem_Dao.selectAll()) {
			for(String key : map.keySet()) {
				System.out.print(key +" : "+map.get(key)+" | ");
			}
			System.out.println();
		}
	}
}
