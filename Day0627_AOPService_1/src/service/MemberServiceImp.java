package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.MemberDao;
import model.Member;

@Component
public class MemberServiceImp implements MemberService{
	
	@Autowired	// 등록되어있는 dao를 Autowired
	private MemberDao dao;
	
	@Override
	public List<Member> getAllMember() {
	
		return dao.selectAll();
	}
	public Member getMember(int num) {
		return dao.selectOne(num);
	}

}
