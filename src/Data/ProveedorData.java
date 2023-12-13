package Data;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import Entidades.*;
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
			stmt.setInt(4, pro.getTelefono());
			stmt.setString(5, pro.getDireccion());
			stmt.setString(6, pro.getMail());
			
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                pro.setDni(keyResultSet.getInt(1));
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

	public static LinkedList<Proveedor> getAll(){
		LinkedList<Proveedor> proveedores = new LinkedList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DbHandler.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from proveedor");
			if (rs!=null) {
				while (rs.next()) {
					Proveedor p = new Proveedor();
					p.setDni(rs.getInt("dniProveedor"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setMail(rs.getString("mail"));
					p.setDireccion(rs.getString("direccion"));
					p.setTelefono(rs.getInt("tel"));
					proveedores.add(p);
					}
				}
			} catch (SQLException e) {
			e.printStackTrace();
					} finally {
								try {
									if(rs!=null) {rs.close();}
									if(stmt!=null) {stmt.close();}
									DbHandler.getInstancia().releaseConn();
									} catch (SQLException e) {
											e.printStackTrace();
									}
								}
		return proveedores;
	}
}
