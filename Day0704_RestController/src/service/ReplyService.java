package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IReplyDao;
import model.Reply;

@Service
public class ReplyService implements IReplyService{
	
	@Autowired
	private IReplyDao dao;
	
	@Override
	public int insertReply(Reply reply) {
		System.out.println("서비스의 dao insertReply 시작");
		return dao.insertReply(reply);
	}

	@Override
	public int updateReply(Reply reply) {
		return dao.updateReply(reply);
	}

	@Override
	public int deleteReply(int replyNum) {
		return dao.deleteReply(replyNum);
	}

	@Override
	public Reply selectOne(int replyNum) {
		return dao.selectOne(replyNum);
	}

	@Override
	public List<Reply> selectByBoardNum(int boardNum) {
		return dao.selectByBoardNum(boardNum);
	}

}
