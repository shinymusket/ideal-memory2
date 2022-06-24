package com.green.shopping.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.shopping.dao.MemberDAO;
import com.green.shopping.vo.MemberVO;

public class MemberSelectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "SS?command=member_select";
		
		MemberDAO dao = MemberDAO.getInstatnce();
		List<MemberVO> list = dao.selectAllMember();
		
		
		
		request.setAttribute("memberList", list);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
