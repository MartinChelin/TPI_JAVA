<%@ page import="java.util.LinkedList" %>
<%@ page import="Entidades.ValorHistorico" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Histórico de Valores de Productos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f0f8ff;
            text-align: center;
        }
        h2 {
            color: #003366;
        }
        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            background: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #0073e6;
            color: white;
            text-transform: uppercase;
        }
        tr:nth-child(even) {
            background-color: #e6f2ff;
        }
        tr:hover {
            background-color: #cce5ff;
        }
        form {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

    <h2>Histórico de Valores de Productos</h2>

    <!-- Formulario de Filtrado -->
    <form action="ServletFiltrarValoresHistoricosProductos" method="GET">
        <label for="codigo">Código del Producto:</label>
        <input type="text" name="codigo" id="codigo">
        
        <label for="categoria">Categoría:</label>
        <input type="text" name="categoria" id="categoria">
        
        <button type="submit">Filtrar</button>
    </form>

    <table>
        <tr>
            <th>Código del Producto</th>
            <th>Nombre</th>
            <th>Categoria</th>
            <th>Precio</th>
            <th>Fecha Desde</th>
        </tr>
        <%
        LinkedList<ValorHistorico> listaValoresHistoricos = (LinkedList<ValorHistorico>) request.getAttribute("listaValoresHistoricos");
        if (listaValoresHistoricos != null) {
            for (ValorHistorico registro : listaValoresHistoricos) {
        %>
        <tr>
            <td><%= registro.getCodProductoVH() %></td>
            <td><%= registro.getNombreProducto() %></td>
            <td><%= registro.getDescripcion() %></td>
            <td><%= registro.getValor() %></td>
            <td><%= registro.getFechaDesde() %></td>
        </tr>
        <%
            }
        }
        %>
    </table>

</body>
</html>
