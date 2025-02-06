package Controlador;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entidades.Carrito;
import Entidades.Cliente;
import Entidades.Producto;
import Logicas.LogicCliente;
import Logicas.LogicProducto;

/**
 * Servlet implementation class ServletHeader
 */
@WebServlet("/ServletHeader")
public class ServletHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHeader() {
        super();
        // TODO Auto-generated constructor stub
    }
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String uname = (String) request.getSession().getAttribute("username");
		LogicCliente cliLogic = new LogicCliente();
		Cliente elCliente = cliLogic.getClienteByUser(uname);
		LogicProducto proLogic = new LogicProducto();
		LinkedList<Producto> productos = proLogic.getAll();
		switch (action) {
		case "logout":
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");
			break;
		case "inicio" :
            if (elCliente.getEsAdmin() == 0) {
            	request.setAttribute("listaProductos", productos);
                request.getRequestDispatcher("mainCliente.jsp").forward(request, response);
            }
            else {
            	request.setAttribute("listaProductos", productos);
                response.sendRedirect("mainAdmin.jsp");
            }
            break;
		case "carrito":
			 HttpSession session = request.getSession();
			    LinkedList<Carrito> listaCarrito = (LinkedList<Carrito>) session.getAttribute("listaCarrito");
			    if (listaCarrito == null || listaCarrito.isEmpty()) {
			        // Add an attribute to trigger the empty cart message
			        request.setAttribute("carritoVacio", true);
			        request.setAttribute("listaProductos", proLogic.getAll());
			        request.getRequestDispatcher("mainCliente.jsp").forward(request, response);
			        return;
			    }
			    double totalPagar=0.0;
			    for (int i=0; i<listaCarrito.size();i++) {
			        totalPagar=totalPagar+listaCarrito.get(i).getSubtotal();
			    }
			    session.setAttribute("totalPagar", totalPagar);
			    request.getRequestDispatcher("carrito.jsp").forward(request, response);
			    break;
		}
    }
}
