package com.green.member.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
	//  System.out.println("LogOut");
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		out.println("<script>");
		out.println("location.href = document.referrer;");
		out.println("</script>");
		out.close();
		
//		ActionForward forward = new ActionForward();
//		forward.setRedirect(true);
//		forward.setPath("/practice01/Index.do");
		
//		return forward;
		
		return null;
	}

}
