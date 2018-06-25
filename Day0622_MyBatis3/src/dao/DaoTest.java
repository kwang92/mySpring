package dao;

import model.Student;

public class DaoTest {
	public static void main(String[] args) {
		StudentDaoImp dao = new StudentDaoImp();
//		Student stu = new Student();
//		stu.setSnum(2);
//		stu.setSname("홍길동");
//		stu.setSgrade(4);
//		dao.insertStudent(stu);
//		stu.setSnum(3);
//		stu.setSname("신사임당");
//		stu.setSgrade(1);
//		dao.insertStudent(stu);
//		
		
		System.out.println(dao.selectOne(2));
		System.out.println("=======================================");
		for(Student s : dao.selectAll()) {
			System.out.println(s);
		}
	}
}
