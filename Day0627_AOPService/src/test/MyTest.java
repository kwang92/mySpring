package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Member;
import service.MemberService;

public class MyTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		MemberService service = context.getBean("memberService",MemberService.class);
		
		System.out.println(service.getMember(2));
		
		/*for(Member mem : service.getMemberList()) {
			System.out.println(mem);
		}*/
	}
}
