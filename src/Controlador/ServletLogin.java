package Controlador;
import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Logicas.ClienteLogic;
import Logicas.LogProducto;
import Entidades.Cliente;
import Entidades.Producto;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		ClienteLogic cliLogic = new ClienteLogic();
		LogProducto proLogic = new LogProducto();
		LinkedList<Producto> productos = proLogic.getAll();
		Cliente user = cliLogic.verifyExist(uname);
		
		if (user != null){
			boolean verificacion = cliLogic.verifyPass(user, pass);
			if (verificacion == true) {
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
			}
			///Falta cartel de error de contraseña incorrecta
		} 
		else {
			///Falta cartel de usuario no encontrado
			response.sendRedirect("login.jsp");
		}
	}
}

