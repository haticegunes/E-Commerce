<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@page
	import="com.eticaret.model.*"
	import="com.eticaret.DAO.*"
%>
<% ArrayList<Urun> sepet = new ArrayList<Urun> ((ArrayList<Urun>) request.getSession().getAttribute("sepet")); %>
<!DOCTYPE html>
<html>
<%@ include file="header.jsp"%>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="ckeckout">
		<div class="container">
			<div class="ckeckout-top">
				<div class=" cart-items heading">
			 		<h1>Sepetim</h1>		
					<div class="in-check">
						<ul class="unit">
							<li><span>Ürün</span></li>
							<li><span>Ürün Adı</span></li>		
							<li><span>Fiyat</span></li>
							<div class="clearfix"> </div>
						</ul>
						<%for(int i = 0; i < sepet.size(); i++){ %>
							<ul class="cart-header simpleCart_shelfItem">
								<li class="ring-in"><img src="UrunResimGetir?urunResim=<%=sepet.get(i).getUrunId() %>" class="img-responsive" alt=""></li>
								<li><span><%= sepet.get(i).getUrunAd() %></span></li>
								<li><span class="item_price">₺ <%=sepet.get(i).getUrunFiyat() %></span></li>
								<li> <a href="SepettenCikar?urunId=<%=sepet.get(i).getUrunId() %>" class="add-cart cart-check item_add">Sepetten Çıkar</a></li>				
								<div class="clearfix"> </div>
							</ul>
						<%} %>
						<a  href="SiparisTamamla"><button class="btn btn-warning">Satın Al</button></a>	
					</div>
				</div>  
		 	</div>
		</div>
	</div>	
</body>
</html>