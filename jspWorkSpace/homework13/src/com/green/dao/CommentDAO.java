package com.green.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.green.vo.CommentVO;

import DBPKG.DBManager;

public class CommentDAO {
		
		private SqlSession session; 
	
		private CommentDAO() {};
		
		private static CommentDAO dao = new CommentDAO();
		
		public static CommentDAO getInstance() {
			return dao;
		}
		
		// myBatis
		private SqlSession getSession() {
			Reader reader = null;
			try {
				reader = Resources.getResourceAsReader("./SqlMapConfig.xml");
				SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
				session = sf.openSession();
				
			} catch(IOException e) {
				System.out.println("getSession 에러 : " + e);
				e.printStackTrace();
			}
			return session;
		}
		
		// 댓글 조회
		public List<CommentVO> selectAllCommnet(int bidx) {
			List<CommentVO> list = new ArrayList<>();
			
			try {
				session = getSession();
				list = session.selectList("comment.select_comment", bidx);
				
			} catch(Exception e) {
				System.out.println("selectAllCommnet 에러 : " + e);
				e.printStackTrace();
			}
 			
			
			return list;
		}	
		
		
//		public List<CommentVO> selectAllCommnet(int bidx) {
//			List<CommentVO> list = new ArrayList<>();
//			String sql = "SELECT * FROM comment_tbl WHERE bidx=?";
//			
//			Connection conn = null;
//			PreparedStatement psmt = null;
//			ResultSet rs = null;
//			
//			try {
//				conn = DBManager.getConnection();
//				psmt = conn.prepareStatement(sql);
//				
//				psmt.setInt(1, bidx);
//				rs = psmt.executeQuery();
//				
//				while(rs.next()) {
//					CommentVO cVo = new CommentVO();
//					cVo.setIdx(rs.getInt(1));
//					cVo.setBidx(rs.getInt(2));
//					cVo.setWriter(rs.getString(3));
//					cVo.setContent(rs.getString(4));
//					
//					Timestamp regdate = rs.getTimestamp(5);
//					SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd kk:mm:ss");
//					String newRegdate = sdf.format(regdate); 
//					
//					cVo.setRegdate(newRegdate);
//					list.add(cVo);
//				}
//				
//				
//				
//			} catch(Exception e) {
//				e.printStackTrace();
//			} finally {
//				DBManager.close(conn, psmt, rs);
//			}
//
//			return list;
//			
//		}

		
		// 댓글 삭제
		public void deleteCommentByIdx(int idx) {
			try {
				session = getSession();
				session.delete("comment.delete_comment", idx);
				session.commit();

			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("deleteCommentByIdx 에러 : " + e);
			}
		}
		
//		public void deleteCommentByIdx(int idx) {
//			String sql = "DELETE FROM comment_tbl WHERE idx=?";
//			
//			Connection conn = null;
//			PreparedStatement psmt = null;
//			
//			try {
//				conn = DBManager.getConnection();
//				psmt = conn.prepareStatement(sql);
//				
//				psmt.setInt(1, idx);
//				
//				psmt.executeUpdate();
//				
//			} catch(Exception e) {
//				e.printStackTrace();
//			} finally {
//				DBManager.close(conn, psmt);
//			}
//			
//			
//		}
		
		// 댓글 작성
		public void insertComment(CommentVO cVo) {
			try {
				session = getSession();
				session.insert("comment.insert_comment", cVo);
				session.commit();

			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("insertComment 에러 : " + e);
			}
		}
		
		
		
		
//		public void insertComment(CommentVO cVo) {
//			String sql = "INSERT INTO comment_tbl VALUES(seq_comment_tbl.nextval, ?, ?, ?, sysdate)";
//			
//			Connection conn = null;
//			PreparedStatement psmt = null;
//			
//			try {
//				conn = DBManager.getConnection();
//				psmt = conn.prepareStatement(sql);
//				psmt.setInt(1, cVo.getBidx());
//				psmt.setString(2, cVo.getWriter());
//				psmt.setString(3, cVo.getContent());
//				
//				psmt.executeUpdate();
//				
//			} catch(Exception e) {
//				e.printStackTrace();
//			} finally {
//				DBManager.close(conn, psmt);
//			}
//			
//		}
		
	}
