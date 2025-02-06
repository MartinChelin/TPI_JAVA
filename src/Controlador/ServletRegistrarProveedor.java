package Controlador;
import Logicas.LogicProveedor;
import java.io.IOException;
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
		LogicProveedor newProveedor = new LogicProveedor(); 
        int dni = Integer.valueOf(request.getParameter("dni"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String mail = request.getParameter("mail");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        
        newProveedor.addNewProveedor(dni, nombre, apellido, mail, telefono, direccion);
        
        response.getWriter().append("Carga Completa").append(request.getContextPath());
	}
}