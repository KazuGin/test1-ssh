package com.school.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.school.dao.BaseDao;
import com.school.dao.StudentDao;
import com.school.entity.Student;

public class StudentDaoImpl extends BaseDao implements StudentDao{

	@Override
	public int addStudent(Student stu) {
		// TODO Auto-generated method stub
		String sql = "insert into student(studentname,sex,phone,gradeid,birthday) values(?,?,?,?,?)";
		Object [] param = {stu.getStudentName(),stu.getSex(),stu.getPhone(),stu.getGradeId(),stu.getBirthday()};
		return this.exceuteUpdate(sql, param);
	}

	@Override
	public int updateStudent(Student stu) {
		// TODO Auto-generated method stub
		String sql = "update student set studentname =?,sex=?,phone=?,gradeid=?,birthday=? where id=?";
		Object [] param = {stu.getStudentName(),stu.getSex(),stu.getPhone(),stu.getGradeId(),stu.getBirthday(),stu.getId()};
		return this.exceuteUpdate(sql, param);
	}

	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from student where id=?";
		Object [] param = {id};
		return this.exceuteUpdate(sql, param);
	}

	@Override
	public List<Student> findStudentList() {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con =  this.getConnection();
			String sql = "select * from student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Student stu = new Student();
				stu.setBirthday(rs.getDate("birthday"));
				stu.setGradeId(rs.getInt("gradeId"));
				stu.setId(rs.getInt("id"));
				stu.setPhone(rs.getString("phone"));
				stu.setSex(rs.getString("sex"));
				stu.setStudentName(rs.getString("studentName"));
				list.add(stu);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return list;
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con =  this.getConnection();
			String sql = "select count(1) from student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(con, ps, rs);
		}
		return 0;
	}

}
