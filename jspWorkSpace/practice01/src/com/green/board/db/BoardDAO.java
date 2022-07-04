package com.green.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.green.member.db.DBManager;

public class BoardDAO {
	private BoardDAO() {}
	private static BoardDAO dao = new BoardDAO();
	public static BoardDAO getInstance() {
		return dao;
	}
	
	// 해당 section의 리스트 갯수
	public int getCount(String section) {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM ex_board WHERE section=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, section);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return count;
	}
	
	// 해당 section 검색 레코드 수
	public int getfCount(Map<String, Object> fMap) {
		int fCount = 0;
		String sql = "SELECT COUNT(*) FROM ex_board WHERE ?=?, section=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			String sel = (String) fMap.get("sel");
			String find = (String) fMap.get("find");
			String section = (String) fMap.get("section");
//			if (selStr.equals("id")) {
//				psmt.setString(1, "id");
//			} else if (selStr.equals("board_subject")) {
//				psmt.setString(1, "board_subject");
//			}
			
			psmt.setString(1, sel);
			psmt.setString(2, find);
			psmt.setString(3, section);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return fCount;
	}

	// 해당 section 페이징 처리
	public List<BoardDTO> getList(Map<String, Object> map) {
		
		return null;
	}
	
}
