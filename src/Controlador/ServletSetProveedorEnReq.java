package Controlador;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Data.ProveedorData;
import Entidades.Proveedor;

@WebServlet("/ServletSetProveedorEnReq")
public class ServletSetProveedorEnReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletSetProveedorEnReq() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		LinkedList<Proveedor> listaProveedores = ProveedorData.getAll();
		request.setAttribute("listaProveedores", listaProveedores);
		
		request.getRequestDispatcher("/controlProveedores.jsp").forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}