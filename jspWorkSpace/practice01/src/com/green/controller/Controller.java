package com.green.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.board.service.BoardContent;
import com.green.board.service.BoardDelete;
import com.green.board.service.BoardList;
import com.green.board.service.BoardUpdate;
import com.green.board.service.BoardUpdateForm;
import com.green.board.service.BoardWrite;
import com.green.board.service.RecCount;
import com.green.board.service.RecUpdate;
import com.green.member.service.Action;
import com.green.member.service.ActionForward;
import com.green.member.service.LogOut;
import com.green.member.service.LoginAction;
import com.green.member.service.MemberJoin;
import com.green.member.service.MemberUpdate;
import com.green.member.service.MemberUpdateForm;
import com.green.member.service.NewLoginAction;
import com.green.member.service.PasswdChange;
import com.green.member.service.PasswdChangeForm;
import com.green.member.service.Withdrawal;
import com.green.reply.service.GetReply;
import com.green.reply.service.ReplyWriteAction;


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
		
		// 게시판 글작성 form
		else if (command.equals("/BoardWriteForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./board/boardWriteForm.jsp?section=" + request.getParameter("section"));
		}
		
		// 게시판 글작성
		else if (command.equals("/BoardWrite.do")) {
			try {
				action = new BoardWrite();
				forward = action.execute(request, response);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		// 게시판 상세 페이지
		else if (command.equals("/BoardContent.do")) {
			try {
				action = new BoardContent();
				forward = action.execute(request, response);
		
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 추천수 업데이트
		else if (command.equals("/RecUpdate.do")) {
			try {
				action = new RecUpdate();
				action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 추천수 검색
		else if (command.equals("/RecCount.do")) {
			try {
				action = new RecCount();
				action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 새창 로그인폼
		else if (command.equals("/NewLoginForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./member/newLoginForm.jsp");
		}
		
		// 새창 로그인
		else if (command.equals("/NewLoginAction.do")) {
			try {
				action = new NewLoginAction();
				action.execute(request, response);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 댓글 등록
		else if (command.equals("/ReplyWriteAction.do")) {
			try {
				action =  new ReplyWriteAction();
				action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		// 댓글 목록
		else if (command.equals("/GetReply.do")) {
			try {
				action =  new GetReply();
				action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 게시판 수정 폼
		else if (command.equals("/BoardUpdateForm.do")) {
			try {
				action = new BoardUpdateForm();
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 게시판 수정
		else if (command.equals("/BoardUpdate.do")) {
			try {
				action = new BoardUpdate();
				forward = action.execute(request, response);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 게시판 글 삭제
		else if (command.equals("/BoardDelete.do")) {
			try {
				action = new BoardDelete();
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
