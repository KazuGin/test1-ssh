package com.school.dao;

import com.school.entity.Teacher;

public interface TeacherDao {

	/**
	 * ��¼
	 * @param username	�û���
	 * @param password	����
	 * @return
	 */
	Teacher login(String username,String password);
}
