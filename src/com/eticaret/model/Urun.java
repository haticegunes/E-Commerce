package com.eticaret.model;

import java.io.InputStream;

public class Urun {

	private int urunId;
	private String urunAd;
	private String urunAciklama;
	private int urunFiyat;
	private int urunMiktar;
	private int Kategori_kategoriId;
	private int Marka_markaId;
	private InputStream urunResim;
	
	public Urun() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Urun(int urunId, String urunAd) {
		super();
		this.urunId = urunId;
		this.urunAd = urunAd;
	}
	public int getUrunId() {
		return urunId;
	}
	public void setUrunId(int urunId) {
		this.urunId = urunId;
	}
	public String getUrunAd() {
		return urunAd;
	}

	public void setUrunAd(String urunAd) {
		this.urunAd = urunAd;
	}
	public String getUrunAciklama() {
		return urunAciklama;
	}
	public void setUrunAciklama(String urunAciklama) {
		this.urunAciklama = urunAciklama;
	}
	public int getUrunFiyat() {
		return urunFiyat;
	}
	public void setUrunFiyat(int urunFiyat) {
		this.urunFiyat = urunFiyat;
	}
	public int getUrunMiktar() {
		return urunMiktar;
	}
	public void setUrunMiktar(int urunMiktar) {
		this.urunMiktar = urunMiktar;
	}
	public int getKategori_kategoriId() {
		return Kategori_kategoriId;
	}
	public void setKategori_kategoriId(int kategori_kategoriId) {
		Kategori_kategoriId = kategori_kategoriId;
	}
	public int getMarka_markaId() {
		return Marka_markaId;
	}
	public void setMarka_markaId(int marka_markaId) {
		Marka_markaId = marka_markaId;
	}
	public InputStream getUrunResim() {
		return urunResim;
	}
	public void setUrunResim(InputStream urunResim) {
		this.urunResim = urunResim;
	}
	
}
