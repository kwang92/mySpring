package dao;

import java.util.List;
import java.util.Map;


public interface MemberDao {
	public int insertMember(Map<String, Object> member);
	public int updateMember(Map<String, Object> member);
	public int deleteMember(int num);
	public Map<String, Object> selectOne(int num);
	public List<Map<String, Object>> selectAll();
}
