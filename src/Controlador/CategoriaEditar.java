package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entidades.Categoria;
import Logicas.LogCategoria;

/**
 * Servlet implementation class CategoriaEditar
 */
@WebServlet({ "/CategoriaEditar", "/categoriaeditar", "/categoriaEditar", "/Categoriaeditar" })
public class CategoriaEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Categoria catedit = new Categoria();
		LogCategoria control = new LogCategoria();
		int codigo = Integer.parseInt(request.getParameter("CodCat"));
		catedit = control.getOne(codigo);
		request.setAttribute("catedit", catedit);
		request.getRequestDispatcher("WEB-INF/FormularioEditCat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cod = Integer.parseInt(request.getParameter("codCat"));
		String desc = request.getParameter("descripcion");
		Categoria cat = new Categoria();
		cat.setCodCat(cod);
		cat.setDescripcion(desc);
		LogCategoria control = new LogCategoria();
		control.update(cat);
		request.getRequestDispatcher("Inicio.html").forward(request, response);
	}

}
