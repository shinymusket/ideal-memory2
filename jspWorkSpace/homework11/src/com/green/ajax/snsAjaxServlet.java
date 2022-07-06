package com.green.ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.green.sns.dao.SnsDAO;
import com.green.sns.vo.SnsVO;


@WebServlet("/snsAjaxServlet")
public class snsAjaxServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String textInfo = request.getParameter("textInfo");

		System.out.println(textInfo);
		
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(textInfo);
		
		String title = data.getAsJsonObject().get("title").getAsString();
		String content = data.getAsJsonObject().get("content").getAsString();
		
		SnsVO sVo = new SnsVO();
		
		sVo.setTitle(title);
		sVo.setContent(content);
		SnsDAO dao = SnsDAO.getInstance(); 
		int result = dao.insertText(sVo);
		
		response.getWriter().print(result);
		System.out.println("넘어온 제목 : " + title);
		System.out.println("넘어온 내용 : " + content);

	}

}
