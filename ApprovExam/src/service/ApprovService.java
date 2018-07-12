package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ApprovDao;

@Service
public class ApprovService {
	@Autowired
	private ApprovDao dao;
	
	public boolean insertArrpov(Map<String, Object> params) {
		if(dao.insertApprov(params) > 0) {
			return true;
		}
		return false;
	}
	public List<Map<String, Object>> selectAll(){
		return dao.selectAll();
	}
}
