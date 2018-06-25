package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DaoTest3 {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		MemberDao dao = context.getBean("memberDao3",MemberDao.class);
		
		System.out.println(dao.selectOne(2));
	}
}
