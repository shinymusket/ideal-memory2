package com.green.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.course.db.DBManager;
import com.green.course.vo.LectuererVO;

public class LectuererDAO {
	private LectuererDAO() {}
	private static LectuererDAO dao = new LectuererDAO();
	
	public static LectuererDAO getInstance() {
		return dao;
	}
	
	public List<LectuererVO> selectAllLectuerer() { // 강사 전체 리스트 가져오기
		String sql = "SELECT * FROM lecturer_tbl ORDER BY idx DESC";
		List<LectuererVO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				LectuererVO lVo = new LectuererVO();
				lVo.setIdx(rs.getInt(1));
				lVo.setName(rs.getString(2));
				lVo.setMajor(rs.getString(3));
				lVo.setField(rs.getString(4));
				list.add(lVo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}

	public int selectCountLectuerer() { // 강사 전체수 조회
		int count = 0;
		String sql = "SELECT COUNT(*) FROM lecturer_tbl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return count;
	}
	
	public int selectLectuererSequence() { // 다음 시퀀스 번호 가져오기
		int seqNum = 0;
		String sql = "SELECT lecturer_seq.currval FROM dual";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				seqNum = rs.getInt(1);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return seqNum;
	}

	public void insertLectuerer(LectuererVO lVo) { // 강사 등록
		String sql = "INSERT INTO lecturer_tbl VALUES (LECTURER_SEQ.nextval, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, lVo.getName());
			psmt.setString(2, lVo.getMajor());
			psmt.setString(3, lVo.getField());
			
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}

	public LectuererVO selectLectuererByidx(int idx) { // 번호로 강사 정보 가져오기
		String sql = "SELECT * FROM lecturer_tbl WHERE idx=?";
		LectuererVO lVo = new LectuererVO();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, idx);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				lVo.setIdx(idx);
				lVo.setName(rs.getString(2));
				lVo.setMajor(rs.getString(3));
				lVo.setField(rs.getString(4));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return lVo;
	}
	
	public List<String> selectSubjectByName(String name) { // 강사 이름으로 담당 과목 가져오기
		List<String> list = new ArrayList<>();
		String sql = "SELECT c.name " + 
				" FROM course_tbl c INNER JOIN lecturer_tbl l " + 
				" ON c.lecturer = l.idx " + 
				" WHERE l.name=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, name);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		return list;
	}

	public void updateLectuerer(LectuererVO lVo) { // 강사 정보 수정하기
		String sql = "UPDATE lecturer_tbl SET name=?, major=?, field=? WHERE idx=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, lVo.getName());
			psmt.setString(2, lVo.getMajor());
			psmt.setString(3, lVo.getField());
			psmt.setInt(4, lVo.getIdx());
			
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
	}
	
	
	
	
}
