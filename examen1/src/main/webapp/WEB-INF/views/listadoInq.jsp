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
 Inquilino    : </font></ins></b> 
 			 <input type="button" id="btnAlta" value="alta  " onclick="buscar()">
  			 <input type="button" id="btnBaja" value="borrar  " onclick="borrar()">
  			 <input type="button" id="btnModificar" value="modificar " onclick="buscar()">
  			 <input type="button" id="btnListado" value="listado " onclick="buscar()"> 
  			 <br />
  			 
  			 
Buscar:<input type="text" id="txtBuscar" 
				placeholder="Pon tu busqueda">
	   <input type="button" id="btnBuscar" value="buscar" onclick="buscar()"> 
<table id="tblDatos">
<c:forEach items="${inquilinos }" var="propietario">
	<tr>
		<td>${inquilino.nombre }</td>
		<td>${inquilino.dni }</td>
		<td>${inquilino.edad }</td>
		<td>${inquilino.trabaja }</td>
		<td><a href="detalle.html?id=${inquilino.idInquilino}">
				Ver detalle
			</a>
			<a href="#" id="lnkDetalle" 
					onclick="evento(${inquilino.idInquilino})">
				Detalle Ajax
			</a>
			<a href="#" id="lnkBorrar" 
			onclick="borrar(${inquilino.idInquilino})">Borrar</a>
		</td>
	</tr>

</c:forEach>
</table>
<div id="divDetalle">

</div>
<script type="text/javascript">

function borrar(id){

	var datos={idInquilino:id};

	var datosPasar=JSON.stringify(datos);

	$.ajax(
			"inquilino",{
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
	var url="inquilino/buscar/"+tx;	

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
					res[i].idInquilino+".html'>Detalle  </a> ";
			h+="<a href='#' onclick='evento("+
				res[i].idInquilino+")'>Detalle ajax  </a> ";
			h+="<a href='#' onclick='borrar("+
				res[i].idInquilino+")'>Borrar  </a></td>";
			h+="</tr>";	
			tabla.append(h);
			}



		 "<a href='detalle.html?id=22'>Ver detalle</a>"

		});
	
}


function evento(id){

	var url="inquilino/"+id;
//HAcemos una llamada ajax usando el metodo get
//Le pasamos la url y la funcion que se ejecuta cuando nos 
//devuelve la informacion
	$.get(url,function(res){

		var resultado="<ul>";
		resultado+="<li>"+res.direccion+"</li>";
		resultado+="<li>"+res.precio"+</li></ul>";
	
		$("#divDetalle").html(resultado);

		});
		
} 

</script>
</body>
</html>







