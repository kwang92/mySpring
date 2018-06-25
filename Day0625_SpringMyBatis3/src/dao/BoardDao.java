package dao;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	public int insertBoard(Map<String, Object> param);
	public int updateBoard(Map<String, Object>param);
	public int deleteBoard(int num);
	public Map<String, Object> selectOne(int num);
	public List<Map<String, Object>> selectAll();
}
