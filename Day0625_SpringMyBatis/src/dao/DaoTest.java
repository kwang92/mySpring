package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		StudentDaoImp imp = context.getBean("studentDao",StudentDaoImp.class);
		
		System.out.println(imp.selectOne(2));
	}
}