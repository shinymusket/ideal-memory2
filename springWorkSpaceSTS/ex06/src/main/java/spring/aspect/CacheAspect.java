package spring.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CacheAspect {
	
	private Map<Long, Object> cache = new HashMap<>(); // 정보를 임시로 저장할 공간
	
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		Long num = (Long) joinPoint.getArgs()[0];
		
		if (cache.containsKey(num)) {
			System.out.println("캐시Aspect에서 구함 : " + num);
			return cache.get(num);
		}
		
		Object result = joinPoint.proceed();
		cache.put(num, result); // 핵심 기능의 결과를 캐시에 저장
		System.out.println("캐시Aspect에 저장 : " + num);
		
		return result;
	}
}
