package com.eticaret.servlets;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.model.Kargo;
//import com.eticaret.DAO.LoginDAO;
import com.eticaret.model.Musteri;
import com.eticaret.model.Urun;
import com.eticaret.model.Siparis;
import com.eticaret.DAO.*;

import java.text.DateFormat;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/SiparisTamamla")
public class SiparisTamamla extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("musteri")!=null){
			Siparis siparis=new Siparis();
			
			Musteri musteri =(Musteri) request.getSession().getAttribute("musteri") ;
			@SuppressWarnings("unchecked")
			ArrayList<Urun> urunler = (ArrayList<Urun>) request.getSession().getAttribute("sepet");
			
			 	Date simdikiZaman = new Date();
		        System.out.println(simdikiZaman.toString());
		        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			
			for(int i=0;i<urunler.size();i++){
				siparis.setMusteri_musteriId(musteri);
				siparis.setAdet(1);
				siparis.setFiyat(urunler.get(i).getUrunFiyat());//i.ürüne ulaşıp ürünün fiyatını alıyoruz.
				siparis.setSiparisTarihi(df.format(simdikiZaman));
				siparis.setUrun_urunId(urunler.get(i));
				siparis.setKargo_kargoId(new Kargo(1));
				SiparisDao.siparisTamamla(siparis);
				
			}
			urunler.clear();
		}
		
			response.sendRedirect("index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	

}
