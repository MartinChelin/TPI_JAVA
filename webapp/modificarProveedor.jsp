<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidades.Proveedor" %>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>main</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
  <body>
    <div class ="container"><br>
    <center><h1>Modificar Proveedor</h1></center><br>
    <div class = "row">
    	<div class = "col-2"></div>
    	<div class="col-4">
    <form action="ServletModificarProveedor" method="post">
        <br>
        <br>
        <%
        	String dniProveedor = request.getParameter("dniProveedor");
        %>
        <input name="dniProveedor" class="form-control" value="<%=dniProveedor%>" type="hidden" required><br>
        
        <label class="form-label">Nombre:</label>
        <input class="form-control" type="text" id="nombre" name="nombre" required><br>
        
        <label class="form-label">Apellido:</label>
        <input class="form-control" type="text" id="apellido" name="apellido" required><br>
        
        <label class="form-label">Teléfono:</label>
        <input class="form-control" type="text" id="telefono" name="telefono" required><br>
        
        <label class="form-label">Dirección:</label>
        <input class="form-control" type="text" id="direccion" name="direccion" required><br>
        
        <label class="form-label">Mail:</label>
        <input class="form-control" type="email" id="mail" name="mail" required><br>
        
        
        <button type = "submit">Modificar Proveedor</button>
    </form>
</div>

    		<div class = "col-2"></div>	
    </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>