package Logicas;
import Data.ProveedorData;
import Entidades.*;

public class ProveedorLogic {
	
	public ProveedorLogic() {
		super();
	}
	public void addNewProveedor(int dni, String nombre, String apellido, String mail, String telefono,String direccion){
		
		ProveedorData proData = new ProveedorData();
		Proveedor pro = new Proveedor(dni, nombre, apellido, mail, telefono, direccion);
		
		proData.addProveedor(pro);
	}
}
