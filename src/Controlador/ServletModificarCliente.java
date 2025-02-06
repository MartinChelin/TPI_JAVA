package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataCliente;
import Entidades.Cliente;

@WebServlet("/ServletModificarCliente")
public class ServletModificarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletModificarCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuarioCliente = request.getParameter("usuarioCliente");
		Cliente cli = DataCliente.searchByUsername(usuarioCliente);
		int rolDeseado = (cli.getEsAdmin() == 0) ? 1 : 0;
		
		DataCliente.updateRolCliente(cli.getDniCliente(), rolDeseado);
		
		request.getRequestDispatcher("/mainAdmin.jsp").forward(request, response);
	}

}
