package dao;

import java.util.List;

import model.Member;

public interface IMemberDao {
	public Member selectOne(int num);
	public List<Member> selectAll();
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(int num);
}
