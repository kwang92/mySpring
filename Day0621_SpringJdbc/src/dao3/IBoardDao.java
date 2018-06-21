package dao3;

import java.util.List;
import java.util.Map;

import model.Board;

public interface IBoardDao {
	public int addBoard(Board board);
	public int updateBoard(Board board);
	public int deleteBoard(int num);
	public Map<String, Object> selectOne(int num);
	public List<Map<String, Object>> selectAll();
}
