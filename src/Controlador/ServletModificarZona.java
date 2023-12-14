package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataZona;
import Entidades.Zona;

@WebServlet("/ServletModificarZona")
public class ServletModificarZona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletModificarZona() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codZona = Integer.valueOf(request.getParameter("codZona"));
		Zona zona = DataZona.searchByCod(codZona);
		String descripcion = request.getParameter("descripcion"); 
		
		DataZona.updateZona(zona.getCodZona(), descripcion);
		
		request.getRequestDispatcher("/mainAdmin.jsp").forward(request, response);
	}

}