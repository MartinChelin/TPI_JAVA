package Controlador;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entidades.Carrito;
import Entidades.Producto;
import Logicas.LogicProducto;

/**
 * Servlet implementation class ServletCarrito
 */
@WebServlet("/ServletCarrito")
public class ServletCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /*CARRITO*/
    Producto p = new Producto();
    LogicProducto logp = new LogicProducto();
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
		String action = request.getParameter("action");
		switch (action) {
		case "Agregar Producto":
			int codp = Integer.parseInt(request.getParameter("codProducto"));
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
			p = logp.getOne(codp);
            int stock = p.getStock();
            // Si el carrito está vacio, agregar producto, sino verificar que el producto ya está en el carrito por codProducto, si no está se agrega al carrito (caso 1), si está se actualiza cantidad y subtotal (caso 2).
           if (listaCarrito.size() == 0) {
        	                   if (stock > 0) {
									Carrito car = new Carrito();
									item = item + 1;
									car.setItem(item);
									car.setCodProducto(p.getCodProd());
									car.setNombre(p.getNombre());
									car.setDescripcion(p.getDescripcion());
									car.setPrecio(p.getPrecioBase());
									car.setCantidad(cantidad);
									car.setSubtotal(cantidad * p.getPrecioBase());
									listaCarrito.add(car);
									p.setStock(stock - cantidad);
								} else {
									request.getRequestDispatcher("mainCliente.jsp").forward(request, response);
									// Mensaje de stock superado en la vista
								}} 
         else {
        	 boolean bandera = false;
        	 for (int i = 0; i < listaCarrito.size(); i++) {
        		 if (codp == listaCarrito.get(i).getCodProducto()) {
						bandera = true;
						// Actualizar cantidad y subtotal
						int cantidadant = listaCarrito.get(i).getCantidad();
						if ((cantidadant + cantidad) <= stock) {
							listaCarrito.get(i).setCantidad(cantidadant + cantidad);
							listaCarrito.get(i).setSubtotal(listaCarrito.get(i).getCantidad() * listaCarrito.get(i).getPrecio());
							p.setStock(stock - cantidad);
						} else {
							request.getRequestDispatcher("mainCliente.jsp").forward(request, response);
							// Mensaje de stock superado en la vista
						}
        		 }
        	 }
          if (!bandera) {
            	    	if (stock > 0) {
            	        Carrito car = new Carrito();
            	        item = item + 1;
            	        car.setItem(item);
            	        car.setCodProducto(p.getCodProd());
            	        car.setNombre(p.getNombre());
            	        car.setDescripcion(p.getDescripcion());
            	        car.setPrecio(p.getPrecioBase());
            	        car.setCantidad(cantidad);
            	        car.setSubtotal(cantidad * p.getPrecioBase());
            	        listaCarrito.add(car);
            	        p.setStock(stock - cantidad);
            	        } else {
            	        request.getRequestDispatcher("mainCliente.jsp").forward(request, response);
            	        // Mensaje de stock superado en la vista 
            	        }
             }
          }
          HttpSession session = request.getSession();
          session.setAttribute("listaCarrito", listaCarrito);
          logp.update(p);
          LinkedList<Producto> productos = logp.getAll();
          request.setAttribute("listaProductos", productos);
          request.getRequestDispatcher("mainCliente.jsp").forward(request, response);
          break;
		case "Eliminar":
		    	            int item = Integer.parseInt(request.getParameter("item"));
							for (int i = 0; i < listaCarrito.size(); i++) {
								if (listaCarrito.get(i).getItem() == item) {
									p = logp.getOne(listaCarrito.get(i).getCodProducto());
									cantidad = listaCarrito.get(i).getCantidad();
									p.setStock(p.getStock() + cantidad);
									logp.update(p);
									listaCarrito.remove(i);
								}
							}
							double totalPagar = 0.0;
							for (int i = 0; i < listaCarrito.size(); i++) {
								totalPagar = totalPagar + listaCarrito.get(i).getSubtotal();
							}
							HttpSession session1 = request.getSession();
							session1.setAttribute("totalPagar", totalPagar);
							request.setAttribute("carrito", listaCarrito);
							request.getRequestDispatcher("carrito.jsp").forward(request, response);
			break;
		}
    }
}