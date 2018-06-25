package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MessageDao {
	private SqlSessionFactory ssFactory;
	
	public MessageDao() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			ssFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insertMsg(Map<String, Object> param) {
		SqlSession session = ssFactory.openSession();
		try {
			return session.getMapper(dao.MessageMapper.class).insertMsg(param);
		} finally {
			session.close();
		}
	}
	
	public int updateMsg(Map<String, Object> param) {
		SqlSession session = ssFactory.openSession();
		try {
			return session.getMapper(dao.MessageMapper.class).updateMsg(param);
		} finally {
			session.close();
		}
	}
	
	public int deleteMsg(int num) {
		SqlSession session = ssFactory.openSession();
		try {
			return session.getMapper(dao.MessageMapper.class).deleteMsg(num);
		} finally{
			session.close();
		}
	}
	
	public Map<String, Object> selectOne(int num){
		SqlSession session = ssFactory.openSession();
		try {
			return session.getMapper(dao.MessageMapper.class).selectOne(num);
		} finally {
			session.close();
		}
	}
	
	public List<Map<String, Object>> selectAll(){
		SqlSession session = ssFactory.openSession();
		
		try {
			return session.getMapper(dao.MessageMapper.class).selectAll();
		} finally {
			session.close();
		}
	}
}
