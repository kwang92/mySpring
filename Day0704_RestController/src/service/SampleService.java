package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IMemberDao;

@Service
public class SampleService implements ISampleService{
	
	@Autowired
	private IMemberDao dao;

	@Override
	public List<Map<String, Object>> selectAll() {
		return dao.selectAll();
	}
	
}
