package com.green.course.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.dao.CourseDAO;
import com.green.course.vo.CourseVO;

public class CourseRegisterAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "CS?command=course_list";
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String courseName = request.getParameter("courseName");
		String lecturer = request.getParameter("lectuer");
		int credit = Integer.parseInt(request.getParameter("credit"));
		int weekNum = Integer.parseInt(request.getParameter("week"));
		int startHour = Integer.parseInt(request.getParameter("startHour"));
		int endHour = Integer.parseInt(request.getParameter("endHour"));
		
		CourseDAO dao =CourseDAO.getInstance();
		CourseVO cVo = new CourseVO();
		
		cVo.setId(id);
		cVo.setName(courseName);
		cVo.setCredit(credit);
		cVo.setLecturer(lecturer);
		String week;
		
		switch(weekNum) {
			case 1:
				week = "월";
				break;
			case 2:
				week = "화";
				break;
			case 3:
				week = "수";
				break;
			case 4:
				week = "목";
				break;
			case 5:
				week = "금";
				break;
			case 6:
				week = "토";
				break;
			default:
				week = "";
		}
		
		cVo.setWeek(week);
		cVo.setStartHour(startHour);
		cVo.setEndHour(endHour);
		
		dao.insertCourse(cVo);
		response.sendRedirect(url);
	}

}
