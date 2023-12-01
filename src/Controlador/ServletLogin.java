package Controlador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Data.ClienteData;
import Logicas.ClienteLogic;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		ClienteLogic cliLogic = new ClienteLogic();
		boolean verificacion = cliLogic.VerifyUser(uname, pass);
		
		//if (uname.equals("admin") && pass.equals("admin"))
		if (verificacion == true)
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("main.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

}
