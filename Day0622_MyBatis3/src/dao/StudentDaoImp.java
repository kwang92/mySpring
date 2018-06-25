package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Student;

public class StudentDaoImp{
	private SqlSessionFactory ssFactory;
	
	public StudentDaoImp() {
		InputStream is = null;
		
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			ssFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insertStudent(Student student) {
		SqlSession session = ssFactory.openSession();
		try {
			return session.getMapper(dao.StudentMapper.class).insertStudent(student);
		} finally {
			session.close();
		}
	}
	public int updateStudent(Student student) {
		SqlSession session = ssFactory.openSession();
		
		try {
			return session.getMapper(dao.StudentMapper.class).updateStudent(student);
		} finally {
			session.close();
		}
	}
	public int deleteStudent(int num) {
		SqlSession session = ssFactory.openSession();
		
		try {
			return session.getMapper(dao.StudentMapper.class).deleteStudent(num);
		} finally {
			session.close();
		}
	}
	public Student selectOne(int num) {
		SqlSession session = ssFactory.openSession();
		
		try {
			return session.getMapper(dao.StudentMapper.class).selectOne(num);
		} finally{
			session.close();
		}
	}
	public List<Student> selectAll(){
		SqlSession session = ssFactory.openSession();
		
		try {
			return session.getMapper(dao.StudentMapper.class).selectAll();
		} finally {
			session.close();
		}
	}
}
