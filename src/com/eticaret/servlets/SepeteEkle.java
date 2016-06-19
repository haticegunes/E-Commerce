package com.eticaret.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.DAO.UrunDao;
import com.eticaret.model.Urun;

@WebServlet("/SepeteEkle")
public class SepeteEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("urunId"));

		if (request.getSession().getAttribute("musteri") != null) {
			@SuppressWarnings("unchecked")
			ArrayList<Urun> sepet = (ArrayList<Urun>) request.getSession().getAttribute("sepet"); 
			//Sessiondaki sepet namesini liste olarak tanımladığımız sepet değişkenine atıyoruz.
			try {
				sepet.add(UrunDao.tekUrunGetir(id).get(0));
				request.getSession().setAttribute("sepet",sepet);
				System.out.println("1111111111111111111 : " + sepet.size()); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
