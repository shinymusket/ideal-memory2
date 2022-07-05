package com.green.board.db;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
	private SqlSession session;
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		return instance;
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
	
	// 해당 section 리스트 갯수
	public int getCount(String section) {
		int count = 0;
		try {
			session = getSession();
			count = session.selectOne("board.board_count", section);
			 
		} catch (Exception e) {
			System.out.println("getCount 에러 : " + e);
			e.printStackTrace();
		}
	
		return count;
	}
	
	// 해당 section 검색 레코드 수
	public int getfCount(Map<String, Object> fMap) {
		int fCount = 0;
		try {
			session = getSession();
			fCount = session.selectOne("board.board_fCount", fMap);
			
		} catch(Exception e) {
			System.out.println("getfCount 에러 : " + e);
			e.printStackTrace();
		}

		return fCount;
	}
	
	// 해당 section 페이징 처리
	public List<BoardDTO> getList(Map<String, Object> map) {
		List<BoardDTO> list = null;
		try {
			session = getSession();
			list = session.selectList("board.board_list", map);
			
		} catch(Exception e) {
			System.out.println("getList 에러 : " + e);
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 해당 section 검색 페이징 처리
	public List<BoardDTO> getfList(Map<String, Object> map) {
		List<BoardDTO> list = null;
		try {
			session = getSession();
			list = session.selectList("board.board_flist", map);
		} catch(Exception e) {
			System.out.println("getfList 에러 : " + e);
			e.printStackTrace();
		}
	
		return list;
	}
	
}
