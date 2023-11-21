<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <center><h1>Registrarse</h1></center><br>
    <div class = "row">
    	<div class = "col-2"></div>
    	<div class = "col-4">
    	<form action="registrar" method="post">
    		<br>
    		<br>
		    <label class="form-label">Username:</label>
		    <input type="text" class="form-control" name ="usuario" required>
		    
		  	<label class="form-label">Password:</label>
		    <input type="password" class="form-control" name ="password" required>
		    
		    <label class="form-label">DNI:</label>
	        <input class="form-control" type="text" id="dniCliente" name="dniCliente" required>
	
	        <label class="form-label">Nombre:</label>
	        <input class="form-control" type="text" id="nombre" name="nombre" required>
	
	        <label class="form-label">Apellido:</label>
	        <input class="form-control" type="text" id="apellido" name="apellido" required>
	
	        <label class="form-label">Correo electrónico:</label>
	        <input class="form-control" type="email" id="mail" name="mail" required><br>
	
	        <label class="form-label">Fecha de nacimiento:</label>
	        <input class="form-control" type="date" id="fechaNac" name="fechaNac" required>
		    
		  	<br>
		  	<button type="registrar" class="btn btn-primary">Registrar Usuario</button>
		</form>
    	</div>
    		<div class = "col-4">
    			<img alt="" class="img-thumbnail" src="https://img.freepik.com/vector-gratis/registrarse-ilustracion-concepto_114360-7965.jpg?w=740&t=st=1696374899~exp=1696375499~hmac=a1fc1e2951e750527342093cb810fe877117a740505e6052d741650447d79c0f">
    		</div>
    		<div class = "col-2"></div>	
    </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>