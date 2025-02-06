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

@WebServlet("/ServletModificarProveedor")
public class ServletModificarProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletModificarProveedor() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dni = Integer.valueOf(request.getParameter("dniProveedor"));
		Proveedor prov = DataProveedor.searchByDni(dni);
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String tel = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String mail = request.getParameter("mail");
		
		DataProveedor.updateProveedor(prov.getDni(), nombre, apellido, tel, direccion, mail);
		LinkedList<Proveedor> listaProveedores = DataProveedor.getAll();
		request.setAttribute("listaProveedores", listaProveedores);
		request.getRequestDispatcher("/administrarProveedores.jsp").forward(request, response);
	}

}