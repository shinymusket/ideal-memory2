package com.green.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.board.dao.BoardDAO;

public class BoardCheckPass implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("pass");
		String url = null;
		
		BoardDAO dao = BoardDAO.getInstance();
		
		if(dao.checkPassword(num, pass)) {
			System.out.println("암호 일치");
			url = "board/checkSuccess.jsp";
			
		} else {
			System.out.println("암호 불일치");
			url = "board/boardCheckPass.jsp";
			request.setAttribute("msg", "비밀번호가 틀렸습니다.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
