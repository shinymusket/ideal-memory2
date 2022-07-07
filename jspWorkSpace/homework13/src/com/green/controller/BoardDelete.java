package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;


@WebServlet("/BD")
public class BoardDelete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/homework13/BL";
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoardByIdx(idx);
		
		response.sendRedirect(url);	
	}

}
