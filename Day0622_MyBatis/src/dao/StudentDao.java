package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Student;

public class StudentDao {
	private SqlSessionFactory ssFactory;
	
	public StudentDao() {
		// 설정파일( configuration으로 부터 해당 정보를 이용해서 factory 객체 생성 )
		// SqlSessionFactoryBuilder를 이용해서 SqlSessionFactory 객체를 생성하는데
		// SqlSessionFactoryBuilder에는 stream을 이용해서 build를 한다.
		
		InputStream is = null;	// configuration.xml 파일 정보를 읽어올 stream
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			ssFactory = new SqlSessionFactoryBuilder().build(is);	// ssFactory build
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public int insertStudent(Student student) {
		SqlSession session = ssFactory.openSession();
		try {
			return session.insert("dao.studentMapper.insertStudent",student);
		} finally {
			session.close();
		}
		
//		return ssFactory.openSession().insert("dao.studentMapper.insertStudent",student);
	}
	public int updateStudent(Student student) {
		SqlSession session = ssFactory.openSession();
		
		try {
			return session.update("dao.studentMapper.updateStudent",student);
		} finally {
			session.close();
		}
		
//		return ssFactory.openSession().update("dao.studentMapper.updateStudent",student);
	}
	public int deleteStudent(int snum) {
		SqlSession session = ssFactory.openSession();
		
		try {
			return session.delete("dao.studentMapper.deleteStudent",snum);
		} finally {
			session.close();
		}
	}
	public Student selectOne(int snum) {
		SqlSession session = ssFactory.openSession();
		Student student = session.selectOne("dao.studentMapper.selectOne", snum);
		
		try {
			return student;
		} finally {
			session.close();
		}
		
	}
	public List<Student> selectAll() {
		SqlSession session = ssFactory.openSession();
		List<Student> sList = session.selectList("dao.studentMapper.selectAll");
		
		try {
			return sList;
		} finally {
			session.close();
		}
	}
}
