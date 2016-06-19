package com.eticaret.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eticaret.model.Urun;

public class UrunDao {
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static ArrayList<Urun> tumUrunleriKategoriyeGoreGetir(int kid) throws SQLException {
		ArrayList<Urun> tumUrunler = new ArrayList<Urun>();
		try {
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement("Select * from Urun where Kategori_kategoriId =?;");
			psmt.setInt(1, kid);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Urun urun = new Urun();
				urun.setUrunId(rs.getInt(1));
				urun.setUrunAd(rs.getString(2));
				urun.setUrunAciklama(rs.getString(3));
				urun.setUrunFiyat(rs.getInt(4));
				urun.setUrunMiktar(rs.getInt(5));
				urun.setKategori_kategoriId(rs.getInt(8));
				tumUrunler.add(urun);
			}
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return tumUrunler;
	}
	
	
	public static ArrayList<Urun> tumUrunleriGetir() throws SQLException {
		ArrayList<Urun> tumUrunler = new ArrayList<Urun>();
		try {
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement("Select * from Urun;");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Urun urun = new Urun();
				urun.setUrunId(rs.getInt(1));
				urun.setUrunAd(rs.getString(2));
				urun.setUrunAciklama(rs.getString(3));
				urun.setUrunFiyat(rs.getInt(4));
				urun.setUrunMiktar(rs.getInt(5));
				urun.setKategori_kategoriId(rs.getInt(8));
				tumUrunler.add(urun);
			}
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return tumUrunler;
	}

	public static byte[] getImageByUrunId(int urunId) {
		String query = "select urunResim from Urun where urunId=?";
		Connection con = ConnectionDao.getConnection();
		PreparedStatement psmt;
		byte[] bytesImage = null;
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, urunId);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				bytesImage = rs.getBytes("urunResim");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bytesImage;
	}


	public static ArrayList<Urun> tekUrunGetir(int urunID) throws SQLException {
		ArrayList<Urun> urun = new ArrayList<Urun>();
		try {
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement("select * from Urun where urunId=?;"); 
			psmt.setInt(1, urunID);
			rs = psmt.executeQuery();
			if (rs.next()) {
				Urun urunler = new Urun();
				
				urunler.setUrunId(rs.getInt(1));
				urunler.setUrunAd(rs.getString(2));
				urunler.setUrunAciklama(rs.getString(3));
				urunler.setUrunFiyat(rs.getInt(4));
				urunler.setUrunMiktar(rs.getInt(5));
				urunler.setKategori_kategoriId(rs.getInt(8));
				urun.add(urunler);
						
			}
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return urun;
	}
	
	public static boolean urunSil(int urunId) throws SQLException {
		int status = 0;
		try {
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement("delete from Urun where urunId = ?;");
			psmt.setInt(1, urunId);
			status = psmt.executeUpdate();			
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();					
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return status > 0 ? true : false;
	}
	
	public static int urunEkle(Urun urun){
		int state = 0;
		String sql = "INSERT INTO Urun(urunAd,urunAciklama,urunFiyat,urunMiktar,urunResim,Kategori_kategoriId,Marka_markaId) VALUES(?,?,?,?,?,?,1)";
		try {			
			con = ConnectionDao.getConnection();			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, urun.getUrunAd());
			psmt.setString(2, urun.getUrunAciklama());
			psmt.setInt(3, urun.getUrunFiyat());
			psmt.setInt(4, urun.getUrunMiktar());
			psmt.setInt(6, urun.getKategori_kategoriId());
			psmt.setBlob(5, urun.getUrunResim());
			state = psmt.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
				psmt.close();				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return state;
	}
	
}
