package com.eticaret.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eticaret.model.Kargo;

public class KargoDao {

	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;

	public static ArrayList<Kargo> kargoListele() throws SQLException {
		ArrayList<Kargo> kargolar = new ArrayList<Kargo>();
		String sql = "SELECT * FROM Kargo order by KargoId asc;";
		try {
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				kargolar.add(new Kargo(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionDao.kapat(con, psmt, rs);	
		}
		return kargolar;
	}
	
	public static int kargoSil(Kargo kargo) throws SQLException {
		int state = 0;
		String sql="DELETE FROM Kargo WHERE kargoId = ?;";
		try{
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, kargo.getKargoId());
			state = psmt.executeUpdate();
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			ConnectionDao.kapat(con, psmt);
		}
		return state;
	}
	
	public static int kargoEkle(Kargo kargo) throws SQLException {
		int state = 0;
		String sql = "INSERT INTO Kargo(firmaAdi, fiyat) VALUES(?, ?);";
		try{
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, kargo.getFirmaAdi());
			psmt.setString(2, kargo.getFiyat());
			state = psmt.executeUpdate();
			con.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally {
			ConnectionDao.kapat(con, psmt);
		}
		return state;
	}
	
	public static int kargoGuncelle(Kargo kargo) throws SQLException {
		int state = 0;
		String sql = "UPDATE Kargo Set firmaAdi = ?, fiyat = ? WHERE kargoId = ?;";
		try{
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, kargo.getFirmaAdi());
			psmt.setString(2, kargo.getFiyat());
			psmt.setInt(3, kargo.getKargoId());
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
