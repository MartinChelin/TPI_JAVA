package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataProveedor;

@WebServlet("/ServletBorrarProveedor")
public class ServletBorrarProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletBorrarProveedor() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dniProveedor = request.getParameter("dniProveedor");
		
		DataProveedor.deleteProveedor(dniProveedor);
		
		request.getRequestDispatcher("/mainAdmin.jsp").forward(request, response);
		
	}

}
