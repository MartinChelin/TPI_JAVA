package Controlador;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Data.DataValorHistorico;
import Entidades.ValorHistorico;

/**
 * Servlet implementation class ServletMonitorValoresHistoricosProductos
 */
@WebServlet("/ServletMonitorValoresHistoricosProductos")
public class ServletMonitorValoresHistoricosProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMonitorValoresHistoricosProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LinkedList<ValorHistorico> listaValoresHistoricos = DataValorHistorico.getAll();
		request.setAttribute("listaValoresHistoricos", listaValoresHistoricos);
		
		request.getRequestDispatcher("/monitorValoresHistoricosProductos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
