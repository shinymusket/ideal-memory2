package com.green.course.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.dao.CourseDAO;
import com.green.course.vo.CourseVO;

public class CourseListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/course/courseList.jsp";
		CourseDAO dao = CourseDAO.getInstance();
		List<CourseVO> list = dao.selectAllCourses();
		int count = dao.selectAllCoursesCount();
//		System.out.println(list.size());
		
		request.setAttribute("courseList", list);
		request.setAttribute("count", count);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
