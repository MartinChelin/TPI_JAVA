package Controlador;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataZona;
import Entidades.Zona;

@WebServlet("/ServletAdministrarZona")
public class ServletAdministrarZona extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletAdministrarZona() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		LinkedList<Zona> listaZonas = DataZona.getAll();
		request.setAttribute("listaZonas", listaZonas);
		
		request.getRequestDispatcher("/administrarZonas.jsp").forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codZona = Integer.valueOf(request.getParameter("codZona"));
		request.setAttribute("codZona", codZona);
		request.getRequestDispatcher("/modificarZona.jsp").forward(request, response);
		doGet(request, response);
	}

}

