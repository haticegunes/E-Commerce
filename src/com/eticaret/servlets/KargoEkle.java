package com.eticaret.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.DAO.KargoDao;
import com.eticaret.model.Kargo;

@WebServlet("/KargoEkle")
public class KargoEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public KargoEkle() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Kargo kargo=new Kargo();
		kargo.setFirmaAdi(request.getParameter("firmaAdi"));
		kargo.setFiyat(request.getParameter("fiyat"));
		try {
			KargoDao.kargoEkle(kargo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
	
	}

}
