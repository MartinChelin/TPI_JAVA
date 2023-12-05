<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.LinkedList" %>
    <%@ page import="Entidades.Producto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Recursos/CSS/bootstrap.css"/>
<%		  	
LinkedList<Producto> lp = (LinkedList<Producto>)request.getAttribute("listaProductos");
%>
<title>Lista de Productos</title>
</head>
<body>
<header class="p-3 bg-dark text-white">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>
  			<div class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"> <h1>CRUD Productos</h1>
  			</div>
  		</div>
  	</div>
</header>
	<div class="bg-primary"><h3>Agregar Producto:</h3>
		<form class="form form-horizontal" action="ProductoLista" method="POST">
		<p>Completar los campos:</p>
		<input type="text" class="form-control form-control-sm" name="codProd" placeholder="Id del Producto">
		<input type="text" class="form-control form-control-sm" name="nombre" placeholder="Nombre del Producto">
		<input type="text" class="form-control form-control-sm" name="descripcion" placeholder="Descripcion del Producto">
		<input type="text" class="form-control form-control-sm" name="stock" placeholder="Cantidad del Producto">
		<input type="text" class="form-control form-control-sm" name="precioBase" placeholder="Precio base del Producto">
		<input type="text" class="form-control form-control-sm" name="codCat" placeholder="Id de la Categoria">
		<input class="btn btn-success mx-auto d-flex align-items-center" type="submit" value="Agregar Producto">
		</form>
	<hr>
	</div>
	<div id="productos">
		<div><h2>Listado de Productos:</h2>
		<table class="table table-bordered table-hover table-primary">
                    		<thead>
                    			<tr>
                    				<th>Id</th>
                    		    	<th>Nombre</th>
                    		    	<th>Descripcion</th>
                        			<th>Stock</th>
                        			<th>Precio Base</th>
                        			<th>Categoria</th>
                        			<th></th>
                        			<th></th>
                      			</tr>
                      		</thead>
                    		<tbody>
                    		<% for (Producto prod : lp) { %>
                    			<tr>
                    				<td><%=prod.getCodProd()%></td>
                    				<td><%=prod.getNombre()%></td>
                    				<td><%=prod.getDescripcion()%></td>
                    				<td><%=prod.getStock()%></td>
                    				<td><%=prod.getPrecioBase()%></td>
                    				<td><%=prod.getCat().getDescripcion()%></td>
                    				<!-- editar -->
                    				<td><form action="ProductoEditar" method="GET">
                    					<input type="hidden" name="CodProd" value="<%=prod.getCodProd()%>">
                    					<button class="btn btn-primary" type="submit"> Editar </button>	
                    				    </form>
                    				</td>
                    				<!-- borrar -->
                    				<td><form action="ProductoEliminar" method="POST">
                    					<input type="hidden" name="CodProd" value="<%=prod.getCodProd()%>">
                    					<button class="btn btn-danger" type="submit"> Eliminar </button></form>
                    				</td>
                    			</tr>
                    		<% } %>
          					</tbody>
          </table>
      </div>
      </div>
</body>
</html>