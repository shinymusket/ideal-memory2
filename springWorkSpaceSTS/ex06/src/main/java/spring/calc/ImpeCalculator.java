package spring.calc;

public class ImpeCalculator implements Calculator {
	// 재귀 없이 팩토리얼 구하는 방법
	// 동작 시간 측정 코드
	
	// 기능 
	// - 핵심 : 팩토리얼 구하는 방법
	// - 공통 : 시간을 구하는 방법 => 수정하고 싶은 기능.
	//         -> 따로 빼서 관리 : 프록시 객체 
	
	
	
	@Override
	public long factorial(long num) {
		
		// long start = System.currentTimeMillis();		// ms 1/1000초
		
		long result = 1;
		
		for (long i = 1; i <= num; i++) {
			result *= i;
		}
		
		// long end = System.currentTimeMillis();
		
		// System.out.printf("ImpeCalculator.factorial(%d) 실행시간 : %d \n", num, (end-start));
		
		return result;
	}

}
