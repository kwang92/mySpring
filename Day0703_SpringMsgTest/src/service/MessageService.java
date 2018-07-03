package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IMessageDao;
import model.Message;

@Service
public class MessageService implements IMessageService{
	@Autowired
	private IMessageDao dao;
	private static final int NUM_OF_NAVI_PAGE = 10;
	private static final int NUM_OF_MESSAGE_PER_PAGE = 10;
	
	@Override
	public int insertMsg(Message msg) {
		return dao.addMessage(msg);
	}

	@Override
	public int deleteMsg(int id, String password) {
		Message msg = dao.selectOne(id);
		int result = 0;
		if(msg != null && msg.getPassword().equals(password)) {
			result = dao.deleteMessage(id);
		}
		return result;
	}

	@Override
	public Message selectOne(int id) {
		return dao.selectOne(id);
	}

	@Override
	public Map<String, Object> selectList(int pageNum) {
		int firstRow = 0;
		int endRow = 0;
		int totalCount = 0;
		totalCount = dao.selectCount();
		firstRow = (pageNum-1) * NUM_OF_MESSAGE_PER_PAGE+1;
		endRow = pageNum * NUM_OF_MESSAGE_PER_PAGE;
		Map<String, Integer> rows = new HashMap<String, Integer>();
		rows.put("FIRSTROW", firstRow);
		rows.put("ENDROW", endRow);
		
		Map<String, Object> viewData = new HashMap<String, Object>();
		viewData.put("currentPage", pageNum);
		viewData.put("messageList", dao.selectList(rows));
		viewData.put("pageTotalCount", calPageTotalCount(totalCount));
		viewData.put("startPage", getStartPage(pageNum));
		viewData.put("endPage", getEndPage(pageNum));
		
		return viewData;
	}

	@Override
	public List<Message> selectAll() {
		return dao.selectAll();
	}
	
	public int calPageTotalCount(int totalCount) {
		int pageTotalCount = 0;
		if(totalCount != 0) {
			pageTotalCount = (int)Math.ceil(
					((double)totalCount / NUM_OF_MESSAGE_PER_PAGE));
		}
		return pageTotalCount;
	}
	public int getStartPage(int pageNum) {
		int startPage = ((pageNum-1)/NUM_OF_NAVI_PAGE)*NUM_OF_NAVI_PAGE + 1;
		return startPage;
	}
	public int getEndPage(int pageNum) {
		int endPage = (((pageNum-1)/NUM_OF_NAVI_PAGE)+1)
				* NUM_OF_NAVI_PAGE;
		
		return endPage;
	}
}
