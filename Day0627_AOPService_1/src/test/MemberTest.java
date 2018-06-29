package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import service.MemberService;

public class MemberTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		MemberService service = context.getBean("memberServiceImp",MemberService.class);
		
		System.out.println(service.getAllMember());
	}
}
