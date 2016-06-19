package com.eticaret.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.DAO.*;
import com.eticaret.model.Kargo;


@WebServlet("/KargoSil")
public class KargoSil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
			Kargo kargo = new Kargo();
			kargo.setKargoId(Integer.parseInt(request.getParameter("kargoId"))); //formdan namesi kargoId olan veriyi çektik
			try {
				int state = KargoDao.kargoSil(kargo);
				String message = (state == 1) ? "Kargo şirketi başarıyla silindi" : "İşlem sırasında bir hata oluştu";
				request.setAttribute("stateSilme", message); //mesaj stringini başka sayfada kullanmak için attr oluşturuyoruz
				request.getRequestDispatcher("kargo").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}



