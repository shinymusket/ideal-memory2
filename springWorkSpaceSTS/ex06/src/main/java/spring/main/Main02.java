package spring.main;

import spring.calc.ImpeCalculator;
import spring.calc.RecCalculator;
import spring.proxy.ExeTimeCalculator;

public class Main02 {

	public static void main(String[] args) {
		// 팩토리얼 구하기 => 프록시를 거쳐서
		
		ExeTimeCalculator impeCal = new ExeTimeCalculator(new ImpeCalculator());
		long impeResult = impeCal.factorial(7);
		
		ExeTimeCalculator recCal = new ExeTimeCalculator(new RecCalculator());
		long recResult = recCal.factorial(7);
		
		System.out.println("impeResult 계산 결과 : " + impeResult);
		System.out.println("recResult 계산 결과 : " + recResult);
	}

}
