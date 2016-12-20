<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<br><br><br><br>
	<h1><b><u>KEY REGENERATION</u></b></h1>
	<div style="padding-left: 60px;margin:auto;width:600px;height:300px;border:1px solid #000;">
		<br>
	
	<form method="post" action="ShareCombineController" >
	
		Total Number of shares	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="share"><br>
  		Security level (1>2>3) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="level"><br>
  		Prime Number		   	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="prime"><br>
  		<br>Enter key shares on each line, along with user id separated by space:<br><br>
  		<textarea name="shares" cols="40" rows="5"></textarea><br><br>
 		<input type="submit" name="sharelist" value="Combine share">		
  	</form>
  	</div>
  	<br><br><br><br>
  	<h3>
		<a href="index.jsp">RETURN HOME</a><br>
	</h3>
	
</center>
	</body>
</html>