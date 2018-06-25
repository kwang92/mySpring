package dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDaoImp implements MemberDao{
	@Autowired
	private SqlSessionFactory factory;
	
//	private MemberDaoImp(SqlSessionFactory factory) {
//		this.factory = factory;
//		System.out.println(factory);
//		System.out.println("factory 생성완료");
//	}
	
	@Override
	public int insertMember(Map<String, Object> member) {
		SqlSession session = factory.openSession();
		
		try {
			return session.getMapper(MemberDao.class).insertMember(member);
		} finally {
			session.close();
		}
	}

	@Override
	public int updateMember(Map<String, Object> member) {
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
	public Map<String, Object> selectOne(int num) {
		SqlSession session = factory.openSession();
		try{
			return session.getMapper(MemberDao.class).selectOne(num);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		SqlSession session = factory.openSession();
		try{
			return session.getMapper(MemberDao.class).selectAll();
		} finally {
			session.close();
		}
	}

}
