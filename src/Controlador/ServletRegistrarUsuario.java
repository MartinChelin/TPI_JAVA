package Controlador;
import Logicas.LogicCliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletRegistrarUsuario")
public class ServletRegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String runame = request.getParameter("runame");
		String rpass = request.getParameter("rpass");
		response.sendRedirect("login.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LogicCliente newCliente = new LogicCliente();
        String usuario = request.getParameter("usuario");
        String dniCliente = request.getParameter("dniCliente");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechaNac = request.getParameter("fechaNac");

        newCliente.addNewCliente(dniCliente, nombre, apellido, mail, fechaNac, usuario, password, 0 ,0);
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

}
