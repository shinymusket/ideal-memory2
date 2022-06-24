package com.green.shopping.controller.action;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.shopping.dao.MemberDAO;

public class MemberRegisterForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shopping/memberRegister.jsp";
		
		MemberDAO dao = MemberDAO.getInstatnce();   
		
		int newCustno = dao.getNewCustNum();
		LocalDate date = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formatedNow = date.format(formatter);		
		
		
//		System.out.println(newCustno);
		
		request.setAttribute("custno", newCustno);
		request.setAttribute("date", formatedNow);
		
		request.getRequestDispatcher(url).forward(request, response);
//		response.sendRedirect(url);

	}

}
