package Controlador;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataCategoria;
import Entidades.Categoria;

@WebServlet("/ServletAdministrarCategoria")
public class ServletAdministrarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAdministrarCategoria() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
		LinkedList<Categoria> listaCategorias = DataCategoria.getAll();
		request.setAttribute("listaCategorias", listaCategorias);
		
		request.getRequestDispatcher("/administrarCategorias.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int codCategoria = Integer.valueOf(request.getParameter("codCategoria"));
		request.setAttribute("codCategoria", codCategoria);
		request.getRequestDispatcher("/modificarCategoria.jsp").forward(request, response);
		doGet(request, response);
	}

}
