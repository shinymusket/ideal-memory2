package com.green.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	
	private MemberDAO() {}
	private static MemberDAO dao = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return dao;
	}

	public int idCheck(String id) { // 중복 아이디 체크
		int result = 0;
		String sql = "SELECT COUNT(*) FROM ex_memberinfo WHERE id=?";
		
		Connection conn =  null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
	
		return result;
	}

	public void memberJoin(MemberDTO member) { // 회원 가입
		String sql = "INSERT INTO ex_memberinfo(id, passwd, name, email, nickname) VALUES(?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPasswd());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getEmail());
			psmt.setString(5, member.getNickname());
			
			int result = psmt.executeUpdate();
//			System.out.println(result + "명의 회원정보가 등록되었습니다.");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
		
	}

	public String pwCheck(String id) { // 로그인시 비밀번호 확인 - 아이디로 비밀번호 가져오기
		String passwd = null;
		String sql = "SELECT passwd FROM ex_memberinfo WHERE id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				passwd = rs.getString(1);
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
	
		return passwd;
	}

	public MemberDTO getMember(String id) { // 로그인 성공시 - 아이디로 회원 정보 가져오기
		MemberDTO member = new MemberDTO();
		String sql = "SELECT * FROM ex_memberinfo WHERE id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				member.setId(rs.getString(1));
				member.setPasswd(rs.getString(2));
				member.setName(rs.getString(3));
				member.setEmail(rs.getString(4));
				member.setNickname(rs.getString(5));
				member.setReg_date(rs.getDate(6));
			}
		
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		return member;
	}

	public int updateMember(MemberDTO member) { // 회원 정보 수정
		int result = 0;
		String sql = "UPDATE ex_memberinfo SET name=?, nickname=?, email=? WHERE id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getNickname());
			psmt.setString(3, member.getEmail());
			psmt.setString(4, member.getId());

			result = psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
	
		return result;
	}
	
	public int updateMemberPwd(MemberDTO member) { // 비밀번호 변경
		int result = 0;
		String sql = "UPDATE ex_memberinfo SET passwd=? WHERE id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, member.getPasswd());
			psmt.setString(2, member.getId());
			
			result = psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
		return result;
	}

	public int withdrawalMember(String id) { // 회원 탈퇴
		int result = 0;
		String sql = "DELETE ex_memberinfo WHERE id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnetion();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			result = psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
		return result;
	}
}
