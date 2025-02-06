package Controlador;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Data.DataProveedor;
import Entidades.Proveedor;

@WebServlet("/ServletAdministrarProveedor")
public class ServletAdministrarProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletAdministrarProveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		LinkedList<Proveedor> listaProveedores = DataProveedor.getAll();
		request.setAttribute("listaProveedores", listaProveedores);
		
		request.getRequestDispatcher("/administrarProveedores.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dniProveedor = Integer.valueOf(request.getParameter("dniProveedor"));
		request.setAttribute("dniProveedor", dniProveedor);
		request.getRequestDispatcher("/modificarProveedor.jsp").forward(request, response);
		doGet(request, response);
	}

}