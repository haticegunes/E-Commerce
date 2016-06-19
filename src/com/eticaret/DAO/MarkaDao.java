package com.eticaret.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eticaret.model.Marka;
//import com.eticaret.model.Urun;

public class MarkaDao {
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	
	
	public static ArrayList<Marka> markalariGetir() throws SQLException {
		ArrayList<Marka> markalar = new ArrayList<Marka>();
		String sql = "Select * from Marka order by markaId asc;";
		try {
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Marka marka = new Marka();
				marka.setMarkaId(rs.getInt(1));
				marka.setMarkaAdi(rs.getString(2));
				marka.setMarkaAciklama(rs.getString(3));
				markalar.add(marka);
			}
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
		return markalar;
	}
	
	public static int markaEkle(Marka marka) throws SQLException {
		int state = 0;
		String sql = "INSERT INTO Marka(markaAdi, markaAciklama, markaLogo) VALUES(?, ?, ?);";
		try{
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, marka.getMarkaAdi());
			psmt.setString(2, marka.getMarkaAciklama());
			psmt.setBlob(3, marka.getStreamImg());
			state = psmt.executeUpdate();
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			try {
				con.close();
				psmt.close();				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return state;
	}
	
	public static int markaSil(Marka marka) throws SQLException {
		int state = 0;
		String sql = "DELETE FROM Marka WHERE markaId = ?";
		try{
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, marka.getMarkaId());
			state = psmt.executeUpdate();
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			try {
				con.close();
				psmt.close();				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return state;
	}
	
	public static int markaLogoGuncelle(Marka marka) throws SQLException {
		int state = 0;
		String sql = "UPDATE Marka set markaAdi = ?, markaAciklama = ?, markaLogo = ? WHERE markaId = ?";
		try{
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, marka.getMarkaAdi());
			psmt.setString(2, marka.getMarkaAciklama());
			psmt.setBlob(3, marka.getStreamImg());
			psmt.setInt(4, marka.getMarkaId());
			state = psmt.executeUpdate();
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			try {
				con.close();
				psmt.close();				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return state ;
	}
	
	public static byte[] getImageByMarkaId(int markaID){
		String query = "select markaLogo from Marka where markaId=?";
		Connection con = ConnectionDao.getConnection();
		PreparedStatement psmt;
		byte[] bytesImage = null;
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, markaID);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				bytesImage = rs.getBytes("MarkaLogo");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bytesImage;
	}

}
