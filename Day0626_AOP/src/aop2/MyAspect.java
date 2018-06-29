package aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	// 공통 관심사항 모듈이 작성될 클래스
	/*
	 *  advice의 종류
	 * 1. before : target 수행 전 실행될 코드
	 * 2. after : target 수행 후 실행될 코드
	 * 3. after-returning : target이 정상적으로 종료되면 실행될 코드
	 * 4. after-throwing : target이 비정상적으로 종료되면 실행될 코드
	 * 5. around : target 앞 뒤로 실행될 코드를 정의
	 * 
	 * 단, after-returning, after-throwing과 after는  실행순서의 연관성이 없으므로 순서의 개연성이 있는 프로그래밍을 하면 안된다.
	 */
	public void before(JoinPoint jp) {
		// target 메소드 실행 전
		System.out.println("Target : "+jp.getTarget());
	}
	public void after(JoinPoint jp) {
		// target 메소드 실행 후
		System.out.println("씻고 잠을 잡니다.");
	}
	public void afterReturning(JoinPoint jp, String msg) {	// JoinPoint, 반환 값
		// target 메소드 정상 종료 후
		System.out.println(msg);
		System.out.println("계산을 합니다.");
	}
	public void afterThrowing(JoinPoint jp,Throwable th) {
		// target 메소드 비정상 종료 후
		System.out.println(th.getMessage());
		System.out.println("엄마한테 혼이 납니다.");
	}
//	public void around(ProceedingJoinPoint jp){
//		// target 실행 전에 실행되고 target을 직접 호출해야하므로 target에 접근 할 수 있어야한다 (ProceedingJoinPoint)
//		try {
//			before();
//			jp.proceed();
//			afterReturning();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			afterThrowing();
//		}
//	}
}
