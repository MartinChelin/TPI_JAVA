package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logicas.LogCategoria;
import Entidades.Categoria;


@WebServlet("/ServletRegistrarCategoria")
public class ServletRegistrarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletRegistrarCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LogCategoria newCategoria = new LogCategoria(); 
        int codCategoria = Integer.valueOf(request.getParameter("codCategoria"));
        String descripcion = request.getParameter("descripcion");
        
        Categoria newCat = new Categoria(codCategoria,descripcion);
        
        newCategoria.add(newCat);
        
        request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
	}

}
