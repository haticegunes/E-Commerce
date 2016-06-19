package com.eticaret.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDao {
	public static Connection getConnection(){
		Connection connectStatus =null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connectStatus=DriverManager.getConnection("jdbc:mysql://localhost:3306/eticaret?useUnicode=true&characterEncoding=UTF-8&useUnicode=true", "root", "1");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connectStatus;
	}
	
	public static void kapat(Connection con,PreparedStatement psmt, ResultSet rs) throws SQLException{
		if (con != null)
			con.close();
		if (psmt != null)
			psmt.close();
		if (rs != null)
			rs.close();
	}
	public static void kapat(Connection con,PreparedStatement psmt) throws SQLException{
		if (con != null)
			con.close();
		if (psmt != null)
			psmt.close();
	}
}
			
		