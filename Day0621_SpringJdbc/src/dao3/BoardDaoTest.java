package dao3;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Board;

public class BoardDaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao3/applicationContext.xml");
		BoardDao dao = context.getBean("boardDao",BoardDao.class);
		Board board = new Board();
		board.setNum(2);
		board.setTitle("두번 째 테스트 수정결과입니다.");
		board.setName("홍길동");
		board.setPass("hong");
		board.setEmail("hong123@gmail.com");
		board.setContent("test");
//		dao.addBoard(board);
		dao.updateBoard(board);
		
		for(Map<String, Object> map : dao.selectAll()) {
			for(String key : map.keySet()) {
				System.out.println(map.get(key));
			}
			System.out.println("-------------------------------");
		}
	}
}
