package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component	// Component로 bean등록을 해줘야 Interceptor 사용 가능
public class SampleInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 요청을 처리하고 난 후 실행
		System.out.println("PostHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 요청을 처리하기 전 실행
		// 반환 값을 true로 주면 요청 계속 진행 , false면 요청 처리 중단
		System.out.println("PreHandle");
		return true;
	}
	
}
