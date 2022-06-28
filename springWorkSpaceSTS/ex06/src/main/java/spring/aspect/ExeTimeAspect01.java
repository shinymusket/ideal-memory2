package spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExeTimeAspect01 { // 공통의 기능을 담을 Aspect 객체 : 어떤 핵심 기능이 실행될 때 구동되는가?
				// POJO 클래스
	
	public Object m(ProceedingJoinPoint jp) throws Throwable { // 스프링 프록시가 핵심기능을 가로채서 먼저 수행하도록 만들 메서드
					// 핵심기능에 관련된 정보
		
		 long start = System.nanoTime();
		 // --------------------------------------------------------------------------------------------------
		 // 핵심 기능을 수행하도록
		 
		 Object	result = jp.proceed(); // 핵심기능을 간접적으로 수행하세요.

		 // --------------------------------------------------------------------------------------------------
		
		long end = System.nanoTime();
		
		System.out.println("실행 시간 : " + (end-start));
		
//		System.out.printf("%s.factorial(%d) 실행시간 : %d \n", calc.getClass().getSimpleName(), num, (end-start));
		
		return result;
	}
}
