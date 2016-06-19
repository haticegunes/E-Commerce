package com.eticaret.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.DAO.*;
import com.eticaret.model.Musteri;
import com.eticaret.model.Urun;



@WebServlet("/MusteriEkle")
public class MusteriEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// request(aldığımız veriler) utf-8e uygun olsun
		String isim = request.getParameter("musteriAdi"); 
		String soyad=request.getParameter("musteriSoyadi");
		String mail = request.getParameter("musteriMail");
		String sifre = request.getParameter("musteriSifre");
		String sehir= request.getParameter("musteriSehir");
		
		if(isim!="" && soyad!="" && mail!="" && sifre!="" && sehir!=""){
			Musteri musteri=new Musteri();
			musteri.setMusteriAdi(isim); 
			musteri.setMusteriSoyadi(soyad);
			musteri.setMusteriMail(mail);
			musteri.setMusteriSifre(sifre);
			musteri.setMusteriSehir(sehir);
			musteri.setYetki_yetkiId(2);
			//formdan çektiklerimizi modeldeki musteri attributelerine atıyoruz
			int eklendiMi = MusteriDao.musteriEkle(musteri); 
			//müşteridao sınıfından müşteri ekle metodundaki müşteri nesnesine gönderiyor veritabanı işleyecek
			
			if(eklendiMi != 0){ //müşteri eklendiyse
				ArrayList<Urun> sepet = new ArrayList<Urun>();  //içinde ürün olan sepet adında bir arraylist oluştur
				request.getSession().setAttribute("sepet", sepet); //sepet keyine tipi arraylist olan sepeti ata
				request.getSession().setAttribute("musteri", musteri); //müşteri kayıt olduğu anda giriş yapsın ve hemen alışverişe başlasın.
				response.sendRedirect("index.jsp");
			}else{				
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else{			
			request.getRequestDispatcher("kullanici.jsp").forward(request, response);
			
		}
	}

}
