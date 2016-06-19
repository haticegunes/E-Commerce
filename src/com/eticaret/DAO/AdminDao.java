package com.eticaret.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

import com.eticaret.model.Admin;
import com.eticaret.model.Musteri;


public class AdminDao {
	private static Connection con=null;
	private static PreparedStatement psmt=null;
	private static ResultSet rs=null;

	public static ArrayList<Admin> butunAdminler () throws SQLException {
		ArrayList<Admin> adminler=new ArrayList<Admin>();
		String sql="Select a.adminId, a.adminAdi,a.adminSifre,a.adminMail,y.yetkiAdi FROM Admin As a"
				+"INNERJOIN Yetki As y On (a.yetkiId=y.yetkiId) ";
		try{
			con=ConnectionDao.getConnection();
			psmt=con.prepareStatement(sql);
			
			while(rs.next()){
				Admin admin=new Admin();
				admin.setAdminId(rs.getInt(1));
				admin.setAdminAdi(rs.getString(2));
				admin.setAdminSifre(rs.getString(3));
				admin.setAdminMail(rs.getString(4));
				admin.setYetki_yetkiId(rs.getInt(5));
				
				adminler.add(admin);		
			}
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			ConnectionDao.kapat(con, psmt,rs);
		}
		return butunAdminler();	
	}
	
	public static int adminEkle(Musteri admin){
		int state=0;
		String sql="INSERT INTO Admin(adminAdi,adminSifre,adminMail, Yetki_yetkiId) VALUES(?,md5(md5(?)),?,?)";
		try{
			con=ConnectionDao.getConnection();
			psmt=con.prepareStatement(sql);
			
			psmt.setString(1, admin.getMusteriAdi());
			psmt.setString(2, admin.getMusteriSifre());
			psmt.setString(3, admin.getMusteriMail());
			psmt.setInt(4, admin.getYetki_yetkiId());
			
			state=psmt.executeUpdate();		
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		finally {
			try {  
				ConnectionDao.kapat(con, psmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return state;
	}
	
	public static synchronized int adminSil(Admin admin) throws SQLException {
		int state=0;
		String sql="Delete from Admin where adminId=?;";
		
		try{
			con= ConnectionDao.getConnection();
			psmt= con.prepareStatement(sql);
			psmt.setInt(1, admin.getAdminId());
			
			state=psmt.executeUpdate();
			
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
		finally{		
				ConnectionDao.kapat(con, psmt);		
		}
		return state;	
	}
	
	public static synchronized int adminSifreGuncelle(Admin admin)throws SQLException {
		int state=0;
		String sql="Update from Admin set adminSifre=md5(md5(?)) where (adminId=?);";
		try{
			con=ConnectionDao.getConnection();
			psmt=con.prepareStatement(sql);
			
			psmt.setString(1, admin.getAdminSifre());
			psmt.setInt(2, admin.getAdminId());
			
			state=psmt.executeUpdate();	
			con.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionDao.kapat(con, psmt);
		}
		return state;
	}
	
	public static Admin getAdminGiris(String Mail, String Sifre) {
		Admin admin=null;
		String sql="Select * from Admin where adminMail=? and adminSifre=?;";
		
		try{
			con=ConnectionDao.getConnection();
			psmt=con.prepareStatement(sql);
			
			psmt.setString(1, Mail);
			psmt.setString(2, Sifre);
			rs=psmt.executeQuery();
			
			if(rs.next()){
				admin=new Admin();
				admin.setAdminId(rs.getInt(1));
				admin.setAdminAdi(rs.getString(2));	
				admin.setAdminSifre(rs.getString(3));
				admin.setAdminMail(rs.getString(4));
			}
			con.close();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {  
				ConnectionDao.kapat(con, psmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return admin;		
	}
}
