package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataCliente;

@WebServlet("/ServletBorrarCliente")
public class ServletBorrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletBorrarCliente() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dniCliente = request.getParameter("dniCliente");
		
		DataCliente.deleteCliente(dniCliente);
		
		request.getRequestDispatcher("/mainAdmin.jsp").forward(request, response);
		
	}

}
