package Logicas;
import Data.DataCliente;
import Entidades.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogicCliente {
	
	public LogicCliente() {
		super();
	}
	
	//devuelve true si no existen los atributos pasados como parametros
	public boolean compareAtributtesUsuario(String username, String dniCliente, String email){
		
		boolean control = true;
		DataCliente cliData = new DataCliente();
		Cliente cli = new Cliente();
		
		cli = cliData.searchByUsername(username);
		
		if(cli.estaVacia()) {
			cli = cliData.searchByDni(dniCliente);
			if(cli.estaVacia()) {
				cli = cliData.searchByEmail(email);
				if(!cli.estaVacia()) {
					control = false;
				}
			}else {
				control = false;
			}
		}else {
			control = false;
		}
		
		return control;
	}

	public void addNewCliente(String dniCliente, String nombre, String apellido, String mail, String fechaNac, String usuario, String password, int nroTarjeta, int esAdmin) {
		DataCliente cliData = new DataCliente();
		try {
            // Crear un objeto SimpleDateFormat para el formato ISO
            SimpleDateFormat formatoISO = new SimpleDateFormat("yyyy-MM-dd");

            // Parsear la fecha ISO a un objeto Date
            Date fecha = formatoISO.parse(fechaNac);

            // Crear un objeto SimpleDateFormat para el formato europeo (dd/MM/yyyy)
            SimpleDateFormat formatoEuropeo = new SimpleDateFormat("dd/MM/yyyy");

            // Formatear la fecha en formato europeo
            String fechaEuropea = formatoEuropeo.format(fecha);
            
            String dateFormat = "dd/MM/yyyy";
    		DateTimeFormatter dFormat = DateTimeFormatter.ofPattern(dateFormat);
    		LocalDate fechaNacimiento = LocalDate.parse(fechaEuropea, dFormat);
    		
    		Cliente cli = new Cliente(dniCliente, nombre, apellido, mail, fechaNacimiento, usuario, password, nroTarjeta, esAdmin);
    		
    		cliData.addCliente(cli);

        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		
		
		// TODO Auto-generated method stub
		
	}

	public Cliente verifyExist(String uname) {
		DataCliente cliData = new DataCliente();
		Cliente cli = cliData.searchByUsername(uname);
		return cli;
	}

	public boolean verifyPass(Cliente user, String pass) {
		if (user.getContraseña().equals(pass)) {
			return true;
		}
		else {
			return false;
		}
	}	
	
	public Cliente getClienteByUser(String username) {
		DataCliente cliData = new DataCliente();
		Cliente cli = cliData.searchByUsername(username);
		return cli;
	}
}
