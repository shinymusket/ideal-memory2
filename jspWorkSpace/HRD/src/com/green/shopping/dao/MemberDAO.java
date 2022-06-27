package com.green.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.green.shopping.vo.MemberVO;
import com.green.shopping.vo.PriceVO;

import DBPKG.DBManager;

public class MemberDAO {
	
	private MemberDAO() {}
	
	private static MemberDAO dao = new MemberDAO();
	
	public static MemberDAO getInstatnce() {
		return dao;
	}
	
	// 회원등록을 위한 번호(마지막 번호+1) 가져오기
	
	public int getNewCustNum() {
		int num = 0;
		String sql = "SELECT MAX(custno) FROM member_tbl_02";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				num = rs.getInt(1) + 1;
			}
			
			
		} catch(Exception e) {
			
		} finally {
			DBManager.close(conn, stmt, rs);
		}
	
		
		return num;
	}

	public void insertMember(MemberVO mVo) { // 회원 가입
		String sql = "INSERT INTO member_tbl_02 VALUES(MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mVo.getCustname());
			psmt.setString(2, mVo.getPhone());
			psmt.setString(3, mVo.getAddress());
			
			 
			
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date date = mVo.getJoindate();
			String formatedDate = dateFormat.format(date);	
			
			psmt.setString(4, formatedDate);
			psmt.setString(5, mVo.getGrade());
			psmt.setString(6, mVo.getCity());

			psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
		
	}

	public List<MemberVO> selectAllMember() { // 회원 목록 가져오기
		List<MemberVO> list = new ArrayList<>();
		String sql = "SELECT * FROM member_tbl_02";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MemberVO mVo = new MemberVO();
				
				mVo.setCustno(rs.getInt(1));
				mVo.setCustname(rs.getString(2));
				mVo.setPhone(rs.getString(3));
				mVo.setAddress(rs.getString(4));
				mVo.setJoindate(rs.getDate(5));
				mVo.setGrade(selectMemberGrade(rs.getString(6)));
				mVo.setCity(rs.getString(7));
				
				list.add(mVo);
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	public String selectMemberGrade(String gradeCode) { // 등급 코드로 등급 가져오기
		String grade = null;
		
		if(gradeCode.equals("A")) {
			grade = "VIP";
		} else if (gradeCode.equals("B")) {
			grade = "일반";
		} else if (gradeCode.equals("C")) {
			grade = "직원";
		}
		
		return grade;
	}
	
	public List<PriceVO> selectMemberPrice() { // 회원별 매출 목록 가져오기
		List<PriceVO> list = new ArrayList<>();
		String sql = "SELECT m1.custno, custname, grade, SUM(m2.price) " + 
				" FROM member_tbl_02 m1 INNER JOIN  money_tbl_02 m2 " + 
				" ON m1.custno = m2.custno " + 
				" GROUP BY m1.custno, custname, grade " + 
				" ORDER BY SUM(m2.price) DESC";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				PriceVO pVo = new PriceVO();
				
				pVo.setCustno(rs.getInt(1));
				pVo.setCustname(rs.getString(2));
				pVo.setGrade(selectMemberGrade(rs.getString(3)));
				pVo.setSumPrice(rs.getInt(4));
				
				list.add(pVo);
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		
		return list;
	}
	
	public MemberVO selectMemberInfoByCustno(int custno) { // 회원 번호로 회원 정보 가져오기
		MemberVO mVo = new MemberVO();
		String sql = "SELECT * FROM member_tbl_02 WHERE custno=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, custno);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				mVo.setCustno(rs.getInt(1));
				mVo.setCustname(rs.getString(2));
				mVo.setPhone(rs.getString(3));
				mVo.setAddress(rs.getString(4));
				mVo.setJoindate(rs.getDate(5));
				mVo.setGrade(rs.getString(6));
				mVo.setCity(rs.getString(7));
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace(); 
		
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		
		
		return mVo;
		
	}

	public void updateMemberInfo(MemberVO mVo) { // 회원 정보 수정
		String sql = "UPDATE member_tbl_02 SET custname=?, phone=?, address=?, joindate=?, grade=?, city=?  WHERE custno=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mVo.getCustname());
			psmt.setString(2, mVo.getPhone());
			psmt.setString(3, mVo.getAddress());
			
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date date = mVo.getJoindate();
			String formatedDate = dateFormat.format(date);
			psmt.setString(4, formatedDate);
			psmt.setString(5, mVo.getGrade());
			psmt.setString(6, mVo.getCity());
			psmt.setInt(7, mVo.getCustno());
			
			psmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
		
	}
}
