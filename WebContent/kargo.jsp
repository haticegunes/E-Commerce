<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import="com.eticaret.model.*"
	import="com.eticaret.DAO.*"
%>

<!DOCTYPE html>
<html>
<%@ include file="header.jsp"%>
<body>
		<%@ include file="navbar.jsp"%>
				
	<div style="width: 50%;float: left;">
		<form action="KargoEkle" method="POST">
			Kargo Adı : <input name="firmaAdi" type="text" /><br>
			Kargo Fiyatı :  <input name="fiyat" type="number" /><br>
			<button type="submit">Kargo Ekle</button>
		</form>
	</div>
			
</body>
</html>