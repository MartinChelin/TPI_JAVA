package Controlador;

import java.io.IOException;
import java.util.LinkedList;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Cliente;
import Entidades.ValorHistorico;
import Data.DataCliente;
import Data.DataValorHistorico;

/**
 * Servlet implementation class ServletFiltrarValoresHistoricosProductos
 */
@WebServlet("/ServletFiltrarValoresHistoricosProductos")
public class ServletFiltrarValoresHistoricosProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFiltrarValoresHistoricosProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String codigoFiltro = request.getParameter("codigo");
        String categoriaFiltro = request.getParameter("categoria");

        // Traigo los registros de la bdd
        LinkedList<ValorHistorico> valoresHistoricos = DataValorHistorico.getAll() ;
        
        // Filtrado
        LinkedList<ValorHistorico> valoresFiltrados = valoresHistoricos.stream()
        	.filter(v -> (codigoFiltro == null || codigoFiltro.isEmpty() || String.valueOf(v.getCodProductoVH()).contains(codigoFiltro)))
            .filter(v -> (categoriaFiltro == null || categoriaFiltro.isEmpty() || v.getDescripcion().contains(categoriaFiltro)))
            .collect(Collectors.toCollection(LinkedList::new));

        request.setAttribute("listaValoresHistoricos", valoresFiltrados);
        request.getRequestDispatcher("monitorValoresHistoricosProductos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
