package dao;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Product;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");
		ProductDao dao = context.getBean("pDao",ProductDao.class);
//		Product p = new Product();
//		p.setpNum("1");
//		p.setpName("컵라면");
//		p.setPrice(1000);
//		p.setStock(100);
//		dao.addProduct(p);
//		
//		p.setpNum("2");
//		p.setpName("게토레이");
//		p.setPrice(1500);
//		p.setStock(1000);
//		dao.addProduct(p);
		
		for(Map<String, Object> map : dao.selectAll()) {
			System.out.println(map.get("pNum"));
			System.out.println(map.get("pName"));
			System.out.println(map.get("price"));
			System.out.println(map.get("stock"));
			System.out.println("==================");
		}
	}
}
