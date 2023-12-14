package Entidades;

public class Carrito {
	int item;
	int codProducto;
	String nombre;
	String descripcion;
	double precio;
	int cantidad;
	double subtotal;
	
	public Carrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carrito(int item, int codProducto, String nombre, String descripcion, double precio, int cantidad,
			double subtotal) {
		super();
		this.item = item;
		this.codProducto = codProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
}


