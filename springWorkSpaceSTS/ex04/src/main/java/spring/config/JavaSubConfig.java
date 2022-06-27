package spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;

@Configuration
public class JavaSubConfig {
	
	// 설정파일을 하나로 합치는 경우 주입대상만 Autowired 처리 한다.
	@Autowired
	private MemberDao dao;
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter info = new MemberInfoPrinter();
		info.setDao(dao);
		info.setPrinter(printer());
		
		return info;
	}
}
