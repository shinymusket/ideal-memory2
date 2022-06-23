package com.green.course.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.dao.LectuererDAO;
import com.green.course.vo.LectuererVO;

public class LectuererListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "course/lectuererList.jsp";
		LectuererVO lVo = new LectuererVO();
		LectuererDAO dao = LectuererDAO.getInstance();
		List<LectuererVO> list = dao.selectAllLectuerer();
		int count = dao.selectCountLectuerer();
		
		request.setAttribute("LectuererList", list);
		request.setAttribute("count", count);
		
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
