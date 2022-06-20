package com.green.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.board.db.DBManager;
import com.green.board.vo.BoardVO;

public class BoardDAO {
	private BoardDAO() {}
	private static BoardDAO dao = new BoardDAO();
	public static BoardDAO getInstance() {
		return dao;
	}
	
	public List<BoardVO> selectAllBoards() {
		String sql = "SELECT * FROM boardTbl ORDER BY num DESC";
		
		List<BoardVO> List = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadCount(rs.getInt("readcount"));
				bVo.setWriteDate(rs.getTimestamp("writedate"));
				
				List.add(bVo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
			
		return List;
	}

	public void insertBoard(BoardVO bVo) {
		String sql = "INSERT INTO boardTbl(num, name, email, pass, title, content)" + 
				"VALUES(BOARD_SEQ.nextval, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bVo.getName());
			psmt.setString(2, bVo.getEmail());
			psmt.setString(3, bVo.getPass());
			psmt.setString(4, bVo.getTitle());
			psmt.setString(5, bVo.getContent());
			
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
	}

	public BoardVO selectBoardByNum(int num) {
		BoardVO bVo = null;
		
		String sql = "SELECT * FROM boardTbl WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				bVo =  new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadCount(rs.getInt("readcount"));
				bVo.setWriteDate(rs.getTimestamp("writedate"));
			}
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		return bVo;
	}

	public void updateReadCount(int num) { // 조회수 증가 메서드
		String sql = "UPDATE boardTbl SET readCount = readCount+1 WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			
			psmt.executeUpdate();
			
		} catch(Exception e ) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}

	public boolean checkPassword(int num, String pass) {
		BoardVO bVo = selectBoardByNum(num);
		
		if (bVo.getPass().equals(pass)) {
			return true;
		} else {
			return false;
		}
	}

	public void updateBoard(BoardVO bVo) {
		String sql = "UPDATE boardTbl SET name=?, pass=?, email=?, title=?, content=? WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bVo.getName());
			psmt.setString(2, bVo.getPass());
			psmt.setString(3, bVo.getEmail());
			psmt.setString(4, bVo.getTitle());
			psmt.setString(5, bVo.getContent());
			psmt.setInt(6, bVo.getNum());
			
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
		
	}

	public void deleteBoardByNum(int num) {
		String sql = "DELETE FROM boardTbl WHERE num=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
		
			psmt.executeUpdate();
			
		} catch(Exception e) {
			 
		} finally {
			DBManager.close(conn, psmt);
		}
		
	}
}
