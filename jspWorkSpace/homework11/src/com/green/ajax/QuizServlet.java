package com.green.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.green.sns.vo.Quiz_Vo;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String getInfo = request.getParameter("Info");
				
		JsonParser parser = new JsonParser();
		JsonElement data = parser.parse(getInfo);
		
		Quiz_Vo Info = new Quiz_Vo();
		
		Info.setNum(Integer.parseInt(data.getAsJsonObject().get("num").getAsString()));
		Info.setTitle(data.getAsJsonObject().get("title").getAsString());
		Info.setContent(data.getAsJsonObject().get("content").getAsString());
		Info.setDate(data.getAsJsonObject().get("date").getAsString());
		
		Gson gson = new Gson();
		
		String InfoJson = gson.toJson(Info);
		PrintWriter out = response.getWriter();
		out.print(InfoJson);
	}
}