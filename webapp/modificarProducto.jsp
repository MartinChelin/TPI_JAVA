<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidades.Producto" %>
    <%@ page import="Entidades.Categoria" %>
    <%@ page import="java.util.LinkedList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
Producto pe = (Producto)request.getAttribute("prodedit");
String username = (String)session.getAttribute("username");
%>
<% 
LinkedList<Categoria> lc = (LinkedList<Categoria>)request.getAttribute("listaCategorias");
%>
<title>Editar Producto:</title>
</head>
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
            <a href="mainAdmin.jsp">Inicio</a>
        </nav>
        <div class="user-info">
            <span class="username"><%= username %></span>
            <form action="logout">
                <button class="logout-btn">Logout</button>
            </form>
        </div>
    </div>
	</header>
	<main>
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
	<form action="ServletModificarProducto" method="POST">
	<input type="hidden" name="codProd" value="<%=pe.getCodProd()%>">
	<input type="text" name="nombre" placeholder="Ingrese nombre del producto">
	<input type="text" name="descripcion" placeholder="Ingrese descripcion del producto">
	<input type="text" name="stock" placeholder="Ingrese stock del producto">
	<input type="text" name="precioBase" placeholder="Ingrese precio del producto">
	<select id="opciones" name="codCat">
    	<option>Elegir Categoria</option>
    	<% for (Categoria cat : lc) { %>
        <option value="<%=cat.getCodCat()%>"> <%= cat.getDescripcion() %></option>
    	<%}%>
	</select>
	
	
	
	<input type="submit" value="Confirmar cambios">
	</form>
</div>
	</main>
</body>
</html>