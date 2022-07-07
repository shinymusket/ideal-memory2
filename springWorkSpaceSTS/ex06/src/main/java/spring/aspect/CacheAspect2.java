package spring.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2) // 숫자가 작을 수록 우선순위가 높아진다.
public class CacheAspect2 {
	
	private Map<Long, Object> cache = new HashMap<>(); // 임시로 저장할 데이터
	
	@Pointcut("execution(public * spring.calc..*(..))")
	private void publicCacheTarget() {
		
	}
	
	@Around("publicCacheTarget()")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		Long num = (Long) joinPoint.getArgs()[0];
		
		if (cache.containsKey(num)) {
			System.out.printf("CacheAspect: Cache에서 구함 [%d]\n", num);
			return cache.get(num);
		}
		Object result = joinPoint.proceed();
		cache.put(num, result);
		System.out.printf("CacheAspect: Cache에 추가 [%d]\n", num);
		return result;
	}
}
