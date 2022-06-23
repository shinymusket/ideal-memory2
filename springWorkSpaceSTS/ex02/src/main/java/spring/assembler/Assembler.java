package spring.assembler;

import spring.dao.MemberDao;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;

public class Assembler { // 객체 조립기

	private MemberDao dao;
	
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		dao = new MemberDao();
		regSvc = new MemberRegisterService(dao);
		pwdSvc = new ChangePasswordService(dao);
	}

	public MemberDao getDao() {
		return dao;
	}

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}

	public MemberRegisterService getRegSvc() {
		return regSvc;
	}

	public void setRegSvc(MemberRegisterService regSvc) {
		this.regSvc = regSvc;
	}

	public ChangePasswordService getPwdSvc() {
		return pwdSvc;
	}

	public void setPwdSvc(ChangePasswordService pwdSvc) {
		this.pwdSvc = pwdSvc;
	}
	
	
}
