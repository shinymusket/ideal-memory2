package com.green.course.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.controller.action.Action;
import com.green.course.dao.CourseDAO;

public class CourseRegisterForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "course/courseRegister.jsp";
		CourseDAO dao = CourseDAO.getInstance();
		List<String> list = dao.selectAllLecturer();
		
		request.setAttribute("lectuerList", list);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
