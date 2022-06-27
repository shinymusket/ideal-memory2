package com.green.shopping.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.shopping.dao.MemberDAO;
import com.green.shopping.vo.PriceVO;

public class MemberSelectPriceAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shopping/memberSelectPrice.jsp";
		
		MemberDAO dao = MemberDAO.getInstatnce();
		List<PriceVO> list = dao.selectMemberPrice();
		
		request.setAttribute("memberPriceList", list);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
