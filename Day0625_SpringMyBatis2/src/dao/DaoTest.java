package dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import common.Constant;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		MemberDaoImp2 imp = context.getBean("memberDaoImp2",MemberDaoImp2.class);
		
		Map<String,Object> param = new HashMap<String, Object>();
//		param.put(Constant.Member.NUM, 4);
//		param.put(Constant.Member.NAME, "가나다");
//		param.put(Constant.Member.GENDER, "여자");
//		param.put(Constant.Member.AGE, 29);
//		imp.insertMember(param);
		
		for(Map<String, Object> members : imp.selectAll()) {
			System.out.println(members.get(Constant.Member.NUM));
			System.out.println(members.get(Constant.Member.NAME));
			System.out.println(members.get(Constant.Member.GENDER));
			System.out.println(members.get(Constant.Member.AGE));
			System.out.println("----------------------------------");
		}
		
	}
}
