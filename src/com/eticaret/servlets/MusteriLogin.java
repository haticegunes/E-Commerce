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

@WebServlet("/MusteriLogin")
public class MusteriLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MusteriLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String musteriMail = request.getParameter("musteriMail");
		String musteriSifre=request.getParameter("musteriSifre");
		if (musteriMail != null && musteriSifre != null) {
			System.out.println(musteriMail+"   "+musteriSifre);
			Musteri musteri = MusteriDao.getMusteriGiris(musteriMail, musteriSifre);
			
			//Müşteri null dönderse, null bir şeyde nesneye erişmek isteyeceğimiz için kod çalışmaz.Bu yüzden nesneyi direk null oluştururuz. 
			//Eğer veri varsa o gidip değerini bulacaktır.Burada musteri null olsaydı '.' hiyerarşisi çalışmayıp exception hatası alırdık..
			
			if (musteri != null) {
				ArrayList<Urun> sepetim = new ArrayList<Urun>();
				
				request.getSession().setAttribute("sepet", sepetim); //Sepet keyine 'sepetim' valuesini atadık.
				request.getSession().setAttribute("musteri", musteri);				
				response.sendRedirect("index.jsp");
			} else {				
				request.setAttribute("status", "E-Posta adresiniz veya şifre hatalı");
				request.getRequestDispatcher("kullanici.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}
	
}
