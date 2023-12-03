package Controlador;


import Logicas.ProveedorLogic;
import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrarProveedor")
public class ServletRegistrarProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletRegistrarProveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProveedorLogic newProveedor = new ProveedorLogic(); 
        Integer dni = Integer.parseInt(request.getParameter("dni"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String mail = request.getParameter("mail");
        Integer telefono = Integer.parseInt(request.getParameter("telefono"));
        String direccion = request.getParameter("direccion");
		
        try {
			newProveedor.addNewProveedor(dni, nombre, apellido, mail, telefono, direccion);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        response.getWriter().append("Carga Completa").append(request.getContextPath());
	}

}
