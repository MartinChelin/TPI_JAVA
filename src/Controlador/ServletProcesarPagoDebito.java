package Controlador;

import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet para procesar el pago con tarjeta de débito.
 */
@WebServlet("/ServletProcesarPagoDebito")
public class ServletProcesarPagoDebito extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletProcesarPagoDebito() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nroTarjeta = request.getParameter("tarjeta");
        String cvv = request.getParameter("cvv");
        String vencimiento = request.getParameter("vencimiento");

        response.setContentType("text/html; charset=UTF-8");

        try {
            // Parsear la fecha en formato MM/yy
            YearMonth fechaIngresada = YearMonth.parse(vencimiento, DateTimeFormatter.ofPattern("MM/yy"));
            YearMonth fechaActual = YearMonth.now();

            // Validación de los datos de la tarjeta
            if (nroTarjeta.matches("\\d{16}") && cvv.matches("\\d{3,4}") && !fechaIngresada.isBefore(fechaActual)) {
                request.getRequestDispatcher("seleccionarTipoEntrega.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMensaje", "Tarjeta ingresada incorrectamente");
                RequestDispatcher dispatcher = request.getRequestDispatcher("seleccionarTipoEntrega.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMensaje", "Formato de fecha incorrecto. Use MM/yy.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("seleccionarTipoEntrega.jsp");
            dispatcher.forward(request, response);
        }
    }
}