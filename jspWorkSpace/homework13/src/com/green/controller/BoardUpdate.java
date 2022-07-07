package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.vo.BoardVO;


@WebServlet("/BU")
public class BoardUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardUpdate.jsp";
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO bVo = dao.selectBoardViewByIdx(idx);
		
		
		request.setAttribute("board", bVo);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "/homework13/BL";
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO bVo = new BoardVO();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		bVo.setIdx(idx);
		bVo.setWriter(writer);
		bVo.setSubject(subject);
		bVo.setContent(content);
	
		dao.updateBoard(bVo);
		response.sendRedirect(url);
	}

}
