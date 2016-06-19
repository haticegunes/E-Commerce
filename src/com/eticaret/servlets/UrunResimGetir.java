package com.eticaret.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eticaret.DAO.*;

@WebServlet("/UrunResimGetir")
public class UrunResimGetir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int resimId = Integer.parseInt(request.getParameter("urunResim"));
		response.setContentType("image/jpeg");
		byte[] image = UrunDao.getImageByUrunId(resimId); //Bütün eklenen resimler byte koda dönüştürülür
		response.setContentLength(image.length); //Resimin boyutunu döndürüyoruz.
		response.getOutputStream().write(image); //imagenin içine btyeyi yazıyoruz. Resim veri tabanına byte byte işleniyor.
	}

}
