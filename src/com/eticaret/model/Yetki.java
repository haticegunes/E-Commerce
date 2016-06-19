package com.eticaret.model;

public class Yetki {

	private int yetkiId;
	private String yetkiAdi;
	
	public Yetki() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Yetki(int yetkiId, String yetkiAdi) {
		super();
		this.yetkiId = yetkiId;
		this.yetkiAdi = yetkiAdi;
	}

	public int getYetkiId() {
		return yetkiId;
	}

	public void setYetkiId(int yetkiId) {
		this.yetkiId = yetkiId;
	}

	public String getYetkiAdi() {
		return yetkiAdi;
	}

	public void setYetkiAdi(String yetkiAdi) {
		this.yetkiAdi = yetkiAdi;
	}
	
	
}
