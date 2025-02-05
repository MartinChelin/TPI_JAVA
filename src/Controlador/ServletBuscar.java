package Controlador;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Producto;
import Logicas.LogProducto;

/**
 * Servlet implementation class ServletBuscar
 */
@WebServlet({ "/ServletBuscar", "/servletbuscar", "/servletBuscar", "/Servletbuscar" })
public class ServletBuscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBuscar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.equals("buscar")) {
			String busqueda = request.getParameter("busqueda");
			String ordenar = request.getParameter("ordenar");
			String cat = request.getParameter("categoria");
			LogProducto proLogic = new LogProducto();
			LinkedList<Producto> productosBuscados = proLogic.getProdByNom(busqueda, cat,ordenar);
			request.setAttribute("listaProductos", productosBuscados);
			request.getRequestDispatcher("mainCliente.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("mainCliente.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
