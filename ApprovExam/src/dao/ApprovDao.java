package dao;

import java.util.List;
import java.util.Map;

public interface ApprovDao {
	public int insertApprov(Map<String, Object> params);
	public List<Map<String, Object>> selectAll();
}
