package Controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataValorHistorico;
import Entidades.Categoria;
import Entidades.Producto;
import Entidades.ValorHistorico;
import Logicas.*;

/**
 * Servlet implementation class ServletModificarProducto
 */
@WebServlet("/ServletModificarProducto")
public class ServletModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Producto prodedit = new Producto();
		LogicProducto control = new LogicProducto();
		int codigo = Integer.parseInt(request.getParameter("CodProd"));
		prodedit = control.getOne(codigo);
		request.setAttribute("prodedit", prodedit);
		LogicCategoria lc = new LogicCategoria();
		LinkedList<Categoria> categorias =  lc.getAll();
		request.setAttribute("listaCategorias", categorias);
		request.getRequestDispatcher("modificarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Me traigo el producto al cual voy a modificar
		int cod = Integer.parseInt(request.getParameter("codProd"));
		LogicProducto controlp = new LogicProducto();
		Producto productoSeleccionado = controlp.getOne(cod);
				
		String nom = request.getParameter("nombre");
		String desc = request.getParameter("descripcion");
		int stock = Integer.parseInt(request.getParameter("stock"));
		double pbase = Double.parseDouble(request.getParameter("precioBase"));
		LogicCategoria control = new LogicCategoria();
		Categoria cate = control.getOne(Integer.parseInt((request.getParameter("codCat"))));
		Producto prod = new Producto();
		prod.setCodProd(cod);
		prod.setNombre(nom);
		prod.setDescripcion(desc);
		prod.setStock(stock);
		prod.setPrecioBase(pbase);
		prod.setCat(cate);
		controlp.update(prod);
		
		LogicCategoria controlCategoria= new LogicCategoria();
		LinkedList<Categoria> categorias =  controlCategoria.getAll();
		request.setAttribute("listaCategorias", categorias);
		
		LinkedList<Producto> productos =  controlp.getAll();
		request.setAttribute("listaProductos", productos);
		
		if(productoSeleccionado.getPrecioBase() != pbase) {
			//Logica para guardar el nuevo Valor Historico
			ValorHistorico vh = new ValorHistorico();
			vh.setCodProductoVH(prod.getCodProd());
			vh.setValor(prod.getPrecioBase());
			LocalDate fechaActual = LocalDate.now();
			vh.setFechaDesde(fechaActual);
			DataValorHistorico dvh = new DataValorHistorico();
			dvh.addVH(vh);			
		}
		request.getRequestDispatcher("administrarProductos.jsp").forward(request, response);
	}

}
