<%@ page import="java.util.LinkedList" %>
<%@ page import="entidades.Categoria" %>
<%@ page import="java.util.LinkedList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Recursos/CSS/bootstrap.css"/>
<%		  	
LinkedList<Categoria> lc = (LinkedList<Categoria>)request.getAttribute("listaCategoria");
%>
<title>Categorias</title>
</head>
<body>
	<header class="p-3 bg-dark text-white">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>
  			<div class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"> <h1>CRUD Categorias</h1>
  			</div>
  		</div>
  	</div>
</header>
	<div class="bg-primary"><h3>Agregar Categoria:</h3>
			<p class="text-left">Insertar codigo de categoria y descripcion:</p>
		<form class="form form-group form-horizontal" action="CategoriaLista" method="POST">
			<input type="text" class="form-control form-control-sm" name="codCat" placeholder="Id de la Categoria">
			<hr>
			<input type="text" class="form-control form-control-sm" name="descripcion" placeholder="Descripcion de la categoria">
			<hr>
			<input class="btn btn-success mx-auto d-flex align-items-center" type="submit" value="Agregar categoria">
		</form>
	<hr>
		</div>
	<div id="categorias">
		<h2>Listado de Categorias:</h2>
		<table class="table table-bordered table-hover table-primary">
                    		<thead>
                    			<tr>
                    				<th>id</th>
                    		    	<th>descripcion</th>
                        			<th></th>
                        			<th></th>
                      			</tr>
                      		</thead>
                    		<tbody>
                    		<% for (Categoria cat : lc) { %>
                    			<tr>
                    				<td><%=cat.getCodCat()%></td>
                    				<td><%=cat.getDescripcion()%></td>
                    				<!-- editar -->
                    				<td><form action="CategoriaEditar" method="GET">
                    					<input type="hidden" name="CodCat" value="<%=cat.getCodCat()%>">
                    					<button class="btn btn-primary" type="submit"> Editar </button>	
                    				    </form>
                    				</td>
                    				<!-- borrar -->
                    				<td><form action="CategoriaEliminar" method="POST">
                    					<input type="hidden" name="CodCat" value="<%=cat.getCodCat()%>">
                    					<button class="btn btn-danger" type="submit"> Eliminar </button></form>
                    				</td>
                    			</tr>
                    		<% } %>
          					</tbody>
          </table>
      </div>

</body>
</html>