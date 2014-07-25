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
Buscar:<input type="text" id="txtBuscar" 
				placeholder="Pon tu busqueda">
	   <input type="button" id="btnBuscar" value="buscar" onclick="buscar()"> 
<table id="tblDatos">
<c:forEach items="${propietarios }" var="propietario">
	<tr>
		<td>${propietario.nombre }</td>
		<td>${propietario.dni }</td>
		<td><a href="detalle.html?id=${propietario.idPropietario}">
				Ver detalle
			</a>
			<a href="#" id="lnkDetalle" 
					onclick="evento(${propietario.idPropietario})">
				Detalle Ajax
			</a>
			<a href="#" id="lnkBorrar" 
			onclick="borrar(${propietario.idPropietario})">Borrar</a>
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
			"propietario",{
				data:datosPasar,
				method: "DELETE",
				contentType: "application/json",
				success: function(res){
					alert("Propietario borrado correctamente");
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
	var url="propietario/buscar/"+tx;	

	$.get(url,function(res){

		var tabla=$("#tblDatos");

		$("#tblDatos tr").each(function(){
				$(this).remove();

			});

		for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].nombre+"</td>";
			h+="<td>"+res[i].dni+"</td>";
			h+="<td><a href='detalle_"+
					res[i].idPropietario+".html'>Detalle  </a> ";
			h+="<a href='#' onclick='evento("+
				res[i].idPropietario+")'>Detalle ajax  </a> ";
			h+="<a href='#' onclick='borrar("+
				res[i].idPropietario+")'>Borrar  </a></td>";
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








