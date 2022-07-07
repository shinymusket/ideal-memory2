package com.green.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.board.db.BoardDAO;
import com.green.board.db.BoardDTO;
import com.green.member.service.Action;
import com.green.member.service.ActionForward;

public class BoardWrite implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("BoardWrite");
		
		// 폼에서 넘어온 데이터를 받음
		String section = request.getParameter("section");
		String id = request.getParameter("id");
		String board_subject = request.getParameter("board_subject");
		String board_content = request.getParameter("board_content");
		String ip = request.getRemoteAddr();
		
		// DTO 객체에 데이터 저장
		BoardDTO dto = new BoardDTO();
		dto.setSection(section);
		dto.setId(id);
		dto.setBoard_subject(board_subject);
		dto.setBoard_content(board_content);
		dto.setIp(ip);
		
		// DAO 객체 생성 및 db 연동을 위한 메서드 호출
		BoardDAO manager = BoardDAO.getInstance();
		manager.boardWrite(dto);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("/practice01/BoardList.do?section=" + section);
		
		return forward;
	}

}
