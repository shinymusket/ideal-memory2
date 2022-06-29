package com.green.member.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.member.db.MemberDAO;
import com.green.member.db.MemberDTO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LoginAction");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		MemberDTO member = new MemberDTO();
		MemberDAO manager = MemberDAO.getInstance();
		int result = manager.idCheck(id);
		
		if(result == 0) { // 아이디가 없는 경우
			out.println("<script>");
			out.println("alert('아이디가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
			
		} else if(!passwd.equals(manager.pwCheck(id))) { // 비밀번호가 틀린 경우
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
			
		} else { // 입력한 아이디와 비밀번호가 일치하는 경우
			member = manager.getMember(id);
			HttpSession session = request.getSession();
			// 공유(session) 설정
			session.setAttribute("id", member.getId());
			session.setAttribute("nickname", member.getNickname());
			
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/Index.do");
		
		return forward;
	}

}
