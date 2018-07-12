package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ApprovService;

@Controller
@RequestMapping("/approv")
public class ApprovController {
	@Autowired
	private ApprovService service;
	
	@RequestMapping("/approvForm")
	public String getApprovForm() {
		return "approv";
	}
	
	@ResponseBody
	@RequestMapping("createApprovLine")
	public void createLine() {
		
	}
}
