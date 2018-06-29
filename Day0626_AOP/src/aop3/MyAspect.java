package aop3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	// pointcut 정의하기, public void 타입의 메소드 위에 pointcut 정의
	
	@Pointcut("execution(public * *.doSomething(..))")
	public void mypt() {}// method 의 이름이 pointcut의 id가 됨
	
	@Before("mypt()")
	public void before(JoinPoint jp) {
		// target 메소드 실행 전
		System.out.println("Target : "+jp.getTarget());
	}
	@After("mypt()")
	public void after(JoinPoint jp) {
		// target 메소드 실행 후
		System.out.println("씻고 잠을 잡니다.");
	}
	@AfterReturning(pointcut = "mypt()", returning = "msg")
	public void afterReturning(JoinPoint jp, String msg) {	// JoinPoint, 반환 값
		// target 메소드 정상 종료 후
		System.out.println(msg);
		System.out.println("계산을 합니다.");
	}
	@AfterThrowing(pointcut = "mypt()", throwing = "th")
	public void afterThrowing(JoinPoint jp,Throwable th) {
		// target 메소드 비정상 종료 후
		System.out.println(th.getMessage());
		System.out.println("엄마한테 혼이 납니다.");
	}
	
	@Around("mypt()")
	public void around(ProceedingJoinPoint jp){
		// target 실행 전에 실행되고 target을 직접 호출해야하므로 target에 접근 할 수 있어야한다 (ProceedingJoinPoint)
		try {
			before(jp);
			String msg = (String)jp.proceed();
			afterReturning(jp,msg);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			afterThrowing(jp,e);
		}
	}
}
