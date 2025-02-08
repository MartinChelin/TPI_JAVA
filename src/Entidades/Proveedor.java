package Entidades;
public class Proveedor {
	private String dniProveedor;
	private String nombre;
	private String apellido;
	private String mail;	
	private String telefono;
	private String direccion;
	
	
	public Proveedor(String dniProveedor, String nombre, String apellido, String mail, String telefono, String direccion) {
		super();
		this.dniProveedor = dniProveedor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	public Proveedor() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDni(String dniProveedor) {
		this.dniProveedor = dniProveedor;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDni() {
		return dniProveedor;
	}
	
	
}