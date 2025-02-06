package Controlador;
import Logicas.LogicZona;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/registrarZona")
public class ServletRegistrarZona extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletRegistrarZona() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LogicZona newZona = new LogicZona(); 
        int codZona = Integer.valueOf(request.getParameter("codZona"));
        String descripcion = request.getParameter("descripcion");
        
        newZona.addNewZona(codZona, descripcion);
        request.getRequestDispatcher("administrarZonas.jsp").forward(request, response);
	}
}