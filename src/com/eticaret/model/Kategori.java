package com.eticaret.model;

public class Kategori {

	private int kategoriId;
	private String kategoriAdi;
	
	public Kategori() {
		super();
	}	
	
	public Kategori(int kategoriId, String kategoriAdi) {
		super();
		this.kategoriId = kategoriId;
		this.kategoriAdi = kategoriAdi;
	}

	public int getKategoriId() {
		return kategoriId;
	}

	public void setKategoriId(int kategoriId) {
		this.kategoriId = kategoriId;
	}

	public String getKategoriAdi() {
		return kategoriAdi;
	}

	public void setKategoriAdi(String kategoriAdi) {
		this.kategoriAdi = kategoriAdi;
	}	
}
