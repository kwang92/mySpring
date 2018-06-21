package dao2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("mDao")
public class MessageDao implements IMessageDao{
	private JdbcTemplate jTemp;
	
	@Autowired
	public MessageDao(JdbcTemplate jTemp) {
		this.jTemp = jTemp;
	}
	@Override
	public int addMessage(Map<String, Object> param) {
		String sql = "insert into Messagetab values(?,?,?,?)";		
		return jTemp.update(sql,param.get("id"),param.get("password"),param.get("name"),param.get("message"));
	}

	@Override
	public int updateMessage(Map<String, Object> param) {
		String sql = "update Message set password = ?, name = ?, message = ?"
				+ "						where id = "+param.get("id");
		return jTemp.update(sql,param.get("password"),param.get("name"),param.get("message"));
	}

	@Override
	public int deleteMessage(String key) {
		String sql = "delete from Message where id = "+key;
		return jTemp.update(sql);
	}

	@Override
	public Map<String, Object> selectOne(String key) {
		String sql = "select * from Message where id = "+key;
//		return jTemp.queryForObject(sql, rowMapper);
		return jTemp.queryForMap(sql,key);
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		String sql = "select * from Message";
//		return jTemp.query(sql,rowMapper);
		return jTemp.queryForList(sql);	// 이런식으로 select들을 구현하면 RowMapper를 쓰지 않아도 됨
	}
	public RowMapper<Map<String, Object>> rowMapper = new RowMapper<Map<String,Object>>() {
		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("mapRow 메소드 호출");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", rs.getInt("id"));
			map.put("password", rs.getString("password"));
			map.put("name", rs.getString("name"));
			map.put("message", rs.getString("message"));
			return map;
		}
	};
//	public RowMapper<Map<String, Object>> rowMapper2 = new RowMapper<Map<String,Object>>() {
//
//		@Override
//		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("id", rs.getInt("id"));
//			map.put("password", rs.getString("password"));
//			map.put("name", rs.getString("name"));
//			map.put("message", rs.getString("message"));
//			return map;
//		}
//		
//	};
}
