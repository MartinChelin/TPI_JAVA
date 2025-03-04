package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet para procesar el pago mediante transferencia bancaria.
 */
@WebServlet("/ServletProcesarPagoTransferencia")
public class ServletProcesarPagoTransferencia extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ServletProcesarPagoTransferencia() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String metodoEntrega = request.getParameter("metodoEntrega");
        
        response.setContentType("text/html; charset=UTF-8");
        
        // Verificar que la única opción permitida sea "retiro en local"
        if ("local".equalsIgnoreCase(metodoEntrega)) {
            request.getRequestDispatcher("confirmarPago.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMensaje", "La transferencia solo está permitida con retiro en el local.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("pago.jsp");
            dispatcher.forward(request, response);
        }
    }
}
