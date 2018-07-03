package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.IBoardDao;
import dao.IMemberDao;

@Service
public class MemberService implements IMemberService{
	
	@Autowired
	private IMemberDao dao;
	
	@Autowired
	private IBoardDao bDao;
	
	@Override
	@Transactional
	public int addMember(Map<String, Object> param) {
		return dao.insertMember(param);
	}

	@Override
	public int modifyMember(Map<String, Object> param) {
		return dao.updateMember(param);
	}

	@Override
	public int removeMember(String id) {
		return dao.deleteMember(id);
	}

	@Override
	public Map<String, Object> getMemberInfo(String id) {
		return dao.selectOne(id);
	}

	@Override
	public List<Map<String, Object>> getAllMembers() {
		return dao.selectAll();
	}

	@Override
	public int insertBoard(Map<String, Object> param) {
		return bDao.insertBoard(param);
	}
	
}
