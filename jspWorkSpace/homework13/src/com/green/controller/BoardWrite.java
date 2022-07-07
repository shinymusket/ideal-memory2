package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.vo.BoardVO;


@WebServlet("/BW")
public class BoardWrite extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardWrite.jsp";
		response.sendRedirect(url);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/homework13/BL";
		
		request.setCharacterEncoding("UTF-8");
		
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		BoardVO bVo = new BoardVO();
		bVo.setWriter(writer);
		bVo.setSubject(subject);
		bVo.setContent(content);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.insertBoard(bVo);
		
		response.sendRedirect(url);
	}

}
