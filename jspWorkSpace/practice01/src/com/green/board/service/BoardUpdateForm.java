package com.green.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.board.db.BoardDAO;
import com.green.board.db.BoardDTO;
import com.green.member.service.Action;
import com.green.member.service.ActionForward;

public class BoardUpdateForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO manager = BoardDAO.getInstance();
		BoardDTO content = manager.boardContent(Integer.parseInt(request.getParameter("no")));
		
		request.setAttribute("content", content);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/boardUpdateForm.jsp");
		
		return forward;
	}

}
