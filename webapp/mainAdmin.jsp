<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidades.Cliente"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Pagina Inicial de Admin</title>
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
        	max-width: 1000px;
        	margin: auto;
        	overflow: hidden;
        	display: flex; /* Added flexbox layout */
        	justify-content: space-between; /* Added alignment */
        	align-items: center; /* Added alignment */

    	}

    	header nav {
        	display: flex; /* Added flexbox layout */
        	justify-content: space-between; /* Added alignment */
        	align-items: center; /* Added alignment */
    	}

    	header nav a {
        	display: flex; /* Added flexbox layout */
        	justify-content: space-between; /* Added alignment */
        	flex-direction: row; /* Added alignment */
        	color: #fff;
        	text-decoration: none;
        	padding: 10px 20px;
        	font-family: Calibri, sans-serif;
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
            flex-wrap: wrap; /* Envolver botones si no caben en una l�nea */
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
        padding: 10px 5px;
    }
    </style>
</head>
<body>
    <header>
    <img class="img" src="https://th.bing.com/th/id/OIG.v9PDr7.iF6NWxCW85XcO?w=1024&amp;h=1024&amp;rs=1&amp;pid=ImgDetMain" alt="Un logo de un kiosco virtual extremadamente minimalista con colores celeste y azul oscuro">
    <div class="cabeza">
        <nav>
            <form action="ServletHeader" method="POST">
        		<button type="submit" name="action" value="inicio" class="carrito">Inicio</button>
        	</form>
            <form action="ServletHeader" method="POST">
            	<button type="submit" name="action" value="carrito" class="carrito">Ver Carrito</button>
            </form>
        </nav>
        <div class="user-info">
            <span class="username"><%= username %></span>
            <form action="logout">
                <button class="logout-btn">Logout</button>
            </form>
        </div>
    </div>
	</header>
    <div>
        <ul class="button-list">
            <li><form action="ServletAdministrarCliente" method="get"><button>Clientes</button></form></li>
            <li><form action="ServletAdministrarProducto" method="get"><button>Productos</button></form></li>
            <li><form action="ServletAdministrarCategoria" method="get"><button>Categoria</button></form></li>
            <li><form action="ServletAdministrarProveedor" method="get"><button>Proveedores</button></form></li>
            <li><button>Historial de valores</button></li>
            <li><button>Repartidores</button></li>
            <li><form action="ServletAdministrarZona" method="get"><button>Zonas</button></form></li>
            <li><button>Reclamos</button></li>
        </ul>
    </div>
</body>
</html>