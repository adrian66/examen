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

	<b>Datos de INMUEBLE></b><br />
	<form:form method="post" commandName="inmueble">
		<form:hidden path="idInmueble"/>
		Dirección:<form:input path="direccion"/><br />
		Precio   :<form:input path="precio"/><br />
		
		Inquilino: <form:select path="idInquilino">
			<form:options items="${inquilino}"/>
		</form:select>
		
		Propietario: <form:select path="idPropietario">
			<form:options items="${propietario}"/>
		</form:select>
		<br />
	<input type="submit" value="Guardar cambios" />
	
	</form:form>
	

</body>
</html>