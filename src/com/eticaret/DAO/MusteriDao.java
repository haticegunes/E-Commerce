package com.eticaret.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

import com.eticaret.model.Musteri;


public class MusteriDao {
	private static Connection con=null;
	private static PreparedStatement psmt=null;
	private static ResultSet rs=null;

	
	public static ArrayList<Musteri> butunMusteriler() throws SQLException {
		ArrayList <Musteri> butunMusteriler= new ArrayList <Musteri>();
		String sql= "SELECT m.musteriId,m.musteriAdi, m.musteriSoyadi,m.musteriMail,m.musteriSifre,m.musteriSehir,y.yetkiAdi"
				+ "FROM Musteri As m INNER JOIN Yetki As y ON (m.yetkiId=y.yetkiId) ";
		
		try{
			con=ConnectionDao.getConnection();
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			while (rs.next()){
				Musteri musteri=new Musteri();
				musteri.setMusteriId(rs.getInt(1));
				musteri.setMusteriAdi(rs.getString(2));
				musteri.setMusteriSoyadi(rs.getString(3));
				musteri.setMusteriMail(rs.getString(4));
				musteri.setMusteriSifre(rs.getString(5));
				musteri.setMusteriSehir(rs.getString(6));
				musteri.setYetki_yetkiId(rs.getInt(7)); 
				
				butunMusteriler.add(musteri);	
			}
			
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			ConnectionDao.kapat(con, psmt,rs);
		}
		
		return butunMusteriler();
	}
	
	public static int musteriEkle(Musteri musteri){
		int state=0;
		String sql="INSERT INTO Musteri(musteriAdi,musteriSoyadi,musteriMail,musteriSifre,musteriSehir, Yetki_yetkiId) VALUES(?,?,?,md5(md5(?)),?,?)";
		try{
			con=ConnectionDao.getConnection();
			psmt=con.prepareStatement(sql);
			
			
			psmt.setString(1, musteri.getMusteriAdi());
			psmt.setString(2, musteri.getMusteriSoyadi());
			psmt.setString(3, musteri.getMusteriMail());
			psmt.setString(4, musteri.getMusteriSifre());
			psmt.setString(5, musteri.getMusteriSehir());
			psmt.setInt(6, musteri.getYetki_yetkiId());
			
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
	
	public static synchronized int musteriSil(int musteriId) throws SQLException {
		int state=0;
		String sql="Delete from Musteri where musteriId=?;";
		
		try{
			con= ConnectionDao.getConnection();
			psmt= con.prepareStatement(sql);
			psmt.setInt(1, musteriId);
			
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
	
	public static synchronized int musteriGuncelle(Musteri musteri)throws SQLException {
		int state=0;
		String sql="Update from Musteri set musteriAdi=?, musteriSoyadi=?, musteriMail=?, musteriSifre=md5(md5(?)), musteriSehir=? where musteriId=?";
		try{
			con=ConnectionDao.getConnection();
			psmt=con.prepareStatement(sql);
			
			psmt.setString(1, musteri.getMusteriAdi());
			psmt.setString(2, musteri.getMusteriSoyadi());
			psmt.setString(3, musteri.getMusteriMail());
			psmt.setString(4, musteri.getMusteriSifre());
			psmt.setString(5, musteri.getMusteriSehir());
			psmt.setInt(6, musteri.getMusteriId());
			
			state=psmt.executeUpdate();	
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionDao.kapat(con, psmt);
		}
		return state;
	}
	
	public static Musteri getMusteriGiris(String Mail, String Sifre){  // Müşterinin maili kullanıcı adı olmuş olur
		Musteri musteri=null;
		String sql="Select *from Musteri where musteriMail=? and musteriSifre=md5(md5(?));";
		try{
			con=ConnectionDao.getConnection();
			psmt=con.prepareStatement(sql);
			
			psmt.setString(1,Mail);
			psmt.setString(2, Sifre);
			rs=psmt.executeQuery();
			
			if(rs.next()){
				musteri=new Musteri();
				musteri.setMusteriId(rs.getInt(1));
				musteri.setMusteriAdi(rs.getString(2));
				musteri.setMusteriSoyadi(rs.getString(3));
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
		return musteri;
	}
}
