package Entidades;

public class Zona {
	private int codZona;
	private String descripcion;
	
	public Zona(int codZona, String descripcion) {
		// TODO Auto-generated constructor stub
		super();
		this.codZona = codZona;
		this.descripcion = descripcion;
	}
	public Zona() {
		// TODO Auto-generated constructor stub
	}
	public int getCodZona() {
		return codZona;
	}
	public void setCodZona(int codZona) {
		this.codZona = codZona;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}