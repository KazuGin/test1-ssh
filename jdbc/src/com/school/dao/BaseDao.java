package com.school.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC工具类
 * 负责建立连接、关闭资源
 * 负责增删改查
 * @author Administrator
 *
 */
public class BaseDao {
	
	private final String url = "jdbc:mysql://localhost:3306/school";
	private final String username = "root";// 数据库用户名
	private final String password = "root";// 数据库密码
	
	/**
	 * 连接数据库
	 * @return	连接对象
	 */
	public Connection getConnection(){
		Connection con = null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.建立连接
			con = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回连接对象
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param con	连接对象
	 * @param ps	执行sql语句对象
	 * @param rs	结果集对象
	 */
	public void closeAll(Connection con,PreparedStatement ps,ResultSet rs){
		//先用后关
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
	 * 增、删、改的操作
	 * @param sql 预编译的 SQL 语句          
	 * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组          
	 * @return 影响的行数
	 */
	public int exceuteUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;//受影响行数
		//获取连接
		Connection con =  getConnection(); 
		try {
			//预编译sql
			pstmt = con.prepareStatement(preparedSql);
			//判断：如果参数数组不为空
			if (param != null) {
				//循环赋值
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			//执行SQL，返回受影响行数
			num = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(con, pstmt, null);
		}
		return num;
	}
}
