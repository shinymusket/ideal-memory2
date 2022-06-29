package com.green.member.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.member.db.MemberDAO;
import com.green.member.db.MemberDTO;

public class PasswdChange implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("PasswdChange");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		MemberDAO manager = MemberDAO.getInstance();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String passwd = request.getParameter("passwd");
		
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPasswd(passwd);
		int result = manager.updateMemberPwd(member);
		
		System.out.println(result);
		
		PrintWriter out = response.getWriter();
		
		if (result == 0) { // 변경이 안됬을 경우
 			out.print("<script>");
 			out.print("alert('변경 실패');");
 			out.print("history.go(-1);");
 			out.print("</script>");
 			out.close();
 			return null;
		} else { // 변경이 됬을 경우
			request.setAttribute("result", result);
		}
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/LogOut.do");
		
		return forward;
	}

}
