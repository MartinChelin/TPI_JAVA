package Data;

import java.sql.*;
import Entidades.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class ProveedorData {
	
	public void addProveedor(Proveedor pro) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbHandler.getInstancia().getConn().
					prepareStatement(
							"insert into proveedor(dniProveedor, nombre, apellido, tel, direccion, mail) values(?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, pro.getDni());
			stmt.setString(2, pro.getNombre());
			stmt.setString(3, pro.getApellido());
			stmt.setString(4, pro.getMail());
			stmt.setInt(5, pro.getTelefono());
			stmt.setString(6, pro.getDireccion());

			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                cli.setDniCliente(keyResultSet.getString(1));
            }
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbHandler.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
    }


}
