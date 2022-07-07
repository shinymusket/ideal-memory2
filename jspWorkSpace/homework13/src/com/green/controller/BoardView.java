package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.BoardDAO;
import com.green.dao.CommentDAO;
import com.green.vo.BoardVO;
import com.green.vo.CommentVO;


@WebServlet("/BV")
public class BoardView extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/boardView.jsp";
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO bVo = dao.selectBoardViewByIdx(idx);
		
		int bidx = bVo.getIdx();
		
		CommentDAO cDao = CommentDAO.getInstance();
		List<CommentVO> list = cDao.selectAllCommnet(bidx);
		
		request.setAttribute("board", bVo);
		request.setAttribute("commentList", list);
		
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
