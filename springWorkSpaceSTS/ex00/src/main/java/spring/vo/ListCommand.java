package spring.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ListCommand {
	
	// 뷰에서 from, to에 해당하는 데이터를 커맨드 객체에 담아서 컨트롤러에 보낸다
	// 뷰에서 보낸 데이터는 text 문자열
	// 커맨드 객체의 프로퍼티 타입은 Date
	
	// 문자열 => 기본타입 자동 형변환을 지원(스프링)
	// 문자열 => Date 타입으로 형변환을 하도록 설정해줄 필요가 있음.
	
	@DateTimeFormat(pattern = "yyyyMMddHH") // 2020050100
	private Date from;
	@DateTimeFormat(pattern = "yyyyMMddHH")
	private Date to;
	
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	
	
}
