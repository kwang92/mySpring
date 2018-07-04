package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.SampleService;

@Controller
@RequestMapping("/sample")
public class SampleController {
	
	@Autowired
	private SampleService service;
	
	@ResponseBody
	@RequestMapping("/hello")
	public String test() {
		System.out.println("sample/hello 요청 받았습니다.");
		return "hello";
	}
	
	@ResponseBody
	@RequestMapping("/getMap")
	public Map<String, Object> mapReturnTest(){
		Map<String, Object> myMap = new HashMap<String, Object>();
		myMap.put("hello", "안녕하세요");
		return myMap;
	}
	
	@ResponseBody
	@RequestMapping("/memberList")
	public List<Map<String, Object>> memberList(){
		return service.selectAll();
	}
	
	@RequestMapping("/board/{boardNum}")
	public String board(@PathVariable("boardNum") int num) {
		System.out.println("boardNum : "+num);
		return "reply";
	}
}
