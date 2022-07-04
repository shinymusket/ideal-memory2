package com.green.service;
import static common.SqlSessionTemplate.getSession;

import org.apache.ibatis.session.SqlSession;

import com.green.dao.MyBatisDao;


public class MyBatisService {

	private MyBatisDao dao = new MyBatisDao();
	
	public int insertStudent() {
		SqlSession session =  getSession();
		int result = dao.insertStudent(session);
		
		if (result > 0 ) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		return result;
	}
}
