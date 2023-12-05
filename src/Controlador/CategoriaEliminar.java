package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logicas.*;

/**
 * Servlet implementation class CategoriaEliminar
 */
@WebServlet({ "/CategoriaEliminar", "/categoriaeliminar", "/categoriaEliminar", "/Categoriaeliminar" })
public class CategoriaEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaEliminar() {
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
		LogCategoria control = new LogCategoria();
		int idCat = Integer.parseInt(request.getParameter("CodCat"));
		control.delete(idCat);
		request.getRequestDispatcher("Inicio.html").forward(request, response);
		response.getWriter().append("Eliminado");
	}

}
