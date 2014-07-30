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

<h1	 align="center"><b><ins><FONT SIZE=7> Datos de PROPIETARIO </font></ins></b><br> 
</h1>
		<form:form method="post" commandName="propietario">
		<form:hidden path="idPropietario"/>
		Nombre:<form:input path="nombre"/><br />
		DNI :<form:input path="dni"/><br />
		
		Inmueble: <form:select path="idInmueble">
			<form:options items="${inmueble}"/>
		</form:select>
		
		<br />
	<input type="submit" value="Guardar cambios" />
	
	</form:form>
	

</body>
</html>