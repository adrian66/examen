<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" 
src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script>
<title>Insert title here</title>
</head>
<body>
<h1	 align="center"><b><ins><FONT SIZE=7> INMUEBLE </font></ins></b>
	<br>
</h1>		

			 <input type="button" onclick="alta()" id="btnAlta" value="alta" >
  	<!--     <input type="button" id="btnListado" value="listado " onclick="evento()">   -->  
  			  <br />



Buscar:<input type="text" id="txtBuscar" placeholder="Pon tu busqueda">
	   <input type="button" id="btnBuscard" value="buscar direccion" onclick="buscard()"> 
	   <input type="button" id="btnBuscarp" value="buscar precio" onclick="buscarp()"> 
<table id="tblDatos">
<c:forEach items="${inmuebles }" var="inmueble">
	<tr>
		<td>${inmueble.direccion }</td>
		<td>${inmueble.precio }</td>
		<td><a href="detalleCasa.html?id=${inmueble.idInmueble}">
				Ver detalle
			</a>
	<!--		<a href="#" id="lnkDetalle"                          --> 
	<!--				onclick="evento(${inmueble.idInmueble})">    -->
	<!--			Detalle Ajax                                     -->
	<!-- 		</a>      -->
			<a href="modificarCasa.html/${inmueble.idInmueble}">
			Modificar
			</a>
			<a href="#" id="lnkBorrar" 
			onclick="borrar(${inmueble.idInmueble})">Borrar</a>
		</td>
	</tr>

</c:forEach>
</table>
<div id="divDetalle">

</div>
<script type="text/javascript">
function alta(){
	location.href="altaInmueble.html";
}

function borrar(id){

	var datos={idInmueble:id};

	var datosPasar=JSON.stringify(datos);

	$.ajax(
			"inmueble",{
				data:datosPasar,
				method: "DELETE",
				contentType: "application/json",
				success: function(res){
					alert("Inmueble borrado correctamente");
					$("#txtBuscar").text("");
					buscar();

					},
				error: function(res){
					alert(JSON.stringify(res));
					}
				}
			);
}

function buscard(){
	var tx=$("#txtBuscar").val();
	if(tx=="")
		tx="SinBusqueda";
	var url="inmueble/buscar/"+tx;	

	$.get(url,function(res){

		var tabla=$("#tblDatos");

		$("#tblDatos tr").each(function(){
				$(this).remove();

			});

		for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].direccion+"</td>";
			h+="<td>"+res[i].precio+"</td>";
			h+="<td><a href='detalleCasa_"+res[i].idInmueble+".html'>Detalle  </a> ";
	  //	h+="<a href='#' onclick='evento("+res[i].idInmueble+")'>Detalle ajax  </a> ";
			h+="<a href='#' onclick='borrar("+res[i].idInmueble+")'>Borrar  </a></td>";
			h+="</tr>";	
			tabla.append(h);
			}
	
		});
	
}

function buscarp(){
	var tx=$("#txtBuscar").val();
	if(tx=="")
		tx="SinBusqueda";
	var url="inmueble/buscar/"+tx;	

	$.get(url,function(res){

		var tabla=$("#tblDatos");

		$("#tblDatos tr").each(function(){
				$(this).remove();

			});

		for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].precio+"</td>";
			h+="<td>"+res[i].direccion+"</td>";
			h+="<td><a href='detalleCasa_"+res[i].idInmueble+".html'>Detalle  </a> ";
	  //	h+="<a href='#' onclick='evento("+res[i].idInmueble+")'>Detalle ajax  </a> ";
			h+="<a href='#' onclick='borrar("+res[i].idInmueble+")'>Borrar  </a></td>";
			h+="</tr>";	
			tabla.append(h);
			}
	
		});
	
}

function evento(id){

	var url="inmueble/"+id;
//HAcemos una llamada ajax usando el metodo get
//Le pasamos la url y la funcion que se ejecuta cuando nos 
//devuelve la informacion
	$.get(url,function(res){

		var resultado="<ul>";
		resultado+="<li>"+res.direccion+"</li>";
		resultado+="<li>"+res.precio+"</li>";
		
		$("#divDetalle").html(resultado);

		});
		
} 

</script>
</body>
</html>








