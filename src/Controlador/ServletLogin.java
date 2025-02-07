package Controlador;
import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TryCatchFinally;

import Logicas.LogicCliente;
import Logicas.LogicProducto;
import Entidades.Cliente;
import Entidades.Producto;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		LogicCliente cliLogic = new LogicCliente();
		LogicProducto proLogic = new LogicProducto();
		LinkedList<Producto> productos = proLogic.getAll();
		
		try {
			Cliente user = cliLogic.verifyExist(uname);
			
			if (user == null) {
				String errorMessage = "Usuario no encontrado.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
			}
			
			boolean verificacion = cliLogic.verifyPass(user, pass);
			System.out.println("Verificación de contraseña: " + verificacion);
			if (!verificacion) {
				String errorMessage = "Contraseña incorrecta.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
			}
			
			if (user.getEsAdmin() == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				request.setAttribute("listaProductos", productos);
				request.getRequestDispatcher("mainCliente.jsp").forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				request.setAttribute("listaProductos", productos);
				request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// Capturar cualquier excepción inesperada
            String errorMessage = "Ocurrió un error inesperado. Por favor, inténtalo de nuevo más tarde.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}

