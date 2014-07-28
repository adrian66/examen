<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 
	prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1	 align="center"><b><ins><FONT SIZE=7> Datos de INQUILINO </font></ins></b><br> 
	
</h1>

	<form:form method="post" commandName="inquilino">
		Nombre:<form:input path="nombre"/><br />
		DNI  :<form:input path="dni"/><br />
		Edad :<form:input path="edad"/><br />
		Trabaja :<form:input path="trabaja"/><br />
		Inmueble: <form:select path="idInmueble">
			<form:options items="${inmnuebles}"/>
		</form:select>
	
		<br />
	<input type="submit" value="dar de alta" />
	
	</form:form>
	

</body>
</html>