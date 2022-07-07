package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.vo.BoardVO;

@WebServlet("/BL")
public class BoardList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardList.jsp";
		int count = 0;
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> list = dao.selectBoardList();
		
		
		count = list.size();
		
		request.setAttribute("boardCount", count);
		request.setAttribute("boardList", list);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
