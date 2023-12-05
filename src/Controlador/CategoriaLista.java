package Controlador;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Categoria;
import Logicas.*;

/**
 * Servlet implementation class CategoriaLista
 */
@WebServlet({ "/CategoriaLista", "/categorialista" })
public class CategoriaLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaLista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LogCategoria lc = new LogCategoria();
		
		LinkedList<Categoria> categorias =  lc.getAll();
		request.setAttribute("listaCategoria", categorias);
		request.getRequestDispatcher("WEB-INF/lista.jsp").forward(request, response);
		response.getWriter().append("Bienvenido");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Categoria nuevacategoria = new Categoria();
		LogCategoria lc = new LogCategoria();
		int codigo  = Integer.parseInt(request.getParameter("codCat"));
		String desc = request.getParameter("descripcion");
		
		nuevacategoria.setCodCat(codigo);
		nuevacategoria.setDescripcion(desc);
		lc.add(nuevacategoria);
		request.getRequestDispatcher("Inicio.html").forward(request, response);
	}

}
