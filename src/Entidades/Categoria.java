package Entidades;

public class Categoria {
	private int codCat;
	private String descripcion;
	
	public int getCodCat() {
		return codCat;
	}
	public void setCodCat(int codCat) {
		this.codCat = codCat;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Categoria(int codCat, String descripcion) {
		super();
		this.codCat = codCat;
		this.descripcion = descripcion;
	}
	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	
	

}
