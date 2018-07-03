package dao;

import java.util.List;
import java.util.Map;

import model.Message;

public interface IMessageDao {
	public int addMessage(Message msg);
	public int deleteMessage(int id);
	public int selectCount();
	public Message selectOne(int id);
	public List<Message> selectList(Map<String, Integer> rows);
	public List<Message> selectAll();
}
