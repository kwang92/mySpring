package aop3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext context= new GenericXmlApplicationContext("aop3/applicationContext.xml");
		Person girl = context.getBean("girl",Person.class);
//		Person boy = context.getBean("boy",Person.class);
		girl.doSomething();
		System.out.println("-------------------------");
	}
}
