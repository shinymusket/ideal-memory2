package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.bean.Client3;
import spring.config.JavaConfig;

public class Main04 {

	public static void main(String[] args) {
		useXml();
		System.out.println("====================================================");
		useJava();
		
		
		
		
		
		

	}

	private static void useJava() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// 사용할 빈 객체
		Client3 c3_1 = ctx.getBean("c3", Client3.class);
		Client3 c3_2 = ctx.getBean("c3", Client3.class);
		
		System.out.println("(c3_1 == c3_2) : " + (c3_1 == c3_2)); // 포로토타입인 경우 - false
		ctx.close();
		
	}

	private static void useXml() {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		// 사용할 빈 객체
		Client3 c3_1 = ctx.getBean("c3", Client3.class);
		Client3 c3_2 = ctx.getBean("c3", Client3.class);
		
		System.out.println("(c3_1 == c3_2) : " + (c3_1 == c3_2)); // 포로토타입인 경우 - false
		
	}

}
