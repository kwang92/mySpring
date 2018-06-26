package aop2;

import java.util.Random;

public class Boy implements Person{
	public void doSomething() throws Exception {
		
		System.out.println("피시방가서 게임을 한다.");
		
		if(new Random().nextBoolean()) {
			throw new Exception("엄마 호출");
		}
	}
}
