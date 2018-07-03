package service;

import java.util.List;
import java.util.Map;

public interface IMemberService {
	public int addMember(Map<String,Object> param);
	public int modifyMember(Map<String,Object> param);
	public int removeMember(String id);
	public Map<String, Object> getMemberInfo(String id);
	public List<Map<String, Object>> getAllMembers();
	
	public int insertBoard(Map<String, Object> param);
}
