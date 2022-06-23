package com.green.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.course.db.DBManager;
import com.green.course.vo.CourseVO;

public class CourseDAO {
	private CourseDAO() {}
	private static CourseDAO dao = new CourseDAO();
	public static CourseDAO getInstance() {
		return dao;
	}
	
	public List<CourseVO> selectAllCourses() { // 전체 교과목 가져오기(출력화면)
		String sql = "SELECT id, c.name, credit, l.name, DECODE(week, 1, '월',2, '화',3, '수',4, '목',5, '금',6, '토') AS week " + 
				" FROM course_tbl c INNER JOIN lecturer_tbl l " + 
				" ON c.lecturer = l.idx " + 
				" ORDER BY id DESC";
		
		List<CourseVO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CourseVO cVo = new CourseVO();
				cVo.setId(rs.getString(1));
				cVo.setName(rs.getString(2));
				cVo.setCredit(rs.getInt(3));
				cVo.setLecturer(rs.getString(4));
				cVo.setWeek(rs.getString(5));
				
				list.add(cVo);
			}	
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	public int selectAllCoursesCount() { // 전체 과목 수 조회
		int count = 0;
		String sql = "SELECT COUNT(*) FROM course_tbl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return count;
	}
	
	
	public List<String> selectAllLecturer() { // 전체 강사 이름 명단 가져오기
		List<String> list = new ArrayList<>();
		String sql = "SELECT name FROM lecturer_tbl";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString(1);
				list.add(name);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		
		
		return list;
	}
	
	public int selectLecturerNumByName(String lecturer) { // 이름으로 강사 번호 찾기
		int num = 0;
		
		String sql = "SELECT idx FROM lecturer_tbl WHERE name=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, lecturer);
			
			rs = psmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		return num;
	}
	
	public String selectLecturerNameByNum(int num) { // 번호로 강사 이름 찾기
		String name = null;
		
		String sql = "SELECT name FROM lecturer_tbl WHERE idx=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, num);
			
			rs = psmt.executeQuery();
			if (rs.next()) {
				name = rs.getString(1);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		return name;
		
	}
	
	
	
	public int selectWeekNumByName(String week) { // 요일 이름으로 번호찾기
		int num = 0;
		
		if (week.equals("월")) {
			num = 1;
		} else if (week.equals("화")) {
			num = 2;
		} else if (week.equals("수")) {
			num = 3;
		} else if (week.equals("목")) {
			num = 4;
		} else if (week.equals("금")) {
			num = 5;
		}else if (week.equals("토")) {
			num = 6;
		}
		
		return num;
	}
	
	public String selectWeekNameByNum(int num) { // 요일 번호로 이름찾기
		String name = "";
		
		if (num == 1) {
			name = "월";
		} else if (num == 2) {
			name = "화";
		} else if (num == 3) {
			name = "수";
		} else if (num == 4) {
			name = "목";
		} else if (num == 5) {
			name = "금";
		} else if (num == 6) {
			name = "토";
		}
		
		return name;
	}
	
	
	

	public void insertCourse(CourseVO cVo) { // 교과목 추가하기
		String sql = "INSERT INTO course_tbl VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, cVo.getId());
			psmt.setString(2, cVo.getName());
			psmt.setInt(3, cVo.getCredit());
			psmt.setInt(4, selectLecturerNumByName(cVo.getLecturer()));
			psmt.setInt(5, selectWeekNumByName(cVo.getWeek()));
			psmt.setInt(6, cVo.getStartHour());
			psmt.setInt(7, cVo.getEndHour());
			
			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
	}

	public CourseVO selectCouseById(String id) { // 아이디로 교과목 상세보기
		CourseVO cVo = new CourseVO();
		String sql = "SELECT * FROM course_tbl WHERE id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				cVo.setId(id);
				cVo.setName(rs.getString(2));
				cVo.setCredit(rs.getInt(3));
				cVo.setLecturer(selectLecturerNameByNum(rs.getInt(4)));
				cVo.setWeek(selectWeekNameByNum(rs.getInt(5)));
				cVo.setStartHour(rs.getInt(6));
				cVo.setEndHour(rs.getInt(7));
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		return cVo;
	}

	public void updateCourse(CourseVO cVo) { // 아이디로 교과목 수정하기
		String sql = "UPDATE course_tbl SET name=?, lecturer=?, credit=?, week=?, start_hour=?, end_hour=? WHERE id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cVo.getName());
			psmt.setInt(2, dao.selectLecturerNumByName(cVo.getLecturer()));
			psmt.setInt(3, cVo.getCredit());
			psmt.setInt(4, dao.selectWeekNumByName(cVo.getWeek()));
			psmt.setInt(5, cVo.getStartHour());
			psmt.setInt(6, cVo.getEndHour());
			psmt.setString(7, cVo.getId());
			
			psmt.executeUpdate();
		
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
		
	}

	public void deleteCourseById(String id) {
		String sql = "DELETE FROM course_tbl WHERE id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			psmt.executeUpdate();
			
		} catch(Exception e ) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}
}
