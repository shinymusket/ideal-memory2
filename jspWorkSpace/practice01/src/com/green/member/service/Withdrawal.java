package com.green.member.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.member.db.MemberDAO;
import com.green.member.db.MemberDTO;

public class Withdrawal implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Withdrawal");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		MemberDAO manager = MemberDAO.getInstance();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		MemberDTO member = new MemberDTO();
		int result = manager.withdrawalMember(id);
		
		System.out.println(result);
		
		PrintWriter out = response.getWriter();
		
		if (result == 0) { // 탈퇴가 안됬을 경우
 			out.print("<script>");
 			out.print("alert('탈퇴 실패');");
 			out.print("history.go(-1);");
 			out.print("</script>");
 			out.close();
 			return null;
		} else { // 탈퇴가 됬을 경우
			request.setAttribute("result", result);
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/LogOut.do");
		
		return forward;
	}

}
