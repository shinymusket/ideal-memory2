package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import spring.aspect.ExeTimeAspect02;
import spring.calc.ImpeCalculator;
import spring.calc.RecCalculator;

@Configuration
@EnableAspectJAutoProxy 		// <aop:aspectj-autoproxy/> 
public class JavaConfig { //  = appCtx02.xml
	
	@Bean
	public ExeTimeAspect02 exeTimeAspect() {
		return new ExeTimeAspect02();
	}
	
	@Bean
	public ImpeCalculator impeCalc () {
		return new ImpeCalculator();
	}
	
	@Bean
	public RecCalculator recCalc () {
		return new RecCalculator();
	}
}
