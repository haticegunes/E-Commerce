package com.eticaret.servlets;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.eticaret.DAO.*;
import com.eticaret.model.Urun;

@WebServlet("/UrunEkle")
@MultipartConfig(maxFileSize = 16177215) 
public class UrunEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    public UrunEkle() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String isim = request.getParameter("urunAd");
		int katId=Integer.parseInt(request.getParameter("urunKategori"));
		
		String aciklama = request.getParameter("urunAciklama");
		int miktar = Integer.parseInt(request.getParameter("urunMiktar"));
		int fiyat = Integer.parseInt(request.getParameter("urunFiyat"));
		
		System.out.println("ID: " + katId);
		InputStream resim = null; 
     
        Part filePart = request.getPart("resim");
        if (filePart != null) {
            resim = filePart.getInputStream();
        }
		
		if(isim!="" && aciklama!="" && miktar!=0 && fiyat!=0 && resim!=null){
			Urun urun=new Urun();
			urun.setUrunAd(isim);
			urun.setUrunAciklama(aciklama);
			urun.setUrunMiktar(miktar);
			urun.setUrunFiyat(fiyat);
			urun.setKategori_kategoriId(katId);
			urun.setUrunResim(resim);
			int eklendiMi = UrunDao.urunEkle(urun);
			if(eklendiMi != 0){
				int id=0;
				try{
					int size = UrunDao.tumUrunleriGetir().size();
					id = UrunDao.tumUrunleriGetir().get(size-1).getUrunId();
					response.sendRedirect("urun.jsp?urunId=" + id);	
				}catch(Exception err){
				}
			}
			else{				
				response.sendRedirect("urunIslemleri.jsp");		
			}
		}
		else{						
			response.sendRedirect("urunIslemleri.jsp");		
		}	
	}
}
