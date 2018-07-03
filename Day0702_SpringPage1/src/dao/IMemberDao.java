package dao;

import java.util.List;
import java.util.Map;

public interface IMemberDao {
	public int insertMember(Map<String,Object> param);
	public int updateMember(Map<String,Object> param);
	public int deleteMember(String id);
	public Map<String, Object> selectOne(String id);
	public List<Map<String, Object>> selectAll();
}
