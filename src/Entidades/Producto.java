package Entidades;

public class Producto {
	private int codProd;
	private String nombre;
	private String descripcion;
	private int stock;
	private double precioBase;
	private Categoria cat;
	
	//Getters & Setters
	public Categoria getCat() {
		return cat;
	}
	public void setCat(Categoria cat) {
		this.cat = cat;
	}
	public int getCodProd() {
		return codProd;
	}
	public void setCodProd(int codProd) {
		this.codProd = codProd;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	//Constructor
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto(int codProd, String nombre, String descripcion, int stock, double precioBase, Categoria cat) {
		super();
		this.codProd = codProd;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precioBase = precioBase;
		this.cat = cat;
	}
}
