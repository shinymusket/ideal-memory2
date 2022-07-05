package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.board.service.BoardList;
import com.green.member.service.Action;
import com.green.member.service.ActionForward;
import com.green.member.service.LogOut;
import com.green.member.service.LoginAction;
import com.green.member.service.MemberJoin;
import com.green.member.service.MemberUpdate;
import com.green.member.service.MemberUpdateForm;
import com.green.member.service.PasswdChange;
import com.green.member.service.PasswdChangeForm;
import com.green.member.service.Withdrawal;


@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()); // substring 메서드로 command 추출
		
		Action action = null;
		ActionForward forward = null;
		
		
		// 홈페이지로 이동
		if (command.equals("/Index.do")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./index.jsp");
		}
		
		
		// 회원가입 폼
		else if (command.equals("/MemberJoinForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./member/memberJoinForm.jsp");
		}
		
		// 회원가입
		else if (command.equals("/MemberJoin.do")) {
			try {
				action = new MemberJoin();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 로그인 폼으로 이동
		else if (command.equals("/LoginForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./member/loginForm.jsp");
		}
		
		// 로그인
		else if (command.equals("/LoginAction.do")) {
			try {
				action = new LoginAction();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			} 
		}
		
		// 로그아웃
		else if (command.equals("/LogOut.do")) {
			try {
				action = new LogOut();
				forward = action.execute(request, response);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 정보수정폼 form
		else if (command.equals("/MemberUpdateForm.do")) {
			try {
				action = new MemberUpdateForm();
				forward = action.execute(request, response);
						
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 정보 수정
		else if (command.equals("/MemberUpdate.do")) {
			try {
				action = new MemberUpdate();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 비밀번호 변경 폼 
		else if (command.equals("/PasswdChangeForm.do")) {
			try {
				action = new PasswdChangeForm();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 비밀번호 변경
		else if (command.equals("/PasswdChange.do")) {
			try {
				action = new PasswdChange();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 회원탈퇴
		else if (command.equals("/Withdrawal.do")) { 
			try {
				action = new Withdrawal();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 게시판 목록
		else if (command.equals("/BoardList.do")) { 
			try {
				action = new BoardList();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		

		// 페이지 이동
		if (forward != null) {
			if (forward.isRedirect()) { // 리다이렉트 이동일 경우
				response.sendRedirect(forward.getPath());
			} else { // 포워드 이동일 경우
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
		
	}
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("get");
			doProcess(request, response);
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("post");
			doProcess(request, response);
		}

}
