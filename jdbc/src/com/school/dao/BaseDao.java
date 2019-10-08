package com.school.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC������
 * ���������ӡ��ر���Դ
 * ������ɾ�Ĳ�
 * @author Administrator
 *
 */
public class BaseDao {
	
	private final String url = "jdbc:mysql://localhost:3306/school";
	private final String username = "root";// ���ݿ��û���
	private final String password = "root";// ���ݿ�����
	
	/**
	 * �������ݿ�
	 * @return	���Ӷ���
	 */
	public Connection getConnection(){
		Connection con = null;
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��������
			con = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�������Ӷ���
		return con;
	}
	
	/**
	 * �ر����ݿ�����
	 * @param con	���Ӷ���
	 * @param ps	ִ��sql������
	 * @param rs	���������
	 */
	public void closeAll(Connection con,PreparedStatement ps,ResultSet rs){
		//���ú��
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		/**
	 * ����ɾ���ĵĲ���
	 * @param sql Ԥ����� SQL ���          
	 * @param param Ԥ����� SQL ����еġ������������ַ�������          
	 * @return Ӱ�������
	 */
	public int exceuteUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;//��Ӱ������
		//��ȡ����
		Connection con =  getConnection(); 
		try {
			//Ԥ����sql
			pstmt = con.prepareStatement(preparedSql);
			//�жϣ�����������鲻Ϊ��
			if (param != null) {
				//ѭ����ֵ
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			//ִ��SQL��������Ӱ������
			num = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(con, pstmt, null);
		}
		return num;
	}
}
