package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IMemberDao;
import model.Member;

@Service
public class MemberService implements IMemberService{
	
	@Autowired
	private IMemberDao dao;
	
	public List<Member> selectAll(){
		return dao.selectAll();
	}
}
