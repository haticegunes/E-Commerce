package com.eticaret.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.DAO.KategoriDao;
import com.eticaret.model.Kategori;

@WebServlet("/KategoriEkle")
public class KategoriEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public KategoriEkle() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Kategori kategori = new Kategori();
		kategori.setKategoriAdi(request.getParameter("kategoriAdi"));
		try {
			KategoriDao.kategoriEkle(kategori);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
	}
}
