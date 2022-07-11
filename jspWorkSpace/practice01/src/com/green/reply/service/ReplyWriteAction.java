package com.green.reply.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.member.service.Action;
import com.green.member.service.ActionForward;
import com.green.reply.db.ReplyDAO;
import com.green.reply.db.ReplyDTO;

public class ReplyWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		// 넘어온 데이터를 dto에 저장
		ReplyDTO dto = new ReplyDTO();
		dto.setBoard_no(Integer.parseInt(request.getParameter("no")));
		dto.setId(request.getParameter("id"));
		dto.setReply_content(request.getParameter("reply_content"));
		
		// db 저장을 위한 dao에 데이터 전달
		ReplyDAO manager = ReplyDAO.getInstance();
		manager.insertReply(dto);
		
		return null;
	}

}
