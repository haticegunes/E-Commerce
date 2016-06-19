<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.eticaret.model.*" import="com.eticaret.DAO.*"%>
<% request.setAttribute("siparisler",SiparisDao.tumSiparisleriGetir()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%@ include file="header.jsp"%>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="ckeckout">
		<div class="container">
			<div class="ckeckout-top">
				<div class=" cart-items heading">
			 		<div class="in-check">
						<ul class="unit">
							<li><span>Adı- Soyadı</span></li>
							<li><span>Ürün Adı</span></li>		
							<li><span>Adet</span></li>
							<li><span>Fiyat</span></li>
							<li><span>Sipariş Tarihi</span></li>
							
							
							<div class="clearfix"> </div>
						</ul>	
						<c:forEach items="${siparisler}" var="siparis">
							<ul class="cart-header simpleCart_shelfItem">
								<li>${siparis.getMusteri_musteriId().getMusteriAdi()}- ${siparis.getMusteri_musteriId().getMusteriSoyadi()}</li>
								<li>${siparis.getUrun_urunId().getUrunAd()}</li>
								<li>${siparis.getAdet()}</li>
								<li>₺ ${siparis.getFiyat()} </li>
								<li>${siparis.getSiparisTarihi()}</li>
								
								<li><a href="SiparisSil?sil=${siparis.getSiparisId()}" class="add-cart cart-check item_add">Ürünü Sil</a> </li>
								<div class="clearfix"> </div>
							</ul>
						</c:forEach>
					</div>
				</div>  
		 	</div>
		</div>
	</div>	
	
</body>
</html>