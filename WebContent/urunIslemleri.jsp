<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import="com.eticaret.model.*"
	import="com.eticaret.DAO.*"
%>
<% ArrayList<Urun> urunler = new ArrayList<Urun>(UrunDao.tumUrunleriGetir()); %>
<% ArrayList<Marka> markalar = new ArrayList<Marka>(MarkaDao.markalariGetir()); %>
<% ArrayList<Kategori> kategoriler = new ArrayList<Kategori>(KategoriDao.butunKategoriler()); %>
<!DOCTYPE html>
<html>
<%@ include file="header.jsp"%>
<body>
	<%@ include file="navbar.jsp"%>
	<div style="width: 50%;float: left;">
		<div class="login">
			<div class="container">
				<div class="login-main">  
		  			<div class="col-md-12 login-left">
						<h2>Ürün Ekle</h2>
						<form role="form" method="Post" action="UrunEkle" enctype="multipart/form-data">
							Ürün Adı : <input name="urunAd" type="text" /><br>
							Ürün Açıklama : <input name="urunAciklama" type="text" /><br>
							Ürün Fiyat :  <input name="urunFiyat" type="number" /><br>
							Ürün Miktar :  <input name="urunMiktar" type="number" /><br>
							
							Ürün Kategori :
							<select name="urunKategori">
								<%for(int i = 0; i < kategoriler.size(); i++){ %>
									<option value="<%= kategoriler.get(i).getKategoriId() %>"><%= kategoriler.get(i).getKategoriAdi() %></option>
								<%} %>
							</select>
							<br>
							Resim Yükle : <input type="file" name="resim">
							<button type="submit">Ekle</button>
						</form>
		 			</div>
		  			<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	</div>
	
	<div style="width: 50%;float: left;">
		<div class="ckeckout">
			<div class="container">
				<div class="ckeckout-top" style="width: 60%;">
					<div class=" cart-items heading">
			 			<h1>Ürün Sil</h1>
						<div class="in-check">
							<ul class="unit">
								<li><span>Ürün</span></li>
								<li><span>Ürün Adı</span></li>		
								<li><span>Fiyat</span></li>
								<div class="clearfix"></div>
							</ul>
							<%for(int i = 4; i < urunler.size(); i++){ %>
								<ul class="cart-header simpleCart_shelfItem">
									<li class="ring-in"><img src="UrunResimGetir?urunResim=<%=urunler.get(i).getUrunId() %>" class="img-responsive" alt=""></li>
									<li><span><%= urunler.get(i).getUrunAd() %></span></li>
									<li><span class="item_price">₺ <%=urunler.get(i).getUrunFiyat() %></span></li>
									<li> <a href="UrunSil?sil=<%=urunler.get(i).getUrunId() %>" class="add-cart cart-check item_add">Ürünü Sil</a></li>				
									<div class="clearfix"> </div>
								</ul>
							<%} %>	
						</div>
					</div>  
		 		</div>
			</div>
		</div>
	</div>
</body>
</html>