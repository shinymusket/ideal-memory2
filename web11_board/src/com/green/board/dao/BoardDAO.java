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
		
		List<BoardVO> list = new ArrayList<>();
		
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
				
				list.add(bVo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
			
		return list;
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
	
	// 페이지, 섹션 정보를 통해서 해당 페이지 게시글 읽어오기
	public List<BoardVO> selectTargetBoards(int section, int page) {
		List<BoardVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM " + 
				" (SELECT ROWNUM as nick, num, name, email, pass, title, content, readcount, writedate FROM " + 
				" (SELECT * FROM boardTbl ORDER BY num DESC)) " + 
				" WHERE nick BETWEEN (?-1)*100+(?-1)*10+1 AND (?-1)*100+?*10 ";
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, section);
			psmt.setInt(2, page);
			psmt.setInt(3, section);
			psmt.setInt(4, page);
			
			rs = psmt.executeQuery();
			
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
				
				list.add(bVo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		

		return list;
	}
	
	// 전체 게시글의 개수를 알아오는 쿼리
	public int selectAllBoardNumber() {
		int cntAll = 0;
		
		String sql="SELECT COUNT(*) FROM boardTbl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				cntAll = rs.getInt(1);
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		
		return cntAll;
	}
	
	
}
