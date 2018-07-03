package test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import common.Constant.Member;
import dao.IMemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/spring/root-context.xml")
public class DaoTest {
	@Autowired
	private IMemberDao memberDao;
	
	@Test
	public void memberDaoTest() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(Member.ID, "happy0357");
		param.put(Member.NAME, "류고고");
		param.put(Member.PASSWORD, "1234");
		param.put(Member.EMAIL, "rkm92@naver.com");
		memberDao.insertMember(param);
	}
}
