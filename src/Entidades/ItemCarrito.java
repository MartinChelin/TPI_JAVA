package Entidades;

public class ItemCarrito {
	private Producto producto;
	private int cantidad;
	
	public ItemCarrito(Producto producto, int cantidad) {
		// TODO Auto-generated constructor stub
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double calcularSubtotal() {
		// TODO Auto-generated method stub
		return producto.getPrecioBase() * cantidad;
	}

}
