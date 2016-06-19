package com.eticaret.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.model.Urun;

@WebServlet("/SepettenCikar")
public class SepettenCikar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int urunId = Integer.parseInt(request.getParameter("urunId"));
		@SuppressWarnings("unchecked")
		ArrayList<Urun> sepet = (ArrayList<Urun>) request.getSession().getAttribute("sepet");
		ArrayList<Urun> yeniSepet = new ArrayList<Urun>(); //içi boş sepet
		
		for(int i = 0; i < sepet.size();i++){
			if(sepet.get(i).getUrunId() != urunId){ //sepetten çıkarılan ürün idsi ile eski sepetteki ürünün idsi aynı ise yeni sepete atma o ürünü sil yani.
				yeniSepet.add(sepet.get(i));
			}			
		}
		request.getSession().setAttribute("sepet",yeniSepet); //Sepet yeni sepet oluyor.
		request.getRequestDispatcher("sepet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
