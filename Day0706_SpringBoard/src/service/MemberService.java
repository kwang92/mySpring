package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IMemberDao;
import model.Member;

@Service
public class MemberService {
	@Autowired
	private IMemberDao dao;
	
	public int insertMember(Member member) {
		return dao.insertMember(member);
	}
	public int updateMember(Member member) {
		return dao.updateMember(member);
	}
	public int deleteMember(String id) {
		return dao.deleteMember(id);
	}
	public Member selectOne(String id) {
		return dao.selectOne(id);
	}
	public List<Member> selectAll(){
		return dao.selectAll();
	}
}
