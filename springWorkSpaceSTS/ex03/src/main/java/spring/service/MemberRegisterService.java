package spring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dao.MemberDao;
import spring.exception.AlreadyExistingMemberException;
import spring.vo.Member;
import spring.vo.RegisterRequest;

public class MemberRegisterService { // 회원 가입 기능
	
//	private MemberDao dao = new MemberDao(); // 의존 객체를 직접 생성


	private MemberDao dao;
	
	
	@Autowired             // 자동 주입 어노테이션
	public MemberRegisterService(MemberDao memberDao) {
		this.dao = memberDao; // 객체를 주입 받을 생성자.
	}
	
	
	
	
	
	
	public void regist(RegisterRequest req) {
			
		Member member = dao.selectByEmail(req.getEmail());
		
		if (member != null) {
			throw new AlreadyExistingMemberException("중복 : " + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		
		dao.insertMember(newMember);
	}
}
