package service;

import model.Member;

public interface MemberService {
	public boolean checkMember(String id, String pwd);
	public Member getMember(String id);
}
