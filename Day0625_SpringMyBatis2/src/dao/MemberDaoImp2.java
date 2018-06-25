package dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberDaoImp2")
public class MemberDaoImp2 implements MemberDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertMember(Map<String, Object> member) {
		return session.getMapper(MemberDao.class).insertMember(member);
	}

	@Override
	public int updateMember(Map<String, Object> member) {
		return session.getMapper(MemberDao.class).updateMember(member);

	}

	@Override
	public int deleteMember(int num) {
		return session.getMapper(MemberDao.class).deleteMember(num);
	}

	@Override
	public Map<String, Object> selectOne(int num) {
		return session.getMapper(MemberDao.class).selectOne(num);
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		return session.getMapper(MemberDao.class).selectAll();

	}

}
