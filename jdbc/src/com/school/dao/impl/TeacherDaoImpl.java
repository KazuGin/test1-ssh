package com.school.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.school.dao.BaseDao;
import com.school.dao.TeacherDao;
import com.school.entity.Teacher;

public class TeacherDaoImpl extends BaseDao implements TeacherDao{

	@Override
	public Teacher login(String username, String password) {
		// TODO Auto-generated method stub
		Teacher teacher = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.获取连接
			con = this.getConnection();
			//2.定义SQL语句
			String sql = "select * from teacher where username = ? and password=?";
			//3.预编译SQL
			ps = con.prepareStatement(sql);
			//赋值
			ps.setString(1, username);
			ps.setString(2, password);
			//4.执行SQL，返回结果集
			rs = ps.executeQuery();
			//5.循环
			while(rs.next()){
				//6.创建对象
				teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setUsername(rs.getString("username"));
				teacher.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//7.关闭资源
			this.closeAll(con, ps, rs);
		}
		//8.返回对象
		return teacher;
	}

}
