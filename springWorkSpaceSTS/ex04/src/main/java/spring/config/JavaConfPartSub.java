package spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;

@Configuration
public class JavaConfPartSub {
	
	@Autowired
	private MemberDao dao;
	// 설정파일을 통째로 합쳐서 사용할 것임으로 설정파일 통째로 AutoWired를 하면 안됨.
	// 필요한 빈만 주입 받아서 사용하면 됨.
	
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter mip = new MemberInfoPrinter();
		mip.setDao(dao);
		mip.setPrinter(printer()); 
		
		return mip;
	}
}
