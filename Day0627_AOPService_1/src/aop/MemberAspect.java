package aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MemberAspect {
	private static final Logger LOG = Logger.getLogger(MemberAspect.class);
	
	@Pointcut("execution(* service.*ServiceImp.*(..))")	//service 패키지 밑의 ServiceImp 클래스로 끝나는 메소드는 aop 실행
	public void servicept() {}
	
	
	@Before("servicept()")
	public void startService() {
		LOG.debug("DEBUG : 서비스 시작합니다.");
		LOG.info("INFO : 서비스 시작합니다.");
	}
	
	@After("servicept()")
	public void endService() {
		LOG.debug("DEBUG : 서비스 종료합니다.");
		LOG.info("INFO : 서비스 시작합니다.");
	}
}
