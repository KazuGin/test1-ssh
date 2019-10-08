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
			//1.��ȡ����
			con = this.getConnection();
			//2.����SQL���
			String sql = "select * from teacher where username = ? and password=?";
			//3.Ԥ����SQL
			ps = con.prepareStatement(sql);
			//��ֵ
			ps.setString(1, username);
			ps.setString(2, password);
			//4.ִ��SQL�����ؽ����
			rs = ps.executeQuery();
			//5.ѭ��
			while(rs.next()){
				//6.��������
				teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setUsername(rs.getString("username"));
				teacher.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//7.�ر���Դ
			this.closeAll(con, ps, rs);
		}
		//8.���ض���
		return teacher;
	}

}
