package com.green.course.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.controller.action.Action;
import com.green.course.dao.CourseDAO;
import com.green.course.vo.CourseVO;

public class CourseInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "course/courseInfo.jsp";
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		CourseDAO dao = CourseDAO.getInstance();
		CourseVO cVo =  dao.selectCouseById(id);
		
		request.setAttribute("course", cVo);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
