package com.school.dao;

import com.school.entity.Teacher;

public interface TeacherDao {

	/**
	 * µÇÂ¼
	 * @param username	ÓÃ»§Ãû
	 * @param password	ÃÜÂë
	 * @return
	 */
	Teacher login(String username,String password);
}
