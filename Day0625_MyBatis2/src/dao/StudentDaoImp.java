package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StudentDaoImp implements StudentDao{
	private SqlSessionFactory factory;
	private static StudentDaoImp imp;
	private StudentDaoImp() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static StudentDaoImp getInstance() {
		if(imp == null) {
			imp = new StudentDaoImp();
		}
		return imp;
	}
	@Override
	public int insertStudent(Map<String, Object> param) {
		SqlSession session = factory.openSession();
		
		try {
			return session.getMapper(StudentDao.class).insertStudent(param);
		} finally {
			session.close();
		}
	}

	@Override
	public int updateStudent(Map<String, Object> param) {
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
	public Map<String, Object> selectOne(int snum) {
		SqlSession session = factory.openSession();
		
		try{
			return session.getMapper(StudentDao.class).selectOne(snum);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		SqlSession session = factory.openSession();
		try{
			return session.getMapper(StudentDao.class).selectAll();
		} finally {
			session.close();
		}
	}

}
