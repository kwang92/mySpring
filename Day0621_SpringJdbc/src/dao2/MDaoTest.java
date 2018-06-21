package dao2;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MDaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao2/applicationContext.xml");
		MessageDao dao = context.getBean("mDao",MessageDao.class);
		
		for(Map<String,Object> map : dao.selectAll()) {
			System.out.println(map.get("id"));
			System.out.println(map.get("password"));
			System.out.println(map.get("name"));
			System.out.println(map.get("message"));
			System.out.println("===================================================================");
		}
	}
}
