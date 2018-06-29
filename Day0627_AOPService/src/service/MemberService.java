package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.MemberDao;
import model.Member;

@Component
public class MemberService implements IMemberService{
	
	@Autowired
	private MemberDao dao;

	
	@Override
	public List<Member> getMemberList() {	
		return dao.selectAll();
	}
	
	public Member getMember(int num) {
		System.out.println("dao : "+dao);
		return dao.selectOne(num);
	}
	
	
}
