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
	
	// 게시판 글 작성
	public int boardWrite(BoardDTO dto) {
		int result = 0;
		try {
			session = getSession();
			result = session.insert("board.board_write", dto);
			session.commit();
			System.out.println("result : " + result);
		} catch(Exception e) {
			System.out.println("boardWrite 에러 : " + e);
			e.printStackTrace();
		}

		return result;
		
	}
	
	// 조회수 업데이트
	public void readcountUpdate(int no) {
		try {
			session = getSession();
			session.update("board.readcount_update", no);
			session.commit();
			
		} catch (Exception e) {
			System.out.println("readcountUpdate 에러 : " + e);
			e.printStackTrace();
		}
		
	}
	
	// 게시판 상세페이지
	public BoardDTO boardContent(int no) {
		BoardDTO dto = null;
		try {
			session = getSession();
			dto = session.selectOne("board.board_content", no);
			
		} catch (Exception e) {
			System.out.println("boardContent 에러 : " + e );
			e.printStackTrace();
		}
		
		return dto;
	}
	
	// 게시글 추천여부 검사
	public int recCheck(Map<String, Object> m) {
		int result = 0;
		try {
			session = getSession();
			result = session.selectOne("board.rec_check", m);
			
		} catch(Exception e) {
			System.out.println("recCheck 에러 : " + e);
			e.printStackTrace();
		}

		return result;
	}
	
	// 게시글 추천
	public void recUpdate(Map<String, Object> m) {
		try {
			session = getSession();
			session.insert("board.rec_update", m);
			session.commit();
			
		} catch(Exception e) {
			System.out.println("recUpdate 에러 " + e);
			e.printStackTrace();
		}
	}
	
	// 게시글 추천 제거
	public void recDelete(Map<String, Object> m) {
		try {
			session = getSession();
			session.insert("board.rec_delete", m);
			session.commit();
			
		} catch(Exception e) {
			System.out.println("recDelete 에러 " + e);
			e.printStackTrace();
		}
	}
	
	// 게시글 추천수
	public int recCount(int no) {
		int count = 0;
		try {
			session = getSession();
			count = session.selectOne("board.rec_count", no);
			
		} catch(Exception e) {
			System.out.println("recCount 에러 : " + e);
			e.printStackTrace();
		}
			
		return count;
	}
	
	// 게시판 글 수정
	public void boardUpdate(Map<String, Object> m) {
		try {
			session = getSession();
			session.update("board.board_update", m);
			session.commit();
		} catch(Exception e) {
			System.out.println("boardUpdate 에러 : " + e);
			e.printStackTrace();
		}
		
	}
	
}
