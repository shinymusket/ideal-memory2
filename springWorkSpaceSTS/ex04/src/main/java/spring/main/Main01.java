package spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.config.JavaMainConfig;
import spring.printer.MemberInfoPrinter;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;

public class Main01 {

	public static void main(String[] args) {
		// 자바 설정파일을 이용한 스프링 동작
//		ApplicationContext ctx = 
//				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// 두개 이상의 자바 설정 파일 따로따로 읽어오기
//		ApplicationContext ctx = 
//				new AnnotationConfigApplicationContext(JavaConf01.class, JavaConf02.class);
		
		// 두개 이상의 자바 설정파일을 하나로 합쳐서 가져오기
//		ApplicationContext ctx = 
//				new AnnotationConfigApplicationContext(JavaConfPartMain.class);

		// 자바 설정과 XML 설정을 합치는 방법
		// 1) xml을 기준으로 Java를 합쳐서 처리
//		ApplicationContext ctx = 
//				new GenericXmlApplicationContext("classpath:main-config.xml");
//		
		// 2) 자바를 기준으로 xml를 합쳐서 처리
		
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaMainConfig.class);
		
		MemberRegisterService regSvc =
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		MemberInfoPrinter infoPrt =
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		// 회원 가입 진행
		RegisterRequest rr = new RegisterRequest();
		
		rr.setEmail("hong@naver.com");
		rr.setName("홍길동");
		rr.setPassword("1234");
		rr.setConfirmPassword("1234");
		
		regSvc.regist(rr);
		
		// 등록된 회원 정보 출력
		infoPrt.printMemberInfo("hong@naver.com");
		
		
	}

}
