<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
							<h2>Admin Giriş Yap</h2>
							<form action="AdminLogin" method="POST">
								Mail :  <input name="adminMail" type="email" /><br>
								Şifre :  <input name="adminSifre" type="password" /><br>
								<button type="submit">Giriş Yap</button>
							</form>
		  				</div>
		  
		  				<div class="clearfix"> </div>
					</div>
				</div>
			</div>	
		</div>
			
</body>
</html>