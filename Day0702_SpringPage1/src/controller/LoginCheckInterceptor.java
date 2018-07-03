package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("post");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Session 의 로그인 정보에 의해 요청 처리 결정 true , false
		System.out.println("로그인 체크 수행");
		if(request.getSession().getAttribute("user") == null) {
			System.out.println("로그인 정보 없음");
			response.sendRedirect("loginForm");
			return false;
		}
		return true;
	}
	
}
