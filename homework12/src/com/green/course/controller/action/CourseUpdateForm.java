package com.green.course.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.dao.CourseDAO;
import com.green.course.vo.CourseVO;

public class CourseUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "course/courseUpdate.jsp";
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		CourseDAO dao = CourseDAO.getInstance();
		CourseVO cVo = dao.selectCouseById(id);
		List<String> lectuerList = dao.selectAllLecturer();
		
		request.setAttribute("course", cVo);
		request.setAttribute("lectuerList", lectuerList);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
