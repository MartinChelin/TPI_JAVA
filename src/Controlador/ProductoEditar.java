package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Categoria;
import Entidades.Producto;
import Logicas.*;

/**
 * Servlet implementation class ProductoEditar
 */
@WebServlet({ "/ProductoEditar", "/productoeditar", "/Productoeditar", "/productoEditar" })
public class ProductoEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Producto prodedit = new Producto();
		LogProducto control = new LogProducto();
		int codigo = Integer.parseInt(request.getParameter("CodProd"));
		prodedit = control.getOne(codigo);
		request.setAttribute("prodedit", prodedit);
		request.getRequestDispatcher("WEB-INF/FormularioEditProd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cod = Integer.parseInt(request.getParameter("codProd"));
		String nom = request.getParameter("nombre");
		String desc = request.getParameter("descripcion");
		int stock = Integer.parseInt(request.getParameter("stock"));
		double pbase = Double.parseDouble(request.getParameter("precioBase"));
		LogCategoria control = new LogCategoria();
		Categoria cate = control.getOne(Integer.parseInt((request.getParameter("codCat"))));
		Producto prod = new Producto();
		prod.setCodProd(cod);
		prod.setNombre(nom);
		prod.setDescripcion(desc);
		prod.setStock(stock);
		prod.setPrecioBase(pbase);
		prod.setCat(cate);
		LogProducto controlp = new LogProducto();
		controlp.update(prod);
		request.getRequestDispatcher("Inicio.html").forward(request, response);
	}

}
