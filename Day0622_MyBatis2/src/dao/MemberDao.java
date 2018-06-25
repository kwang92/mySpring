package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Member;

@Component
public class MemberDao {
	private SqlSessionFactory ssFactory;
	@Autowired
	public MemberDao() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			ssFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int addMember(Map<String, Object> param) {
		SqlSession session = ssFactory.openSession();
		
		try {
			return session.insert("dao.memberMapper.addMember",param);
		} finally {
			session.close();
		}
	}
	public int updateMember(Map<String, Object> param) {
		SqlSession session = ssFactory.openSession();
		try {
			return session.update("dao.memberMapper.updateMember",param);
		} finally {
			session.close();
		}
	}
	public int deleteMember(int num) {
		SqlSession session = ssFactory.openSession();
		try {
			return session.delete("dao.memberMapper.deleteMember", num);
		} finally {
			session.close();
		}
	}
	public Map<String, Object> selectOne(int num) {
		SqlSession session = ssFactory.openSession();
		try {
//			return session.selectMap("dao.memberMapper.selectOneMember",num+"");
			return session.selectOne("dao.memberMapper.selectOneMember",num);
		} finally {
			session.close();
		}
	}
	public List<Map<String, Object>> selectAll(){
		SqlSession session = ssFactory.openSession();
		
		try {
			return session.selectList("dao.memberMapper.selectAllMember");
		} finally {
			session.close();
		}
	}
}
