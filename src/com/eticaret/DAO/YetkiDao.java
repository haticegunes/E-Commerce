package com.eticaret.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eticaret.model.Yetki;

public class YetkiDao {
	
	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;

	public static ArrayList<Yetki> tumYetkiler() throws SQLException {
		ArrayList<Yetki> yetkiler = new ArrayList<Yetki>();
		String sql = "Select * from Yetki order by yetkiId asc;";
		try {
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				yetkiler.add(new Yetki(rs.getInt(1), rs.getString(2)));
			}
			con.close();
		} catch (final SQLException ex) {
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
		return yetkiler;
	}
	public static int yeniYetkiEkle(Yetki yetki) throws SQLException {
		int state = 0;
		String sql = "INSERT INTO Yetki(yetkiAdi) VALUES(?);";
		try {
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, yetki.getYetkiAdi());
			state = psmt.executeUpdate();
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
		return state;
	}

	public static int yetkiSil(Yetki yetki) throws SQLException {
		int state = 0;
		String sql = "DELETE FROM Yetki Where yetkiId = ?;";
		try {
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, yetki.getYetkiId());
			state = psmt.executeUpdate();
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
		return state;
	}

	public static int yetkiGuncelle(Yetki yetki) throws SQLException {
		int state = 0;
		String sql = "UPDATE Yetki Set yetkiAdi = ? Where yetkiId = ?";
		try {
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, yetki.getYetkiAdi());
			psmt.setInt(2, yetki.getYetkiId());
			state = psmt.executeUpdate();
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
		return state;
	}
	
}
