<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidades.Cliente"%>
<%@ page import="Entidades.Producto"%>
<%@ page import="Entidades.Carrito"%>
<%@ page import="java.util.LinkedList"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pagina Inicial de Cliente</title>
    <%
    	if(session.getAttribute("username")==null){
    		response.sendRedirect("login.jsp");
    	}
    	%>    
	<%
		
		String username = (String)session.getAttribute("username");
		LinkedList<Producto> lp = (LinkedList<Producto>)request.getAttribute("listaProductos");
		
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
        width: 100%;
        max-width: 1000px;
        margin: auto;
        overflow: hidden;
        display: flex; /* Added flexbox layout */
        align-items: center; /* Added alignment */
        justify-content: space-between; /* Added alignment */
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
    /* Estilo del logo */
    img {
        float: left;
        max-width: 7%;
        max-height: 7%;
        border-radius: 100%;
        margin: 0;
        padding: 10px 5px;
    }

	.carrito {
	    background: #3498db;
        color: #fff;
        border: none;
        padding: 8px 16px;
        border-radius: 5px;
        font-weight: bold;
        cursor: pointer;
        transition: all 500ms ease;
            }
	
	.carrito:hover {
		background: #2980b9;        
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
        border: 3px solid #000000;
        padding: 10px;
        text-align: center;
    }
    
    .search-input {
        background: #3498db;
        color: #fff;
        border: solid;
        display: inline-block;
        justify-content: center;
        padding: 8px 16px;
        border-radius: 5px;
        font-weight: bold;
        cursor: pointer;
        width: 20%;
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
    
    .btn-submit {
        background: #3498db;
        color: #fff;
        border: none;
        padding: 8px 16px;
        border-radius: 5px;
        font-weight: bold;
        cursor: pointer;
        transition: all 500ms ease;
    }
    
    .btn-submit:hover {
        background: #2980b9;
    }
    
    main {
        margin-top: 50px;
        
        margin-right: 20px;
        margin-left: 20px;
    }
    
    label {
    color: orange;
    font-family: "Roboto Condensed", sans-serif;
    font-size: 18px;
  }
</style> 
<script>
    // Check if the cart is empty
    <% 
    Boolean carritoVacio = (Boolean) request.getAttribute("carritoVacio");
    if (carritoVacio != null && carritoVacio) { 
    %>
        alert("El carrito está vacío");
    <% } %>
</script>
</head>   
<body>
    <header>
    <img class="img" src="IMAGES/KioscoVirtual.png" alt="Un logo de un kiosco virtual extremadamente minimalista con colores celeste y azul oscuro">
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
                <button class="logout-btn">Salir</button>
            </form>
        </div>
    </div>
	</header>
    <main>
    	<br>
    	<br>
    	<label for="search-input" class="search-label">Busca un producto:</label>
        <form action=ServletBuscar method="get">
        	<input type="text" name="busqueda" id="search-input" class="search-input" style="width: 50%;">
        	<br>
        	<label for="categoria">Categoria:</label> 
        		<select name="categoria">
					<option value="1">Almacen</option>
					<option value="2">Bebidas</option>
					<option value="3">Golosinas</option>
				</select>
			<br>
			<label for="ordenar">Ordenar por:</label>
			<select name="ordenar">
					<option value="preciomax">Precio Maximo</option>
					<option value="preciomin">Precio Minimo</option>
			</select>
				<input type="submit" name="action" value="buscar"
				class="search-input">
		</form>
        <div class="product-gallery">
        <% for (Producto prod : lp) { %>
        <div class="product-card">        
            <div class="product-card-content">
                <img src="https://example.com/product1.jpg" alt="Product 1">
                <form action="ServletCarrito" method="POST">
               	<h2><%=prod.getNombre()%></h2>
                <p><%=prod.getDescripcion()%></p>
                <span>$<%=prod.getPrecioBase()%></span>
                <span>Stock: <%=prod.getStock()%></span>
                <br>
                <label for="cantidad">Cantidad:</label>
        		<input type="number" id="cantidad" name="cantidad" min="1" max="<%=prod.getStock()%>" required>
				<input type="hidden" name="codProducto" value="<%=prod.getCodProd()%>">	
				<input class="btn-submit" type="submit" name="action" value="Agregar Producto">
				</form>
            </div>
        </div>
        <% } %>

        <!-- Add more product cards here -->
    </div>
    </main>
</body>
</html>   