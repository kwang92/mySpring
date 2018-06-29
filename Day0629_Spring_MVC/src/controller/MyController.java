package controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 *	 Controller 반환 값 - ModelAndView, String, void
 * 
 *  ModelAndView : 화면 정보, 데이터 둘 다 가지고 있을 때 사용
 *  String : 화면정보만 필요 할 때 사용  (controller에서의 반환형이 String이면  ModelAndView name으로 인식하기 때문)
 *  void : 둘 다 필요 없을 때 사용 (요청에서 .do를 제외한 요청이름을 viewName으로 간주한다)
 * 
 */



@Controller("My")
public class MyController {
	
	@RequestMapping("/test.do")	// 메소드의 파라미터에 Model을 선언하면, 문자열을 반환하면서  모델데이터도 넘겨줄 수 있다.
	public String test(Model model) {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("test.jsp");
		
//		return "jsp/test.jsp";
		// 위 방법에서 아래 방법으로 하기 위해선 ViewResolver 설정 필요
		model.addAttribute("msg",new String("개ㅑㄱ체"));
		return "test";
	}
	
	@RequestMapping("/whatTime.do")
	public String showTime(Model model) {
		model.addAttribute("nowTime", new Date());
		return "time";
	}
}
