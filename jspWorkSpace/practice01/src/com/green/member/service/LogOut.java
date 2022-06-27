package com.green.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LogOut");
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("/practice01/Index.do");
		
		return forward;
	}

}