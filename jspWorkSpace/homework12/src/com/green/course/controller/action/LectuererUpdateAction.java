package com.green.course.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.dao.LectuererDAO;
import com.green.course.vo.LectuererVO;

public class LectuererUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "CS?command=lectuerer_list";
		
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String major = request.getParameter("major");
		String field = request.getParameter("field");
		
		LectuererVO lVo = new LectuererVO();
		lVo.setIdx(idx);
		lVo.setName(name);
		lVo.setMajor(major);
		lVo.setField(field);
		LectuererDAO dao = LectuererDAO.getInstance();
		
		dao.updateLectuerer(lVo);
		
		response.sendRedirect(url);
	}

}
