<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import="com.eticaret.model.*"
	import="com.eticaret.DAO.*"
%>
<% ArrayList<Urun> urun = new ArrayList<Urun>(UrunDao.tekUrunGetir(Integer.valueOf(request.getParameter("urunId"))));%> <!-- yolladığım urunIdyi alıp array listteki urune koy -->
<!DOCTYPE html>
<html>
<%@ include file="header.jsp"%>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="single">
   		<div class="container">
   	 		<div class="single-main">
   	 			<div class="single-top-main">
	   				<div class="col-md-5 single-top">
	   					<img src="UrunResimGetir?urunResim=<%=urun.get(0).getUrunId() %>" style="width:100%;"/>	   
					</div>
					<div class="col-md-7 single-top-left simpleCart_shelfItem">
						<h1><%= urun.get(0).getUrunAd() %></h1>
						<h6 class="item_price">₺ <%=urun.get(0).getUrunFiyat() %></h6>			
						<p><%=urun.get(0).getUrunAciklama() %></p>	
						<ul class="bann-btns">
							<li><a href="SepeteEkle?urunId=<%=urun.get(0).getUrunId() %>" class="item_add">Sepete At</a></li>					
	            		</ul>
					</div>
		   			<div class="clearfix"> </div>
	   			</div>
   	 		</div>
   		</div>
	</div>
</body>
</html>