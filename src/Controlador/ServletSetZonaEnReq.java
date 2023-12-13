package Controlador;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.DataZona;
import Entidades.Zona;

@WebServlet("/ServletSetZonaEnReq")
public class ServletSetZonaEnReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletSetZonaEnReq() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		LinkedList<Zona> listaZonas = DataZona.getAll();
		request.setAttribute("listaZonas", listaZonas);
		
		request.getRequestDispatcher("/controlZona.jsp").forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

