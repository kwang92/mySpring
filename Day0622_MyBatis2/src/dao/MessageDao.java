package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Message;

@Component
public class MessageDao {
	private SqlSessionFactory ssFactory;

	@Autowired
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

	public int insertMsg(Message msg) {
		SqlSession session = ssFactory.openSession();
		try {
			return session.insert("dao.messageMapper.addMessage", msg);
		} finally {
			session.close();
		}
	}
	public int updateMsg(Message msg) {
		SqlSession session = ssFactory.openSession();
		try {
			return session.update("dao.messageMapper.updateMessage",msg);
		} finally {
			session.close();
		}
	}
	public int deleteMsg(int id) {
		SqlSession session = ssFactory.openSession();
		try {
			return session.delete("dao.messageMapper.deleteMessage",id);
		} finally {
			session.close();
		}
	}
	public Message selectOne(int id) {
		SqlSession session = ssFactory.openSession();
		try {
			return session.selectOne("dao.messageMapper.selectOneMsg",id);
		} finally {
			session.close();
		}
	}
	public List<Message> selectAll(){
		SqlSession session = ssFactory.openSession();
		try {
			return session.selectList("dao.messageMapper.selectAllMsg");
		} finally {
			session.close();
		}
	}
}
