package com.green.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.green.sns.dao.SnsDAO;
import com.green.sns.vo.SnsVO;


@WebServlet("/snsAjaxServlet2")
public class snsAjaxServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		SnsDAO dao = SnsDAO.getInstance();
		List<SnsVO> list = dao.selectAllText();
		
		/*Gson gson = new Gson();
		
		PrintWriter out = response.getWriter();
		
		for (int i = 0; i < list.size(); i++) {
			String listJson = gson.toJson(list.get(i));
			out.print(listJson);*/

		
		response.setContentType("application/json;charset=utf-8");
		new Gson().toJson(list, response.getWriter());
		
		
	}

}


