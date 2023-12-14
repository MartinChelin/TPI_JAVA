package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataCategoria;
import Entidades.Categoria;


@WebServlet("/ServletModificarCategoria")
public class ServletModificarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletModificarCategoria() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codCategoria = Integer.valueOf(request.getParameter("codCategoria"));
		Categoria categoria = DataCategoria.getOne(codCategoria);
		String descripcion = request.getParameter("descripcion"); 
		
		DataCategoria.updateCat(categoria.getCodCat(), descripcion);
		
		request.getRequestDispatcher("/mainAdmin.jsp").forward(request, response);
	}

}
