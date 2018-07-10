package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IBoardDao;
import model.Board;

@Service
public class BoardService {
	@Autowired
	private IBoardDao dao;
	private static final int NUM_OF_MESSAGE_PER_PAGE = 5;
	private static final int NUM_OF_NAVI_PAGE = 5;
	
	public int insertBoard(Board board) {
		return dao.insertBoard(board);
	}
	public int updateBoard(Board board) {
		return dao.updateBoard(board);
	}
	public int deleteBoard(int num) {
		return dao.deleteBoard(num);
	}
	public Board selectOne(int num) {
		return dao.selectOne(num);
	}
	public List<Board> selectAll(){	
		return dao.selectAll();
	}
	public Map<String, Object> selectList(int pageNumber) {
		Map<String, Object> viewData
		 = new HashMap<String,Object>();

		int firstRow = 0;
		int endRow =0;
		int totalCount = 0;  //총 메시지의 개수, 총 페이지수를 구하기 위해 필요
		
		totalCount  = dao.selectCount(); //총메시지 개수
		
		firstRow = (pageNumber-1)*NUM_OF_MESSAGE_PER_PAGE +1;
		endRow = pageNumber*NUM_OF_MESSAGE_PER_PAGE;
		//List<Message> selectList(int,int)
		
		Map<String, Integer> rows = new HashMap<String, Integer>();
		rows.put("FIRSTROW", firstRow);
		rows.put("ENDROW", endRow);
		
		
		List<Board> bList 
		  = dao.selectList(rows);
		
		viewData.put("currentPage",pageNumber);
		viewData.put("bList", bList);
		viewData.put("pageTotalCount",calPageTotalCount(totalCount));
		viewData.put("startPage", getStartPage(pageNumber));
		viewData.put("endPage", getEndPage(pageNumber));
		//필요한 데이터 : 총 페이지의 개수, 총 메시지의 개수
		//시작 페이지,종료페이지
		
		return viewData;
	}
	
	
	private int calPageTotalCount(int totalCount) {
		int pageTotalCount = 0;
		if(totalCount != 0) {
			pageTotalCount = (int)Math.ceil(
					((double)totalCount / NUM_OF_MESSAGE_PER_PAGE));
		}
		return pageTotalCount;
	}
	private int getStartPage(int pageNum) {
		int startPage = 
				((pageNum-1)/NUM_OF_NAVI_PAGE)*NUM_OF_NAVI_PAGE + 1;
		
		return startPage;
	}
	private int getEndPage(int pageNum) {
		int endPage 
		= (((pageNum-1)/NUM_OF_NAVI_PAGE)+1)
		* NUM_OF_NAVI_PAGE;
		return endPage;
	}
}
