<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="Entidades.Proveedor" %>
 <%@ page import="java.util.LinkedList" %>   
 
<!DOCTYPE html>
<html>


<head>
	<meta charset="ISO-8859-1">
	<title>Control Proovedores</title>
    <%
    	if(session.getAttribute("username")==null){
    		response.sendRedirect("login.jsp");
    	}
    %>    
	<%
		String username = (String)session.getAttribute("username");
	%>
    <style>
        /* Estilos para el cuerpo */
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        /* Estilos para el header */
        header {
       		overflow: visible; /* Updated overflow property */
        	background: #252932;
    	}

    	.cabeza {
        	width: 90%;
        	max-width: 1000px;
        	margin: auto;
        	overflow: hidden;
        	display: flex; /* Added flexbox layout */
        	justify-content: space-between; /* Added alignment */
    	}

    	header nav {
        	line-height: 100px; /* Ajuste de altura para alinear verticalmente */
    	}

    	header nav a {
        	display: inline-block;
        	color: #fff;
        	text-decoration: none;
        	padding: 10px 20px;
        	font-size: 20px;
        	font-weight: bold;
        	transition: all 500ms ease;
    	}

    	header nav a:hover {
        	background: #3498db;
        	border-radius: 50px;
    	}
		.user-info {
        	display: flex;
        	align-items: center;
    	}

    	.username {
        	margin-right: 10px;
        	color: #fff;
        	font-weight: bold;
    	}

    	.logout-btn {
        	background: #3498db;
        	color: #fff;
        	border: none;
        	padding: 8px 16px;
        	border-radius: 5px;
        	font-weight: bold;
        	cursor: pointer;
        	transition: all 500ms ease;
    	}

    	.logout-btn:hover {
        	background: #2980b9;
    	}
        /* Estilos para la lista de botones */
        .button-list {
            padding: 0;
            list-style: none;
            display: flex;
            justify-content: center; /* Centrar horizontalmente */
            flex-wrap: wrap; /* Envolver botones si no caben en una línea */
        }

        .button-list li {
            margin: 10px; /* Espacio entre los botones */
        }

        /* Estilos para los botones */
        .button-list button {
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            background-color: #3498db;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .button-list button:hover {
            background-color: #2980b9;
        }
        /* Estilo del logo */
        img {
        float: left;
        max-width: 7%;
        max-height: 7%;
        border-radius: 100%;
        margin: 0;
        padding: 50px 30px;
    }
    </style>
</head>


<body>
 <header>
    <img class="img" src="https://th.bing.com/th/id/OIG.v9PDr7.iF6NWxCW85XcO?w=1024&amp;h=1024&amp;rs=1&amp;pid=ImgDetMain" alt="Un logo de un kiosco virtual extremadamente minimalista con colores celeste y azul oscuro">
    <div class="cabeza">
        <nav>
            <a href="#">Inicio</a>
            <a href="#">Título...</a>
        </nav>
        <div class="user-info">
            <span class="username"><%= username %></span>
            <form action="logout">
                <button class="logout-btn">Logout</button>
            </form>
        </div>
    </div>
</header>

<h1>Listado de Proveedores</h1>
	<button class="add-provider-btn" onclick="window.location.href='registrarProveedor.jsp'">Añadir un proveedor</button>
    <table border="1">
        <thead>
            <tr>
                <th>DNI</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Telefono</th>
                <th>Direccion</th>
                <th>Correo Electronico</th>
                
            </tr>
        </thead>
        <tbody>
            <% 
                LinkedList<Proveedor> listaProveedores = (LinkedList<Proveedor>) request.getAttribute("listaProveedores");
                for (Proveedor proveedor : listaProveedores) {
            %>
            <tr>
                <td><%= proveedor.getDni() %></td>
                <td><%= proveedor.getNombre() %></td>
                <td><%= proveedor.getApellido() %></td>
                <td><%= proveedor.getTelefono() %></td>
                <td><%= proveedor.getDireccion() %></td>
                <td><%= proveedor.getMail() %></td>
                <td><button>Modificar</button></td>
                <td>
    				<form action="ServletBorrarProveedor" method="post">
        				<button name="dniProveedor" value="<%= proveedor.getDni()%>">Borrar</button>
    				</form>
				</td>
            </tr>
            <% } %>
        </tbody>
    </table>




</body>
</html>