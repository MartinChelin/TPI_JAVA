<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Primer Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
  <body>
    <div class ="container"><br>
    <center><h1>Kiosco App</h1></center><br>
    <div class = "row">
    	<div class = "col-2"></div>
    	<div class = "col-4">
    	<form action="login">
    		<br>
    		<br>
		    <label class="form-label">Usuario</label>
		    <input type="text" class="form-control" name ="uname" required>
		  	<label class="form-label">Contraseña</label>
		    <input type="password" class="form-control" name ="pass" required>
		  	<br>
		  	<div>
		  		<label class="form-label">¿No tienen una cuenta?</label>
		  		<button type="button" class="btn btn-link" onclick="window.location.href='registrar.jsp'">Registrate</button>
		  	</div>
		  	<br>
		  	<button type="login" class="btn btn-primary">Acceder</button>
		</form>
    	</div>
    		<div class = "col-4">
    			<img alt="" class="img-thumbnail" src="https://img.freepik.com/free-vector/computer-login-concept-illustration_114360-7962.jpg?w=740&t=st=1696285249~exp=1696285849~hmac=27292e158e7aea1b3d8a05b1b76ac0c30832bd67a93eaad406f09aef202df676">
    		</div>
    		<div class = "col-2"></div>	
    </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  </body>
</html>