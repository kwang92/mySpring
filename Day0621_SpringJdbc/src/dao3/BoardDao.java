package dao3;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import model.Board;

@Component
public class BoardDao implements IBoardDao{
	private NamedParameterJdbcTemplate npjt;
	
	@Autowired
	public BoardDao(NamedParameterJdbcTemplate npjt) {
		this.npjt = npjt;
	}
	@Override
	public int addBoard(Board board) {
		String sql = "insert into board values"
				+ "		(board_seq.nextval, :title, :name, :pass, :email, :content, 0, sysdate)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("title", board.getTitle());
		params.put("name", board.getName());
		params.put("pass", board.getPass());
		params.put("email", board.getEmail());
		params.put("content", board.getContent());
		
		return npjt.update(sql, params);
	}

	@Override
	public int updateBoard(Board board) {
		String sql = "update board set"
				+ "	title = :title, name = :name, pass = :pass, email = :email"
				+ ", content = :content"
				+ " where num = "+board.getNum();
		
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("title", board.getTitle());
//		params.put("name", board.getName());
//		params.put("pass", board.getPass());
//		params.put("email", board.getEmail());
//		params.put("content", board.getContent());
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(board);	// 이 방법으로도 가능하다 모델 객체의 필드들을 map 형식으로 바꿔줌
		
		return npjt.update(sql, params);
	}

	@Override
	public int deleteBoard(int num) {
		String sql = "delete * from board where num = ?";
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("num", num);
//		
//		return npjt.update(sql, param);
		return npjt.update(sql, Collections.singletonMap("num", num));	// Collections 의 singletonMap은 map을 임시적으로 만들어준다.
	}

	@Override
	public Map<String, Object> selectOne(int num) {
		String sql = "select * from board where num = ?";
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("num", num);
//		return npjt.queryForMap(sql, param);
		
		MapSqlParameterSource param = new MapSqlParameterSource("num",num);	// MapSqlParameterSource 또 한 Map을 만들어준다
		return npjt.queryForMap(sql, param);
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		String sql = "select * from board";
		
		return npjt.getJdbcOperations().queryForList(sql);
	}
	
}
