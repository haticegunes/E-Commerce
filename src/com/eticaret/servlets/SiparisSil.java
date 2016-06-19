package com.eticaret.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.DAO.*;


@WebServlet("/SiparisSil")
public class SiparisSil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("sil");//Formdan gelen veri her zaman stringdir
		if(id != null && !id.equals("")){
			int siparisId = Integer.parseInt(id); //Bu yüzden String gelen idyi inte çeviririz.
			SiparisDao.siparisSil(siparisId);
		}
		response.sendRedirect("siparis.jsp");
	}

}
