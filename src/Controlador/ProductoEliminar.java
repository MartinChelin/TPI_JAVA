package Controlador;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Producto;
import Logicas.*;

/**
 * Servlet implementation class ProductoEliminar
 */
@WebServlet({ "/ProductoEliminar", "/productoeliminar", "/Productoeliminar", "/productoEliminar" })
public class ProductoEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LogProducto control = new LogProducto();
		int idProd = Integer.parseInt(request.getParameter("CodProd"));
		control.delete(idProd);
		LinkedList<Producto> productos =  control.getAll();
		request.setAttribute("listaProductos", productos);
		request.getRequestDispatcher("listaProducto.jsp").forward(request, response);
		response.getWriter().append("Eliminado");
	}

}
