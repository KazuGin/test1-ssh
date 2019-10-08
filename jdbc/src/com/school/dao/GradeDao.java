package com.school.dao;

import java.util.List;

import com.school.entity.Grade;

public interface GradeDao {

	int addGrade(Grade grade);
	
	int updateGrade(Grade grade);
	
	int deleteGrade(int id);
	
	List<Grade> findGradeList();
}
