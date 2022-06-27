package com.green.shopping.controller.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.shopping.dao.MemberDAO;
import com.green.shopping.vo.MemberVO;

public class MemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "SS?command=member_select";
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String dateStr = request.getParameter("joindate");

		
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd"); 
		 Date date = null;; 
		 try 
		 { date = formatter.parse(dateStr); } 
		 catch (ParseException e) 
		 {	e.printStackTrace(); }
		 

		String grade = request.getParameter("grade");
		String city = request.getParameter("city");

		MemberVO mVo = new MemberVO();
		MemberDAO dao = MemberDAO.getInstatnce();

		mVo.setCustno(custno);
		mVo.setCustname(custname);
		mVo.setPhone(phone);
		mVo.setAddress(address);
		mVo.setJoindate(date);
		mVo.setGrade(grade);
		mVo.setCity(city);
		dao.updateMemberInfo(mVo);

		response.sendRedirect(url);
	}

}
