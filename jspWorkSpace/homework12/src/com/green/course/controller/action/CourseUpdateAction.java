package com.green.course.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.dao.CourseDAO;
import com.green.course.vo.CourseVO;

public class CourseUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "CS?command=course_list";
		request.setCharacterEncoding("UTF-8");
		
		CourseDAO dao = CourseDAO.getInstance();
		CourseVO cVo = new CourseVO();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String lecturer = request.getParameter("lectuer");
		int credit = Integer.parseInt(request.getParameter("credit"));
		int weekNum = Integer.parseInt(request.getParameter("week"));
		String week = dao.selectWeekNameByNum(weekNum);
		int startHour = Integer.parseInt(request.getParameter("startHour"));
		int endHour =  Integer.parseInt(request.getParameter("endHour"));
		
		cVo.setId(id);
		cVo.setName(name);
		cVo.setLecturer(lecturer);
		cVo.setCredit(credit);
		cVo.setWeek(week);
		cVo.setStartHour(startHour);
		cVo.setEndHour(endHour);
		
		dao.updateCourse(cVo);
		
		
		
		response.sendRedirect(url);
	}	

}
