package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        HttpSession session = request.getSession();
        String tipoEntrega = (String) session.getAttribute("tipoEntrega");
        
        response.setContentType("text/html; charset=UTF-8");
        
        if (tipoEntrega == null) {
            // Si el tipo de entrega aún no ha sido seleccionado, redirigir a la página de selección
            request.setAttribute("errorMensaje", "Por favor, seleccione el tipo de entrega primero.");
            request.getRequestDispatcher("seleccionarTipoEntrega.jsp").forward(request, response);
        } else if ("local".equalsIgnoreCase(tipoEntrega)) {
            // Procesar el pago por transferencia si el tipo de entrega es "retiro en local"
            // Aquí iría la lógica para procesar el pago
            request.setAttribute("mensajeExito", "Pago por transferencia procesado correctamente. Por favor, retire su pedido en el local.");
            request.getRequestDispatcher("seleccionarPago.jsp").forward(request, response);
        } else {
            // Si el tipo de entrega no es "retiro en local", mostrar un mensaje de error
            request.setAttribute("errorMensaje", "La transferencia solo está permitida con retiro en el local.");
            request.getRequestDispatcher("seleccionarTipoEntrega.jsp").forward(request, response);
        }
    }
}