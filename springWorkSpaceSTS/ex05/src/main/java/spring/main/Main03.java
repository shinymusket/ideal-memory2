package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.bean.Client2;
import spring.config.JavaConfig;

public class Main03 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig.class); // 빈 초기화

		// 임의의 초기화, 소멸 메서드
		Client2 c2 = ctx.getBean("c2", Client2.class);
		
		c2.send();
		
		ctx.close(); // 빈 소멸

	}

}
