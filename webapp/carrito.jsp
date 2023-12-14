<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidades.Cliente"%>
<%@ page import="Entidades.Carrito"%>
<%@ page import="java.util.LinkedList"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrito</title>
    <%
    	if(session.getAttribute("username")==null){
    		response.sendRedirect("login.jsp");
    	}
    %>    
    <%
		
		String username = (String)session.getAttribute("username");
		LinkedList<Carrito> lc = (LinkedList<Carrito>)request.getAttribute("carrito");
		
	%>
<style>
    /* Estilos para el cuerpo */
    table {
    border-collapse: collapse;
    border: 2px solid black;
    text-align: center;
  	}

  	th, td {
    	border: 2px solid black;
    	padding: 5px;
  	}
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
    /* Estilo del logo */
    img {
        float: left;
        max-width: 7%;
        max-height: 7%;
        border-radius: 100%;
        margin: 0;
        padding: 50px 30px;
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

    .search-label {
    	text-align: center;
  		float: center;
    	font-family: Luminari, fantasy; 
        margin-top: 20px;
    }
     /* CSS styles for the product gallery */
    .product-gallery {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        gap: 20px;
        margin-top: 20px;
    }

    .product-card {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }
    
    .search-input {
        background: #3498db;
        color: #fff;
        border: none;
        padding: 8px 16px;
        border-radius: 5px;
        font-weight: bold;
        cursor: pointer;
        width: 100%;
        transition: all 500ms ease;
        box-sizing: border-box;
    }

    .search-input:hover {
        background: #2980b9;
    }

    .product-card-content {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .product-card-content img {
        max-width: 100%;
        max-height: 100%;
        border-radius: 5px;
        margin-bottom: 10px;
    }

    .product-card-content h2 {
        font-size: 18px;
        margin-bottom: 5px;
    }

    .product-card-content p {
        font-size: 14px;
        color: #555;
    }

    .product-card-content span {
        font-size: 16px;
        font-weight: bold;
        color: #333;
    }
    
    /* Estilos para el carrito */
    .cart {
        position: fixed;
        top: 130px;
        right: 0;
        width: 300px;
        height: 100vh;
        background-color: #f2f2f2;
        padding: 20px;
        box-sizing: border-box;
        overflow-y: auto;
    }

    .cart-item {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 10px;
    }

    .cart-item img {
        max-width: 50px;
        max-height: 50px;
        border-radius: 5px;
        margin-right: 10px;
    }

    .cart-subtotal {
        font-size: 18px;
        font-weight: bold;
        margin-top: 20px;
    }
    
    main {
        margin-top: 50px;
        margin-right: 20px;
        margin-left: 20px;
    }
    
    label {
    color: orange;
    font-family: "Roboto Condensed", sans-serif;
    font-size: 12px;
  }
</style>    
<body>
    <header>
    <img class="img" src="https://th.bing.com/th/id/OIG.v9PDr7.iF6NWxCW85XcO?w=1024&amp;h=1024&amp;rs=1&amp;pid=ImgDetMain" alt="Un logo de un kiosco virtual extremadamente minimalista con colores celeste y azul oscuro">
    <div class="cabeza">
        <nav>
            <a href="ServletCarrito?accion=default">Inicio</a>
            <a href="#">T�tulo...</a>
            <a href="carrito.jsp">(<label class="label">contador</label>) Ver Carrito</a>
        </nav>
        <div class="user-info">
            <span class="username"><%= username %></span>
            <form action="logout">
                <button class="logout-btn">Logout</button>
            </form>
        </div>
    </div>
	</header>
<body>
	<h1>Carrito de compra</h1>
		<table>
			<thead>
				<tr>
					<th>ITEM</th>
					<th>NOMBRE</th>
					<th>DESCRIPCION</th>
					<th>PRECIO</th>
					<th>CANTIDAD</th>
					<th>SUBTOTAL</th>
				</tr>
			</thead>
			<tbody>
			<% for (Carrito prod : lc) { %>
				<tr>
					<td><%=prod.getItem()%></td>
					<td><%=prod.getNombre() %></td>
					<td><%=prod.getDescripcion() %></td>
					<td><%=prod.getPrecio() %></td>
					<td><%=prod.getCantidad() %></td>
					<td><%=prod.getSubtotal() %></td>
				</tr>
			<% } %>
			</tbody>
			<tfoot>
				<tr>
					<%Double totalPagar = (Double)request.getAttribute("totalPagar"); %>
					<td>Total:<%=totalPagar%> </td> 
		</table>
</body>
</html>