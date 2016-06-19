package com.eticaret.model;

public class Musteri {
	
	private int musteriId;
	private String musteriAdi;
	private String musteriSoyadi;
	private String musteriMail;
	private String musteriSifre;
	private String musteriSehir;
	private int Yetki_yetkiId;
	
	public Musteri(int musteriId) {
		super();
		this.musteriId = musteriId;
	}

	public Musteri() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Musteri(String musteriAdi, String musteriSoyadi) {
		super();
		this.musteriAdi = musteriAdi;
		this.musteriSoyadi = musteriSoyadi;
	}
	public Musteri(int musteriId, String musteriAdi, String musteriSoyadi, String musteriMail, String musteriSifre,
			String musteriSehir, int Yetki_yetkiId) {
		super();
		this.musteriId = musteriId;
		this.musteriAdi = musteriAdi;
		this.musteriSoyadi = musteriSoyadi;
		this.musteriMail = musteriMail;
		this.musteriSifre = musteriSifre;
		this.musteriSehir = musteriSehir;
		this.Yetki_yetkiId= Yetki_yetkiId;
	}
	public int getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(int musteriId) {
		this.musteriId = musteriId;
	}
	public String getMusteriAdi() {
		return musteriAdi;
	}
	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}
	public String getMusteriSoyadi() {
		return musteriSoyadi;
	}
	public void setMusteriSoyadi(String musteriSoyadi) {
		this.musteriSoyadi = musteriSoyadi;
	}

	public String getMusteriMail() {
		return musteriMail;
	}

	public void setMusteriMail(String musteriMail) {
		this.musteriMail = musteriMail;
	}
	public String getMusteriSifre() {
		return musteriSifre;
	}
	public void setMusteriSifre(String musteriSifre) {
		this.musteriSifre = musteriSifre;
	}
	public String getMusteriSehir() {
		return musteriSehir;
	}
	public void setMusteriSehir(String musteriSehir) {
		this.musteriSehir = musteriSehir;
	}
	public int getYetki_yetkiId() {
		return Yetki_yetkiId;
	}
	public void setYetki_yetkiId(int yetki_yetkiId) {
		Yetki_yetkiId = yetki_yetkiId;
	}	
}
