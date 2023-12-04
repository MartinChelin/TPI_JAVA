<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidades.Producto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
Producto pe = (Producto)request.getAttribute("prodedit");
%>
<title>Editar Producto:</title>
</head>
<body>
<div><h3>Producto viejo</h3>
	<table>
		<thead>
			<tr> 
			<th>Id</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Stock</th>
			<th>Precio Base</th>
			<th>Categoria</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<td><%=pe.getCodProd()%></td>
			<td><%=pe.getNombre()%></td>
			<td><%=pe.getDescripcion()%></td>
			<td><%=pe.getStock()%></td>
			<td><%=pe.getPrecioBase()%></td>
			<td><%=pe.getCat().getDescripcion()%></td>
			</tr>
		</tbody>	
	</table>
</div>
	
<div><h3>Producto nuevo:</h3>
	<form action="ProductoEditar" method="POST">
	<input type="hidden" name="codProd" value="<%=pe.getCodProd()%>">
	<input type="text" name="nombre" placeholder="Ingrese nombre del producto">
	<input type="text" name="descripcion" placeholder="Ingrese descripcion del producto">
	<input type="text" name="stock" placeholder="Ingrese stock del producto">
	<input type="text" name="precioBase" placeholder="Ingrese precio del producto">
	<input type="text" name="codCat" placeholder="Ingrese id de la categoria del producto">
	<input type="submit" value="Confirmar cambios">
	</form>
</div>
</body>
</html>