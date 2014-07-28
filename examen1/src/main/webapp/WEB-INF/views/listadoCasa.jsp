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

<b><ins><FONT SIZE=5> 
Inmueble      : </font></ins></b>
			 <input type="button" id="btnAlta" value="alta  " onclick="buscar()">
  		     <input type="button" id="btnBaja" value="borrar  " onclick="borrar()">	
  			 <input type="button" id="btnModificar" value="modificar " onclick="buscar()">
  			 <input type="button" id="btnListado" value="listado " onclick="buscar()">  
  			  <br />



Buscar:<input type="text" id="txtBuscar" 
				placeholder="Pon tu busqueda">
	   <input type="button" id="btnBuscar" value="buscar" onclick="buscar()"> 
<table id="tblDatos">
<c:forEach items="${inmuebles }" var="propietario">
	<tr>
		<td>${inmueble.direccion }</td>
		<td>${inmueble.precio }</td>
		<td><a href="detalle.html?id=${inmueble.idInmueble}">
				Ver detalle
			</a>
			<a href="#" id="lnkDetalle" 
					onclick="evento(${inmueble.idInmueble})">
				Detalle Ajax
			</a>
			<a href="#" id="lnkBorrar" 
			onclick="borrar(${inmueble.idInmueble)">Borrar</a>
		</td>
	</tr>

</c:forEach>
</table>
<div id="divDetalle">

</div>
<script type="text/javascript">

function borrar(id){

	var datos={idPropietario:id};

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


function buscar(){
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
			h+="<td><a href='detalle_"+
					res[i].idInmueble+".html'>Detalle  </a> ";
			h+="<a href='#' onclick='evento("+
				res[i].idInmueble+")'>Detalle ajax  </a> ";
			h+="<a href='#' onclick='borrar("+
				res[i].idInmueble+")'>Borrar  </a></td>";
			h+="</tr>";	
			tabla.append(h);
			}



		 "<a href='detalle.html?id=22'>Ver detalle</a>"

		});
	
}


function evento(id){

	var url="propietario/"+id;
//HAcemos una llamada ajax usando el metodo get
//Le pasamos la url y la funcion que se ejecuta cuando nos 
//devuelve la informacion
	$.get(url,function(res){

		var resultado="<ul>";
		resultado+="<li>"+res.nombre+"</li>";
		resultado+="<li>"+res.dni+"</li>";
		resultado+="<li>"+res.inmueble.direccion+"</li>";
		resultado+="<li>"+res.inquilino.nombre+"</li></ul>";
	
		$("#divDetalle").html(resultado);

		});
		
} 

</script>
</body>
</html>








