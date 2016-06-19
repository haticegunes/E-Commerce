package com.eticaret.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.DAO.UrunDao;

@WebServlet("/UrunSil")
public class UrunSil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
			
		String id = request.getParameter("sil");
		System.out.println("ID: " + id);
		if(id != null && !id.equals("")){
			try { 
				int urunId = Integer.parseInt(id); 
				UrunDao.urunSil(urunId);
			} catch (SQLException e) {
				System.out.println("error " + e);
				e.printStackTrace();
			}
		}
		response.sendRedirect("urunIslemleri.jsp");			
	}		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
	}
}
