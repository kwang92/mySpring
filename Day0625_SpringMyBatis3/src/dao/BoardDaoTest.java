package dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import common.Constant;

public class BoardDaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		BoardDao dao = context.getBean("boardDao",BoardDao.class);
		
		Map<String, Object> param = new HashMap<String, Object>();
//		param.put(Constant.Board.TITLE, "테스트글 등록합니다.");
//		param.put(Constant.Board.NAME, "테스터");
//		param.put(Constant.Board.PASS, "0000");
//		param.put(Constant.Board.CONTENT, "테스트 글 작성중");
//		param.put(Constant.Board.EMAIL, "test@naver.com");
//		dao.insertBoard(param);
//		dao.deleteBoard(23);
		param.put("TYPE", Constant.Board.TITLE);
		param.put("TITLE", "수정");
		
		for(Map<String, Object> boards : dao.searchBoard(param)) {
			for(String key : boards.keySet()) {
				System.out.print(boards.get(key)+" ");
			}
			System.out.println();
		}
		
	}
}
