package dao;

import model.Member;

public class DaoTest {
	public static void main(String[] args) {
		MemberDaoImp dao = MemberDaoImp.getInstance();
		
//		System.out.println(dao.selectOne(1));
//		
//		dao.deleteMember(1);
//		Member member = new Member();
//		member.setNum(3);
//		member.setName("전우치");
//		member.setGender("남자");
//		member.setAge(33);
//		dao.insertMember(member);

		Member member = dao.selectOne(2);
		member.setGender("남자");
		dao.updateMember(member);
		
		
		for(Member mem : dao.selectAll()) {
			System.out.println(mem);
		}
	}
}
