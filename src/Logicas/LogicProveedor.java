package Logicas;
import Data.DataProveedor;
import Entidades.*;

public class LogicProveedor {
	
	public LogicProveedor() {
		super();
	}
	public void addNewProveedor(int dni, String nombre, String apellido, String mail, String telefono,String direccion){
		
		DataProveedor proData = new DataProveedor();
		Proveedor pro = new Proveedor(dni, nombre, apellido, mail, telefono, direccion);
		
		proData.addProveedor(pro);
	}
}
