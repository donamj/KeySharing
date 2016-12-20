<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<br><br><br>
	<u><b><h1>ENCRYPTION</h1></b></u>
	<form method="post" action="EncryptionController" >
	<div style="padding-left: 60px;margin:auto;width:600px;height:150px;border:1px solid #000;">
		<br>
		Message to be encrypted : <input type="text" name="plaintext"><br><br>
  		Key &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	: 
  		<input type="text" name="key"><br><br>
  		<input type="submit" name="encrypt" value="Encrypt"><br>
  		
  	</div>	
  	</form>
  	<br><br><br><br>
	<h3>
		<a href="index.jsp">RETURN HOME</a><br>
	</h3>
</center>
</body>
</html>