<%@ page import="Entidades.Categoria" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
Categoria ce = (Categoria)request.getAttribute("catedit");
%>
<title>Edición Categoria</title>
</head>
<body>
<div><h3>Categoria vieja</h3>
	<table>
		<thead>
			<tr> 
			<th>id</th>
			<th>descripcion</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<td><%=ce.getCodCat()%></td>
			<td><%=ce.getDescripcion()%></td>
			</tr>
		</tbody>	
	</table>
</div>
	
<div><h3>Categoria nueva</h3>
	<form action="CategoriaEditar" method="POST">
	<input type="hidden" name="codCat" value="<%=ce.getCodCat()%>">
	<input type="text" name="descripcion" placeholder="Ingrese descripcion de la categoria">
	<input type="submit" value="Confirmar cambios">
	</form>
</div>
</body>
</html>