package dao;

import model.Student;

public class StudentDaoTest {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		Student stu = new Student();
		
//		stu.setSname("홍길동테스트");
//		stu.setSnum(77);
//		stu.setSgrade(6);
//		dao.insertStudent(stu);
		
		System.out.println(dao.selectOne(1));
		
		for(Student s : dao.selectAll()) {
			System.out.println(s);
		}
	}
}
