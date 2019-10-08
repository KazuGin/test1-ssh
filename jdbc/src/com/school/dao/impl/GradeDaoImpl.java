package com.school.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.school.dao.BaseDao;
import com.school.dao.GradeDao;
import com.school.entity.Grade;

public class GradeDaoImpl extends BaseDao implements GradeDao{

	@Override
	public int addGrade(Grade grade) {
		// TODO Auto-generated method stub
		String sql = "insert into grade(gradename) values(?)";
		Object [] param = {grade.getGradeName()};
		return this.exceuteUpdate(sql, param);
	}

	@Override
	public int updateGrade(Grade grade) {
		// TODO Auto-generated method stub
		String sql = "update grade set gradename = ? where id =?";
		Object [] param = {grade.getGradeName(),grade.getId()};
		return this.exceuteUpdate(sql, param);
	}

	@Override
	public int deleteGrade(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from grade where id =?";
		Object [] param = {id};
		return this.exceuteUpdate(sql, param);
	}

	@Override
	public List<Grade> findGradeList() {
		// TODO Auto-generated method stub
		List<Grade> list = new ArrayList<Grade>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con =  this.getConnection();
			String sql = "select * from grade";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Grade grade = new Grade();
				grade.setGradeName(rs.getString("gradeName"));
				grade.setId(rs.getInt("id"));
				list.add(grade);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return list;
	}

}
