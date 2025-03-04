<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seleccionar Método de Pago</title>
    <style>
        /* Estilos globales */
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        /* Estilos para el header */
        header {
            overflow: visible;
            background: #252932;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
        }

        .cabeza {
            width: 100%;
            max-width: 1000px;
            margin: auto;
            overflow: hidden;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        header nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        header nav form {
            display: flex;
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

        .carrito {
            background: #3498db;
            margin-left: 10px;
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

        img {
            float: left;
            max-width: 7%;
            max-height: 7%;
            border-radius: 100%;
            margin: 0;
            padding: 10px 5px;
        }

        /* Estilos para el usuario */
        .user-info {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
        }

        .username {
            color: #fff;
            font-weight: bold;
            padding: 8px 16px;
        }

        .logout-btn {
            display: flex;
            justify-items: center;
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
        /* Estilos para el contenido */
        main {
            margin-top: 50px;
            margin-right: 20px;
            margin-left: 20px;
        }

        .form-container {
            text-align: center;
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        form {
            margin-bottom: 20px;
        }

        label {
            font-size: 16px;
            color: #555;
            margin-bottom: 5px;
            display: block;
        }

        select, input, button {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
            box-sizing: border-box;
        }

        button {
            background-color: #3498db;
            color: white;
            cursor: pointer;
            border: none;
        }

        button:hover {
            background-color: #2980b9;
        }

        .payment-info {
            margin-top: 20px;
        }

        .payment-info h3 {
            color: #333;
        }

        .payment-info p {
            font-size: 14px;
            color: #666;
        }
    </style>
</head>
<body>
    <header>
        <img src="https://th.bing.com/th/id/OIG.v9PDr7.iF6NWxCW85XcO?w=1024&amp;h=1024&amp;rs=1&amp;pid=ImgDetMain" 
             alt="Un logo de un kiosco virtual extremadamente minimalista con colores celeste y azul oscuro">
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
                <span class="username"><%= session.getAttribute("username") %></span>
                <form action="logout">
                    <button class="logout-btn">Logout</button>
                </form>
            </div>
        </div>
    </header>

    <main>
        <div class="form-container">
            <h1>Seleccionar Método de Pago</h1>
            <form action="seleccionarPago.jsp" method="post">
                <label for="metodoPago">Método de Pago:</label>
                <select id="metodoPago" name="metodoPago" onchange="this.form.submit()">
                    <option value="">Seleccione...</option>
                    <option value="efectivo" <%= "efectivo".equals(request.getParameter("metodoPago")) ? "selected" : "" %>>Efectivo</option>
                    <option value="transferencia" <%= "transferencia".equals(request.getParameter("metodoPago")) ? "selected" : "" %>>Transferencia</option>
                    <option value="debito" <%= "debito".equals(request.getParameter("metodoPago")) ? "selected" : "" %>>Débito</option>
                </select>
            </form>

            <%
                String metodoPago = request.getParameter("metodoPago");
                if (metodoPago != null) {
                    if (metodoPago.equals("efectivo")) {
            %>
                <div class="payment-info">
                    <h3>Pago en Efectivo</h3>
                    <form action="ServletProcesarPagoEfectivo" method="post">
                        <p>Se le entregara el correspondiente recibo al momento de efectuar el pago</p>
                        <button type="submit" class="carrito">Confirmar Pago</button>
                    </form>
                </div>
            <%
                    } else if (metodoPago.equals("transferencia")) {
            %>
                <div class="payment-info">
                    <h3>Pago por Transferencia (Solo para retiros en el local)</h3>
                   <form action="ServletProcesarPagoTransferencia" method="post">
                   		<p>CVU/CBU: 023021932103910</p>
                        <p>Alias: kioskoonline123</p>
    				<label for="metodoEntrega">Método de entrega:</label>
   	 				<select name="metodoEntrega" id="metodoEntrega">
        			<option value="local">Retiro en el local</option>
    				</select>
    					<button type="submit">Confirmar Pago</button>
    					<% if (request.getAttribute("errorMensaje") != null) { %>
        				<p style="color: red;"><%= request.getAttribute("errorMensaje") %></p>
    					<% } %>
					</form>

                </div>
            <%
                    } else if (metodoPago.equals("debito")) {
            %>
                <div class="payment-info">
                    <h3>Pago con Débito</h3>
                    <form action="ServletProcesarPagoDebito" method="post">
                        <label for="tarjeta">Número de Tarjeta:</label>
                        <input type="text" id="tarjeta" name="tarjeta" placeholder="Ingrese el número de tarjeta" pattern="\d{16}" title="El número de tarjeta debe tener exactamente 16 dígitos" required>
                        <label for="vencimiento">Fecha de Vencimiento:</label>
                        <%
                        LocalDate today = LocalDate.now();
                        String minDate = today.format(DateTimeFormatter.ofPattern("yyyy-MM"));
                        %>
                        <input type="month" id="vencimiento" name="vencimiento" min="<%= minDate %>" required>
                        <label for="cvv">CVV:</label>
                        <input type="text" id="cvv" name="cvv" placeholder="Ingrese el CVV" pattern="\d{3,4}" title="El CVV debe tener 3/4 dígitos" required>
                        <button type="submit" class="carrito">Confirmar Pago</button>
                    </form>
                </div>
            <%
                    }
                }
            %>
        </div>
    </main>
</body>
</html>