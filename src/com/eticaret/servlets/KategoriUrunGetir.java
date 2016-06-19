package com.eticaret.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.DAO.*;
import com.eticaret.model.Urun;

@WebServlet("/KategoriUrunGetir")
public class KategoriUrunGetir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("kid"); //formdaki kidyi çekip id değişkenine atıyoruz
		ArrayList<Urun> uruns = null;
		if(id != null && !id.equals("")){
			int kategoriId = Integer.parseInt(id);//tüm ürünleri getir Daosu integer tanımlandığı için kategori id int oluyor.
			try {
				uruns = UrunDao.tumUrunleriKategoriyeGoreGetir(kategoriId); //kategoriidyi çeğırıp urun listesine koyuyoruz
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(uruns != null){
			request.setAttribute("k_id", id);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
