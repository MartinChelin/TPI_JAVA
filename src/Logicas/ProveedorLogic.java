package Logicas;
import Data.ProveedorData;
import Entidades.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ProveedorLogic {
	
	public ProveedorLogic() {
		super();
	}


	public void addNewProveedor(Integer dni, String nombre, String apellido, String mail, Integer telefono,String direccion) throws ParseException {
		ProveedorData proData = new ProveedorData();
		Proveedor pro = new Proveedor(dni, nombre, apellido, mail, telefono, direccion);
		
		proData.addProveedor(pro);
	}

}

