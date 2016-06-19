package com.eticaret.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eticaret.model.Kategori;

public class KategoriDao {
	
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static ArrayList<Kategori> butunKategoriler () throws SQLException {
		ArrayList<Kategori> butunkategoriler = new ArrayList<Kategori>();
		String sql = "SELECT * FROM Kategori;";
		try{
			
			con = ConnectionDao.getConnection();
			psmt=con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()){
				Kategori kategori=new Kategori();
				kategori.setKategoriId(rs.getInt(1));
				kategori.setKategoriAdi(rs.getString(2));
				
				butunkategoriler.add(kategori);
			}			
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			con.close();
			psmt.close();
			rs.close();			
		}
		
		return butunkategoriler;
	}
	
	public static int kategoriEkle(Kategori kategori) throws SQLException{
		int state = 0;
		String sql = "INSERT INTO Kategori(kategoriAdi) VALUES (?);";
		try{
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, kategori.getKategoriAdi());
			state = psmt.executeUpdate();
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			ConnectionDao.kapat(con, psmt);
		}
		return state;
	}
	
	public static int kategoriSil(Kategori kategori) throws SQLException{
		int state = 0;
		String sql = "DELETE FROM Kategori WHERE (kategoriId = ?);";
		try{
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, kategori.getKategoriId());
			state = psmt.executeUpdate();
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			ConnectionDao.kapat(con, psmt);
		}
		return state;
	}
	
	public static int kategoriGuncelle(Kategori kategori) throws SQLException{
		int state = 0;
		String sql = "UPDATE Kategori SET kategoriAdi = ? WHERE (kategoriId = ? );";
		try{
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, kategori.getKategoriAdi());
			psmt.setInt(2, kategori.getKategoriId());
			state = psmt.executeUpdate();
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			ConnectionDao.kapat(con, psmt);
		}
		return state;
	}

}
