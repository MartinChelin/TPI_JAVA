package Controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Categoria;
import Entidades.Producto;
import Entidades.ValorHistorico;
import Logicas.*;
import Data.*;

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
		LogicCategoria lc = new LogicCategoria();
		
		LinkedList<Producto> productos =  lp.getAll();
		LinkedList<Categoria> categorias =  lc.getAll();
		
		request.setAttribute("listaProductos", productos);
		request.setAttribute("listaCategorias", categorias);
		
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
		
		int codCat = Integer.parseInt(request.getParameter("codCat"));
		LogicCategoria lc = new LogicCategoria();
		Categoria c = lc.getOne(codCat);
		
		nuevaproducto.setCodProd(codigo);
		nuevaproducto.setNombre(nom);
		nuevaproducto.setDescripcion(desc);
		nuevaproducto.setStock(s);
		nuevaproducto.setPrecioBase(precio);
		nuevaproducto.setCat(c);
		lp.add(nuevaproducto);
		LinkedList<Producto> productos =  lp.getAll();
		LinkedList<Categoria> categorias=  lc.getAll();
		
		//Logica para guardar el nuevo Valor Historico
		ValorHistorico vh = new ValorHistorico();
		vh.setCodProductoVH(codigo);
		vh.setValor(precio);
		LocalDate fechaActual = LocalDate.now();
		vh.setFechaDesde(fechaActual);
		DataValorHistorico dvh = new DataValorHistorico();
		dvh.addVH(vh);
		
		request.setAttribute("listaProductos", productos);
		request.setAttribute("listaCategorias", categorias);
		request.getRequestDispatcher("administrarProductos.jsp").forward(request, response);
	}

}
