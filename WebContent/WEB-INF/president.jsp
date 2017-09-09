<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="mastercss.css">
</head>
<body class="bodyclass">
	<div class="jsp-header">

	</div>
	<div class="jsp-pres-info">

	<img src="${pres.imgURL}" class="presIMG">
	<p>${pres.name}</p>
	<p>${pres.sYear} - ${pres.eYear}</p>
	<p>${pres.party}</p>
	<p>${pres.fact}</p>
	<br>
	
	</div>
	<div class="form">
	<form action="something.do" method="POST">
		<input type="submit" name="cycle" value="Previous President">
		<input type="submit" name="cycle" value="Next President">
	</form>
	<a href="index.html">Go Home</a>
	</div>
</body>
</html>
