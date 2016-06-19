<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import="com.eticaret.model.*"
	import="com.eticaret.DAO.*"
%>
<% ArrayList<Kategori> kategoriler_navbar = new ArrayList<Kategori>(KategoriDao.butunKategoriler()); %>

	<nav class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="navbar-brand logo">
				<a href="index.html"><img src="images/logo1.png" alt=""></a>
			</div>
		</div>
		<!--/.navbar-header-->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
				<li><a href="index.jsp">Ana Sayfa</a></li>
				<%for(int i = 0; i < kategoriler_navbar.size(); i++){ %>
					<li class="dropdown">
						<a href="urunler.jsp?kategoriId=<%= kategoriler_navbar.get(i).getKategoriId() %>" class="dropdown-toggle"><%= kategoriler_navbar.get(i).getKategoriAdi() %></a>
					</li>
				<%} %>
				<%if(session.getAttribute("musteri") == null && session.getAttribute("admin") == null){ %>
					<li class="dropdown">
						<a href="kullanici.jsp" class="dropdown-toggle">Giriş & Kayıt</a>
					</li>
				<%}
				if(session.getAttribute("musteri") != null || session.getAttribute("admin") != null){ %>
					<li class="dropdown">
						<a href="sepet.jsp" class="dropdown-toggle">Sepet</a>
					</li>
					<li class="dropdown">
						<a href="MusteriLogout" class="dropdown-toggle">Oturumu Kapat</a>
					</li>
				<%} %>						
				<%if(session.getAttribute("admin") != null){ %>
					
					<li class="dropdown">
						<a href="urunIslemleri.jsp" class="dropdown-toggle">Ürün İşlemleri</a>
					</li>
					<li  class="dropdown">
						<a href="kategoriEkle.jsp" class="dropdown-toggle"> Kategori İşlemleri</a>
					</li>
					<li class="dropdown">
						<a href="siparis.jsp" class="dropdown-toggle">Sipariş İşlemleri</a>
					</li>
				<%}%>				
				</ul>
			</div>	
	</nav>		