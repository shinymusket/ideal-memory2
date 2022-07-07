package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.CommentDAO;


@WebServlet("/CD")
public class CommentDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bidx = Integer.parseInt(request.getParameter("bidx"));
		String url = "BV?idx=" + bidx;
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		CommentDAO dao = CommentDAO.getInstance();
		dao.deleteCommentByIdx(idx);
		
//		request.getRequestDispatcher(url).forward(request, response);
		
		response.sendRedirect(url);
	}

}
