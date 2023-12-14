package Controlador;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Carrito;
import Entidades.Producto;
import Logicas.LogProducto;

/**
 * Servlet implementation class ServletCarrito
 */
@WebServlet("/ServletCarrito")
public class ServletCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /*CARRITO*/
    
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = (String)request.getParameter("accion");
		LinkedList<Producto> productos = logp.getAll();
		switch (accion) {
			case "AgregarCarrito":
				int codp = Integer.parseInt(request.getParameter("id"));
				p = logp.getOne(codp);
				item = item + 1;
				Carrito car = new Carrito();
				car.setItem(item);
				car.setCodProducto(p.getCodProd());
				car.setNombre(p.getNombre());
				car.setDescripcion(p.getDescripcion());
				car.setPrecio(p.getPrecioBase());
				car.setCantidad(cantidad);
				car.setSubtotal(cantidad*p.getPrecioBase());
				listaCarrito.add(car);
				request.setAttribute("contador", listaCarrito.size());
			    request.getRequestDispatcher("main.jsp").forward(request, response);
			    break;
			case "Carrito":
				double totalPagar=0.0;
				request.setAttribute("carrito", listaCarrito);
				for (int i=0; i<listaCarrito.size();i++) {
					totalPagar=totalPagar+listaCarrito.get(i).getSubtotal();
				}
				request.setAttribute("totalPagar", totalPagar);
				request.getRequestDispatcher("carrito.jsp").forward(request, response);
				break;
			default:
				request.getRequestDispatcher("/main.jsp").forward(request, response);	
				request.setAttribute("productos", productos);
			break;
				
		}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    Producto p = new Producto();
    LogProducto logp = new LogProducto();
    int cantidad=1, item;
    double subtotal=0.0;
    LinkedList<Carrito> listaCarrito = new LinkedList<>();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double totalPagar=0.0;
		request.setAttribute("carrito", listaCarrito);
		for (int i=0; i<listaCarrito.size();i++) {
			totalPagar=totalPagar+listaCarrito.get(i).getSubtotal();
		}
		request.setAttribute("totalPagar", totalPagar);
		request.getRequestDispatcher("carrito.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codp = Integer.parseInt(request.getParameter("codProducto"));
		p = logp.getOne(codp);
		item = item + 1;
		Carrito car = new Carrito();
		car.setItem(item);
		car.setCodProducto(p.getCodProd());
		car.setNombre(p.getNombre());
		car.setDescripcion(p.getDescripcion());
		car.setPrecio(p.getPrecioBase());
		car.setCantidad(cantidad);
		car.setSubtotal(cantidad*p.getPrecioBase());
		listaCarrito.add(car);
		LinkedList<Producto> productos = logp.getAll();
		request.setAttribute("listaProductos", productos);
	    request.getRequestDispatcher("mainCliente.jsp").forward(request, response);
	}
}
