package service;

import java.util.List;
import java.util.Map;

import model.Message;

public interface IMessageService {
	public int insertMsg(Message msg);
	public int deleteMsg(int id, String password);
	public Message selectOne(int id);
	public Map<String, Object> selectList(int pageNum);
	public List<Message> selectAll();
	public int calPageTotalCount(int totalCount);
	public int getStartPage(int pageNum);
	public int getEndPage(int pageNum);
}
