package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import model.Member;

@Service
public class MemberServiceImp implements MemberService{
	@Autowired
	private MemberDao dao;
	
	@Override
	public boolean checkMember(String id, String pwd) {
		Member mem = dao.selectOne(id);
		boolean result = false;
		
		if(mem != null) {
			if(mem.getPw().equals(pwd)) {
				result = true;				
			}
		}
		return result;
	}
	@Override
	public Member getMember(String id) {
		return dao.selectOne(id);
	}
	
	

}
