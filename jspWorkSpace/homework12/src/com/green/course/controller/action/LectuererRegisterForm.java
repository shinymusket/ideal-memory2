package com.green.course.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.course.dao.LectuererDAO;

public class LectuererRegisterForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "course/lectuererRegister.jsp";
		
		LectuererDAO dao = LectuererDAO.getInstance();
//		int seqNum = dao.selectLectuererSequence();
		int seqNum = dao.selectCountLectuerer() + 1;
		
		request.setAttribute("seqNum", seqNum);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
