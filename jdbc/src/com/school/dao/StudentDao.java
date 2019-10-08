package com.school.dao;

import java.util.List;

import com.school.entity.Student;

public interface StudentDao {

	int addStudent(Student stu);
	
	int updateStudent(Student stu);
	
	int deleteStudent(int id);
	
	List<Student> findStudentList();
	
	int getTotalCount();
}
