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

	align="center"><b><ins><FONT SIZE=7>Datos del INMUEBLE </font></ins></b><br />
	<form:form method="post" commandName="inmueble">
		Dirección:<form:input path="direccion"/><br />
		Precio  :<form:input path="precio"/><br />
		
		
	
		<br />
	<input type="submit" value="dar de alta" />
	
	</form:form>
	

</body>
</html>