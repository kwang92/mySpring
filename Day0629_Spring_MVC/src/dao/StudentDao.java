package dao;

import java.util.List;
import java.util.Map;

public interface StudentDao {
	public int insertStudent(Map<String, Object> param);
	public int updateStudent(Map<String, Object> param);
	public int deleteStudent(int num);
	public Map<String, Object> selectOne(int num);
	public List<Map<String, Object>> selectAll();
	public List<Map<String, Object>> selectStudentsByGrade(int grade);
}
