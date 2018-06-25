package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Student;

public interface StudentMapper {
		// Student Dao 메소드 선언
	
	@Insert("insert into student_ex values(#{snum}, #{sname}, #{sgrade})")
	public int insertStudent(Student student);
	
	@Update("update student_ex set snum = #{snum}, sname = #{sname}, sgrade = #{sgrade} where snum = #{snum}")
	public int updateStudent(Student student);
	
	@Delete("delete from student_ex where snum = #{snum}")
	public int deleteStudent(int num);
	
//	@Results({
//		@Result(property = "s_Num", column = "snum"),
//		@Result(property = "s_Name", column = "sname"),
//		@Result(property = "s_Grade", column = "sgrade")
//	})
	@Select("select * from student_ex where snum = #{snum}")
	public Student selectOne(int num);
	
	@Select("select * from student_ex")
	public List<Student> selectAll();
}
