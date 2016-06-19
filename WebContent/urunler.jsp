<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import="com.eticaret.model.*"
	import="com.eticaret.DAO.*"
%>
<%
ArrayList<Urun> urunler = new ArrayList<Urun>(UrunDao.tumUrunleriGetir());
if(Integer.valueOf(request.getParameter("kategoriId")) > 0){
	urunler = new ArrayList<Urun>(UrunDao.tumUrunleriKategoriyeGoreGetir(Integer.valueOf(request.getParameter("kategoriId"))));
}
%>

<!DOCTYPE html>
<html>
<%@ include file="header.jsp"%>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="home-block">
		<div class="container">
			<div class="home-block-main">
				<%for(int i = 0; i < urunler.size(); i++){ %>
					<div class="col-md-3 home-grid">
						<div class="home-product-main">
				   			<div class="home-product-top">
				      			<a href="urun.jsp?urunId=<%=urunler.get(i).getUrunId() %>"><img src="UrunResimGetir?urunResim=<%=urunler.get(i).getUrunId() %>" alt="" class="img-responsive zoom-img"></a>
				   			</div>
							<div class="home-product-bottom">
								<h3><a href="urun.jsp?urunId=<%=urunler.get(i).getUrunId() %>"><%= urunler.get(i).getUrunAd() %></a></h3>								
							</div>
							<div class="srch">
								<span>₺ <%=urunler.get(i).getUrunFiyat() %></span>
							</div>
						</div>
					</div>
				<%} %>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>			
</body>
</html>