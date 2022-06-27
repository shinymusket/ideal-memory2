package com.green.shopping.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.shopping.dao.MemberDAO;
import com.green.shopping.vo.MemberVO;

public class MemberUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shopping/memberUpdate.jsp";
		
		int custno = Integer.parseInt(request.getParameter("custno"));
		MemberDAO dao = MemberDAO.getInstatnce();
		MemberVO mVo = dao.selectMemberInfoByCustno(custno);
		
		request.setAttribute("member", mVo);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
