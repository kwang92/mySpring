package dao;

import java.util.Map;

public interface IDocDao {
	public int insertDoc(Map<String, String> param);
	public Map<String, String> selectOne(String docNum);
}
