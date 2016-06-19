package com.eticaret.model;

public class Kargo {
	private int kargoId;
	private String firmaAdi;
	private String fiyat;
	
	public Kargo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Kargo(int kargoId) {
		super();
		this.kargoId = kargoId;
	}

	public Kargo(String firmaAdi) {
		super();
		this.firmaAdi = firmaAdi;
	}

	public Kargo(int kargoId, String firmaAdi) {
		super();
		this.kargoId = kargoId;
		this.firmaAdi = firmaAdi;
	}

	public Kargo(String firmaAdi, String fiyat) {
		super();
		this.firmaAdi = firmaAdi;
		this.fiyat = fiyat;
	}

	public Kargo(int kargoId, String firmaAdi, String fiyat) {
		super();
		this.kargoId = kargoId;
		this.firmaAdi = firmaAdi;
		this.fiyat = fiyat;
	}



	public int getKargoId() {
		return kargoId;
	}

	public void setKargoId(int kargoId) {
		this.kargoId = kargoId;
	}

	public String getFirmaAdi() {
		return firmaAdi;
	}

	public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}

	public String getFiyat() {
		return fiyat;
	}

	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}
	
}