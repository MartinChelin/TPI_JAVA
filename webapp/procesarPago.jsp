<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Procesar Pago</title>
</head>
<body>
    <h1>Procesando el Pago</h1>
    <%
        String metodoPago = request.getParameter("metodoPago");
        if ("efectivo".equals(metodoPago)) {
            out.println("<p>El pago en efectivo fue seleccionado. Generaremos un recibo.</p>");
        } else if ("transferencia".equals(metodoPago)) {
            String banco = request.getParameter("banco");
            String nroCuenta = request.getParameter("nroCuenta");
            out.println("<p>Transferencia seleccionada.</p>");
            out.println("<p>Banco: " + banco + "</p>");
            out.println("<p>Número de cuenta: " + nroCuenta + "</p>");
        } else if ("debito".equals(metodoPago)) {
            String tarjeta = request.getParameter("tarjeta");
            String vencimiento = request.getParameter("vencimiento");
            out.println("<p>Pago con Débito seleccionado.</p>");
            out.println("<p>Número de tarjeta: " + tarjeta + "</p>");
            out.println("<p>Fecha de vencimiento: " + vencimiento + "</p>");
        } else {
            out.println("<p>No se seleccionó ningún método de pago válido.</p>");
        }
    %>
</body>
</html>
