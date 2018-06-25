package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MessageMapper {
	
	@Insert("INSERT into message values(message_seq.nextval, #{PASSWORD}, #{NAME}, #{MESSAGE})")
	public int insertMsg(Map<String, Object> param);
	
	@Update("UPDATE message set id = #{ID}, password = #{PASSWORD}, name = #{NAME}, message = #{MESSAGE}"
			+ "				where id = #{ID}")
	public int updateMsg(Map<String, Object> param);
	
	@Delete("DELETE from message where id = #{ID}")
	public int deleteMsg(int num);
	
	@Select("SELECT * from message where id = #{ID}")
	public Map<String, Object> selectOne(int num);
	
	@Select("SELECT * from message")
	public List<Map<String , Object>> selectAll();
}
