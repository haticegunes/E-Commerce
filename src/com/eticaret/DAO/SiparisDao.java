package com.eticaret.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eticaret.model.Siparis;
import com.eticaret.model.Urun;
import com.eticaret.model.Kargo;
//import com.eticaret.model.Urun;
import com.eticaret.model.Musteri;

public class SiparisDao {

	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static ResultSet rs = null;
	
	public static int siparisTamamla(Siparis siparis){
		int state = 0;
		String sql = "INSERT INTO Siparis(siparisTarihi,TeslimTarihi,adet,fiyat,Kargo_kargoId,Musteri_musteriId,Urun_urunId) VALUES(?,?,?,?,?,?,?)";
		try {			
			con = ConnectionDao.getConnection();			
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, siparis.getSiparisTarihi());
			psmt.setString(2, siparis.getTeslimTarihi());
			psmt.setInt(3, siparis.getAdet());
			psmt.setInt(4, siparis.getFiyat());
			psmt.setInt(5, siparis.getKargo_kargoId().getKargoId());
			psmt.setInt(6, siparis.getMusteri_musteriId().getMusteriId());
			psmt.setInt(7, siparis.getUrun_urunId().getUrunId());
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
	public static ArrayList<Siparis> tumSiparisleriGetir() throws SQLException {
		ArrayList<Siparis> tumSiparisler = new ArrayList<Siparis>();
		try {
			con = ConnectionDao.getConnection();
			psmt = con.prepareStatement(siparisSQL);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Siparis siparis = new Siparis();
				
				siparis.setSiparisId(rs.getInt(1));
				siparis.setSiparisTarihi(rs.getString(2));
				siparis.setTeslimTarihi(rs.getString(3));
				siparis.setAdet(rs.getInt(4));
				siparis.setFiyat(rs.getInt(5));
				siparis.setKargo_kargoId(new Kargo(rs.getString(6)));
				siparis.setMusteri_musteriId(new Musteri(rs.getString(7),rs.getString(8)));
				siparis.setUrun_urunId(new Urun(rs.getInt(9),rs.getString(10)));
			
				tumSiparisler.add(siparis);
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
		return tumSiparisler;
	}
	
	public static String musteriAdGetir(int musteriId){
		String adSoyad = null;
		String sql = "Select musteriAdi,musteriSoyadi from Musteri where musteriId=?;";
		try {
			con = ConnectionDao.getConnection();
			psmt =  con.prepareStatement(sql);
			psmt.setInt(1, musteriId);
			
			rs = psmt.executeQuery();
			
			if(rs.next()){			
				adSoyad = rs.getString(1) + " " + rs.getString(2).toUpperCase();
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
		return adSoyad;
	}
	
	public static int siparisSayisiGetir(){
		int adet = 0;
		String sql = "Select count(siparisId) from Siparis;";
		try {
			con = ConnectionDao.getConnection();
			psmt =  con.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			if(rs.next()){			
				int sayi=(rs.getInt(1));
				adet=sayi;
								
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
		return adet;
	}	
	public static int siparisSil(int siparisId){
		try {
			con = ConnectionDao.getConnection();
			psmt =  con.prepareStatement("Delete from Siparis where siparisId="+siparisId+";");
			psmt.executeUpdate();			
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
		return 1;
	}
	public static String siparisSQL = "SELECT "+
     "S.siparisId, "+
     "S.siparisTarihi, "+
     "S.teslimTarihi, "+
     "S.adet, "+
     "S.fiyat, "+
     "K.firmaAdi, "+
     "M.musteriAdi, "+
     "M.musteriSoyadi,U.urunId,U.urunAd "+
"FROM "+
     "Musteri M INNER JOIN Siparis S ON M.musteriId = S.Musteri_musteriId "+
     "INNER JOIN Kargo K ON S.Kargo_kargoId = K.kargoId "+
    " INNER JOIN Urun U ON S.Urun_urunId = U.urunId";
}
