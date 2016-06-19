package com.eticaret.model;

public class Siparis {
	private int siparisId;
	private String siparisTarihi;
	private String teslimTarihi;
	private int adet;
	private int fiyat;
	private Musteri Musteri_musteriId;
	private Kargo Kargo_kargoId;
	private Urun Urun_urunId;

	public Siparis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSiparisId() {
		return siparisId;
	}
	public void setSiparisId(int siparisId) {
		this.siparisId = siparisId;
	}
	public String getSiparisTarihi() {
		return siparisTarihi;
	}
	public void setSiparisTarihi(String siparisTarihi) {
		this.siparisTarihi = siparisTarihi;
	}

	public String getTeslimTarihi() {
		return teslimTarihi;
	}
	public void setTeslimTarihi(String teslimTarihi) {
		this.teslimTarihi = teslimTarihi;
	}
	public int getAdet() {
		return adet;
	}
	public void setAdet(int adet) {
		this.adet = adet;
	}
	public int getFiyat() {
		return fiyat;
	}
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
	public Musteri getMusteri_musteriId() {
		return Musteri_musteriId;
	}
	public void setMusteri_musteriId(Musteri musteri_musteriId) {
		Musteri_musteriId = musteri_musteriId;
	}
	public Kargo getKargo_kargoId() {
		return Kargo_kargoId;
	}
	public void setKargo_kargoId(Kargo kargo_kargoId) {
		Kargo_kargoId = kargo_kargoId;
	}
	public Urun getUrun_urunId() {
		return Urun_urunId;
	}
	public void setUrun_urunId(Urun urun_urunId) {
		Urun_urunId = urun_urunId;
	}	
}