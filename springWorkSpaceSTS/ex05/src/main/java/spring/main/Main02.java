package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.bean.Client2;

public class Main02 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtx.xml"); // 빈 초기화

		// 임의의 초기화, 소멸 메서드
		Client2 c2 = ctx.getBean("c2", Client2.class);
		
		c2.send();
		
		ctx.close(); // 빈 소멸
	}

}
