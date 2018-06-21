package dao2;

import java.util.List;
import java.util.Map;

public interface IMessageDao {
	public int addMessage(Map<String, Object> param);
	public int updateMessage(Map<String, Object> param);
	public int deleteMessage(String key);
	public Map<String, Object> selectOne(String key);
	public List<Map<String, Object>> selectAll();
}
