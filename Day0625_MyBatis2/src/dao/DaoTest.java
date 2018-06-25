package dao;

import java.util.HashMap;
import java.util.Map;

import common.Constant;

public class DaoTest {
	public static void main(String[] args) {
		Map<String, Object> param = new HashMap<String, Object>();
		StudentDaoImp imp = StudentDaoImp.getInstance();
		
		param.put(Constant.Student.SNUM, 4);
		param.put(Constant.Student.SNAME, "전우치");
		param.put(Constant.Student.SGRADE, 2);
		imp.insertStudent(param);
		
		
		
		for(Map<String, Object> stu : imp.selectAll()) {
			for(String key : stu.keySet()) {
				System.out.print(stu.get(key)+" ");
			}
			System.out.println();
		}
	}
}
