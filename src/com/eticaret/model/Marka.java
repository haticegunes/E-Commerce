package com.eticaret.model;
import java.io.InputStream;


public class Marka {
	
	private int markaId;
	private String markaAdi;
	private String markaAciklama;
	private String markaLogo;
	private InputStream streamImg;
	
	public Marka() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Marka(int markaId, String markaAdi, String markaAciklama, String markaLogo, InputStream streamImg) {
		super();
		this.markaId = markaId;
		this.markaAdi = markaAdi;
		this.markaAciklama = markaAciklama;
		this.markaLogo = markaLogo;
		this.streamImg = streamImg;
	}

	public int getMarkaId() {
		return markaId;
	}

	public void setMarkaId(int markaId) {
		this.markaId = markaId;
	}

	public String getMarkaAdi() {
		return markaAdi;
	}

	public void setMarkaAdi(String markaAdi) {
		this.markaAdi = markaAdi;
	}

	public String getMarkaAciklama() {
		return markaAciklama;
	}

	public void setMarkaAciklama(String markaAciklama) {
		this.markaAciklama = markaAciklama;
	}

	public String getMarkaLogo() {
		return markaLogo;
	}

	public void setMarkaLogo(String markaLogo) {
		this.markaLogo = markaLogo;
	}

	public InputStream getStreamImg() {
		return streamImg;
	}

	public void setStreamImg(InputStream streamImg) {
		this.streamImg = streamImg;
	}
}
