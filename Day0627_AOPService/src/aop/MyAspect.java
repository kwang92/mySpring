package aop;

import org.aspectj.lang.ProceedingJoinPoint;
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
	
	@Pointcut("execution(public * *.getMember*(..))")
	public void mypt() {}
	
	public void before() {
		System.out.println("전");
	}
	public void afterReturning() {
		System.out.println("정상종료");
	}
	public void afterThrowing() {
		System.out.println("비정상종료");
	}
	@Around("mypt()")
	public void around(ProceedingJoinPoint jp) {
		try {
			before();
			jp.proceed();
			afterReturning();
		} catch (Throwable e) {
			afterThrowing();
		}
	}
}
