package Controlador;

import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletProcesarPagoDebito
 */
@WebServlet("/ServletProcesarPagoDebito")
public class ServletProcesarPagoDebito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProcesarPagoDebito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nroTarjeta = request.getParameter("tarjeta");
        String cvv = request.getParameter("cvv");
        String vencimiento = request.getParameter("vencimiento");
        // Parsear el vencimiento ingresado como YearMonth
        YearMonth fechaIngresada = YearMonth.parse(vencimiento, DateTimeFormatter.ofPattern("yyyy-MM"));
        // Obtener el mes y año actuales
        YearMonth fechaActual = YearMonth.now();
        String mensaje; 
        
        if (nroTarjeta.length() == 16 && nroTarjeta.matches("\\d{16}") && (cvv.length() == 3 || cvv.length() == 4) && cvv.matches("\\d{3,4}") && !fechaIngresada.isBefore(fechaActual) ){
        	request.getRequestDispatcher("seleccionarTipoEntrega.jsp").forward(request, response);

        }else{
        	mensaje = "Tarjeta ingresada incorrectamente";
        	response.getWriter().write(mensaje);
        }
	}

}
