package Entidades;
public class Proveedor {
	private int dni;
	private String nombre;
	private String apellido;
	private String mail;	
	private int telefono;
	private String direccion;
	
	
	public Proveedor(int dni, String nombre, String apellido, String mail, int telefono, String direccion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}