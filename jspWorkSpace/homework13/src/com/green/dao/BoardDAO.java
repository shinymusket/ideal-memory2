package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.green.vo.BoardVO;

import DBPKG.DBManager;

public class BoardDAO {
	
	private BoardDAO() {};
	
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return dao;
	}
	
	// 게시판 리스트 가져오기
	public List<BoardVO> selectBoardList() {
		List<BoardVO> list = new ArrayList<>();
		String sql = "SELECT idx, writer, subject, regdate FROM board_tbl ORDER BY regdate DESC";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setIdx(rs.getInt(1));
				bVo.setWriter(rs.getString(2));
				bVo.setSubject(rs.getString(3));
				
				Timestamp timeStamp = rs.getTimestamp(4);
				SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd kk:mm");
				String newTimestamp = sdf.format(timeStamp); 
				
				bVo.setRegdate(newTimestamp);
				
				list.add(bVo);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
		
	}

	
	// 게시물 조회하기

	public BoardVO selectBoardViewByIdx(int idx) {
		BoardVO bVo = new BoardVO();
		String sql = "SELECT * FROM board_tbl WHERE idx=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, idx);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				bVo.setIdx(rs.getInt(1));
				bVo.setWriter(rs.getString(2));
				bVo.setSubject(rs.getString(3));
				bVo.setContent(rs.getString(4));
				
				Timestamp regdate = rs.getTimestamp(5);
				SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd kk:mm:ss");
				String newRegdate = sdf.format(regdate); 
				bVo.setRegdate(newRegdate);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return bVo;
	}

	// 게시물 추가하기
	public void insertBoard(BoardVO bVo) {
		String sql = "INSERT INTO board_tbl VALUES(SEQ_BOARD_TBL.nextval, ?, ?, ?, sysdate)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
					
			psmt.setString(1, bVo.getWriter());
			psmt.setString(2, bVo.getSubject());
			psmt.setString(3, bVo.getContent());
			
			psmt.executeUpdate();
					
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
	}

	
	// 게시물 수정하기
	public void updateBoard(BoardVO bVo) {
		String sql = "UPDATE board_tbl SET writer=?, subject=?, content=? WHERE idx=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, bVo.getWriter());
			psmt.setString(2, bVo.getSubject());
			psmt.setString(3, bVo.getContent());
			psmt.setInt(4, bVo.getIdx());
			
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
		
	}

	// 게시물 삭제하기
	public void deleteBoardByIdx(int idx) {
		String sql = "DELETE board_tbl WHERE idx=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, idx);
			
			
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
		
	}
}
