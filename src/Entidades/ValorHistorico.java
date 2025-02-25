package Entidades;

import java.time.LocalDate;

public class ValorHistorico {
	private int codProductoVH;
	private String nombreProducto;
	private String descripcion;
	private double valor;
	private LocalDate fechaDesde;
	String dateFormat = "dd/MM/yyyy";

	
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCodProductoVH() {
		return codProductoVH;
	}
	public void setCodProductoVH(int codProductoVH) {
		this.codProductoVH = codProductoVH;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDate getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(LocalDate fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	
}
