package com.green.course.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.dao.LectuererDAO;
import com.green.course.vo.LectuererVO;

public class LectuererInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "course/lectuererInfo.jsp";
		
		int idx = Integer.parseInt(request.getParameter("id"));
		
		LectuererDAO dao = LectuererDAO.getInstance();
		LectuererVO lVo = dao.selectLectuererByidx(idx);
		
		// System.out.println(lVo.getName());
		
		List<String> subject = dao.selectSubjectByName(lVo.getName());
		
		request.setAttribute("subject", subject);
		request.setAttribute("lectuerer", lVo);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
