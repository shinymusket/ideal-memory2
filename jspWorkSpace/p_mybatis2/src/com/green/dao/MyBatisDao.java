package com.green.dao;

import org.apache.ibatis.session.SqlSession;

public class MyBatisDao {
	public int insertStudent(SqlSession session) {
		int result = session.insert("mybatis.insertStudent");
		return result;
	}
}
