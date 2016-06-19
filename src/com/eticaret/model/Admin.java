package com.eticaret.model;

public class Admin {
	private int adminId;
	private String adminAdi;
	private String adminSifre;
	private String adminMail;
	private int Yetki_yetkiId;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminId, String adminAdi, String kullaniciAdi, String adminSifre, String adminMail,
			int yetki_yetkiId) {
		super();
		this.adminId = adminId;
		this.adminAdi = adminAdi;
		this.adminSifre = adminSifre;
		this.adminMail = adminMail;
		Yetki_yetkiId = yetki_yetkiId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminAdi() {
		return adminAdi;
	}

	public void setAdminAdi(String adminAdi) {
		this.adminAdi = adminAdi;
	}

	public String getAdminSifre() {
		return adminSifre;
	}

	public void setAdminSifre(String adminSifre) {
		this.adminSifre = adminSifre;
	}

	public String getAdminMail() {
		return adminMail;
	}

	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}

	public int getYetki_yetkiId() {
		return Yetki_yetkiId;
	}

	public void setYetki_yetkiId(int yetki_yetkiId) {
		Yetki_yetkiId = yetki_yetkiId;
	}

}
