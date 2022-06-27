package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.bean.Client1;
import spring.bean.Client2;

public class Main01 {

	public static void main(String[] args) {
		// 스프링 빈 생성 없이 객체 생성
		Client1 c0 = new Client1();
		c0.setHost("웹서버1");
		c0.send();
		
		System.out.println("-------------------------------------");
		// 스프링 빈으로 등록하고 빈 생성
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtx.xml"); // 빈 초기화
		
		// set메서드 동작 후 초기화
		Client1 c1 = ctx.getBean("c2", Client1.class);
		
		c1.send();
		
		ctx.close(); // 빈 소멸

	}

}
