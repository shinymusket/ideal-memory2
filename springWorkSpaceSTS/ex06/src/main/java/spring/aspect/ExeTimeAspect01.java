package spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

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
		
		
 // --------------------------------------------------------------------------------------------------	
		// ProceedingJoinPoint 객체의 정보
		Signature sig = jp.getSignature(); // 핵심기능을 가진 메서드의 정보를 꺼내보는 기능
		String methodName = sig.getName(); // 메서드의 이름
		String methodAllInfo = sig.toLongString(); // 매개정보, 반환정보
		
		System.out.println("핵심기능 메서드 : " + methodName);
		System.out.println("핵심기능 메서드 정보 : " + methodAllInfo);
		
		jp.getTarget(); // 대상 객체
		String className = jp.getTarget().getClass().getSimpleName(); // 대상 객체의 이름 정보
		
		System.out.println("대상 객체의 이름 : " + className);
		
		jp.getArgs(); // 매개값의 정보 => 배열
		String argName = Arrays.toString(jp.getArgs());
						// 배열을 문자열로 전환
		
		System.out.println("매개값 정보 : " + argName);
		
		return result;
	}
}
