package dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Student;

public class StudentDaoImp implements StudentDao{
	private SqlSessionFactory factory;
	
	public void setSqlSessionFactory(SqlSessionFactory factory) {
		this.factory = factory;
		System.out.println("sessionFacotry 설정완료");
	}
	
	public int insertStudent(Student param) {
		SqlSession session = factory.openSession();
		
		try {
			return session.getMapper(StudentDao.class).insertStudent(param);
		} finally {
			session.close();
		}
	}

	@Override
	public int updateStudent(Student param) {
		SqlSession session = factory.openSession();
		try{
			return session.getMapper(StudentDao.class).updateStudent(param);
		} finally {
			session.close();
		}
	}

	@Override
	public int deleteStudent(int snum) {
		SqlSession session = factory.openSession();
		try{
			return session.getMapper(StudentDao.class).deleteStudent(snum);
		} finally {
			session.close();
		}
	}

	@Override
	public Student selectOne(int snum) {
		SqlSession session = factory.openSession();
		
		try{
			return session.getMapper(StudentDao.class).selectOne(snum);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Student> selectAll() {
		SqlSession session = factory.openSession();
		try{
			return session.getMapper(StudentDao.class).selectAll();
		} finally {
			session.close();
		}
	}

}
