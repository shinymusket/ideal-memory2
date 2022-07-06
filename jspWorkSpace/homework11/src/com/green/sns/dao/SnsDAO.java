package com.green.sns.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.sns.db.DBManager;
import com.green.sns.vo.SnsVO;

public class SnsDAO {
	private SnsDAO(){}
	
	private static SnsDAO dao = new SnsDAO();
	
	public static SnsDAO getInstance() {
		return dao;
	}
	
	// 글 등록
	
	public int insertText(SnsVO sVo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "INSERT INTO snsTbl (num, title, content) VALUES(SNS_SEQ.nextval, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sVo.getTitle());
			psmt.setString(2, sVo.getContent());
			
			result = psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
		
		return result;
	}
	
	// 글 불러오기
	
	public List<SnsVO> selectAllText() {
		List<SnsVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM snsTbl";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				SnsVO sVo = new SnsVO();
				sVo.setNum(rs.getInt("num"));
				sVo.setTitle(rs.getString("title"));
				sVo.setContent(rs.getString("content"));
				sVo.setWriteDate(rs.getTimestamp("writeDate"));
				list.add(sVo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
		
	}
	
}
