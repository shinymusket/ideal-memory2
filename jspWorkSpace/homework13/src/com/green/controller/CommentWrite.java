package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.CommentDAO;
import com.green.vo.CommentVO;


@WebServlet("/CW")
public class CommentWrite extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int bidx = Integer.parseInt(request.getParameter("bidx"));
		String url = "BV?idx=" + bidx;
		
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		CommentVO cVo = new CommentVO();
		cVo.setBidx(bidx);
		cVo.setWriter(writer);
		cVo.setContent(content);
		
		CommentDAO dao = CommentDAO.getInstance();
		dao.insertComment(cVo);
		
		
//		request.getRequestDispatcher(url).forward(request, response);
		response.sendRedirect(url);
	}

}
