package com.eticaret.servlets;

import java.io.IOException;
//import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.DAO.AdminDao;
import com.eticaret.model.Admin;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminMail = request.getParameter("adminMail");
		String adminSifre = request.getParameter("adminSifre");
		//Formdan verileri çekip yeni oluşturduğumuz değişkenlere atıyoruz//
		
		if (adminMail != null && adminSifre != null) {
			//Inputlar boş değilse
			Admin admin = AdminDao.getAdminGiris(adminMail, adminSifre);
			if (admin != null) {
				//Veri tabanında kayıt varsa
				request.getSession().setAttribute("admin", admin);//admin keyine admin valuesini atıyoruz
				response.sendRedirect("adminIndex.jsp");
			} else {
				response.sendRedirect("admin.jsp"); 
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}