package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StudentDao;

@Service
public class StudentService {
	@Autowired
	private StudentDao dao;
	
	public int insertStudent(Map<String, Object> param) {
		return dao.insertStudent(param);
	}
	public int updateStudent(Map<String, Object> param) {
		return dao.updateStudent(param);
	}
	public int deleteStudent(int snum) {
		return dao.deleteStudent(snum);
	}
	public Map<String, Object> selectOne(int snum){
		return dao.selectOne(snum);
	}
	public List<Map<String, Object>> selectStudentsByGrade(int sgrade){
		return dao.selectStudentsByGrade(sgrade);
	}
	public List<Map<String, Object>> selectAll(){
		return dao.selectAll();
	}
}
