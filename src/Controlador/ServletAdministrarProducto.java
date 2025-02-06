package Controlador;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Categoria;
import Entidades.Producto;
import Logicas.*;

/**
 * Servlet implementation class ServletAdministrarProducto
 */
@WebServlet("/ServletAdministrarProducto")
public class ServletAdministrarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdministrarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LogicProducto lp = new LogicProducto();
		
		LinkedList<Producto> productos =  lp.getAll();
		request.setAttribute("listaProductos", productos);
		request.getRequestDispatcher("administrarProductos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Producto nuevaproducto = new Producto();
		LogicProducto lp = new LogicProducto();
		int codigo  = Integer.parseInt(request.getParameter("codProd"));
		String nom = request.getParameter("nombre");
		String desc = request.getParameter("descripcion");
		int s = Integer.parseInt(request.getParameter("stock"));
		double precio = Double.parseDouble(request.getParameter("precioBase"));
		LogicCategoria lc = new LogicCategoria();
		Categoria c = lc.getOne(Integer.parseInt(request.getParameter("codCat")));
		nuevaproducto.setCodProd(codigo);
		nuevaproducto.setNombre(nom);
		nuevaproducto.setDescripcion(desc);
		nuevaproducto.setStock(s);
		nuevaproducto.setPrecioBase(precio);
		nuevaproducto.setCat(c);
		lp.add(nuevaproducto);
		LinkedList<Producto> productos =  lp.getAll();
		request.setAttribute("listaProductos", productos);
		request.getRequestDispatcher("administrarProductos.jsp").forward(request, response);
	}

}
