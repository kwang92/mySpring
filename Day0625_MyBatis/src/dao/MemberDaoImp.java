package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Member;

public class MemberDaoImp implements MemberDao{
	private SqlSessionFactory factory;
	private static MemberDaoImp dao;
	private MemberDaoImp() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static MemberDaoImp getInstance() {
		if(dao == null) {
			dao = new MemberDaoImp();
		}
		return dao;
	}
	
	@Override
	public int insertMember(Member member) {
		SqlSession session = factory.openSession();
		
		try {
			return session.getMapper(MemberDao.class).insertMember(member);
		} finally {
			session.close();
		}
	}

	@Override
	public int updateMember(Member member) {
		SqlSession session = factory.openSession();
		try{
			return session.getMapper(MemberDao.class).updateMember(member);
		} finally {
			session.close();
		}
	}

	@Override
	public int deleteMember(int num) {
		SqlSession session = factory.openSession();
		try{
			return session.getMapper(MemberDao.class).deleteMember(num);
		} finally {
			session.close();
		}
	}

	@Override
	public Member selectOne(int num) {
		SqlSession session = factory.openSession();
		try{
			return session.getMapper(MemberDao.class).selectOne(num);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Member> selectAll() {
		SqlSession session = factory.openSession();
		try{
			return session.getMapper(MemberDao.class).selectAll();
		} finally {
			session.close();
		}
	}

}
