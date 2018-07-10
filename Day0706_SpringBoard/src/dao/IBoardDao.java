package dao;

import java.util.List;
import java.util.Map;

import model.Board;

public interface IBoardDao {
	public int selectCount();
	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public int deleteBoard(int num);
	public Board selectOne(int num);
	public List<Board> selectList(Map<String, Integer> rows);
	public List<Board> selectBoardsByOption(int option, String keyword);
	public List<Board> selectAll();
}
