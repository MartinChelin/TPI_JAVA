package Data;
import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;

import Entidades.*;
public class DataProveedor {
	
	public void addProveedor(Proveedor pro) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbHandler.getInstancia().getConn().
					prepareStatement(
							"insert into proveedor(dniProveedor, nombre, apellido, tel, direccion, mail) values(?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, pro.getDni());
			stmt.setString(2, pro.getNombre());
			stmt.setString(3, pro.getApellido());
			stmt.setString(4, pro.getTelefono());
			stmt.setString(5, pro.getDireccion());
			stmt.setString(6, pro.getMail());
			
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                pro.setDni(keyResultSet.getString(1));
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
					p.setDni(rs.getString("dniProveedor"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setMail(rs.getString("mail"));
					p.setDireccion(rs.getString("direccion"));
					p.setTelefono(rs.getString("tel"));
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
	
	public static void deleteProveedor(String dniProv) {
		PreparedStatement pstmt = null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("delete from proveedor where dniProveedor=?");
			pstmt.setString(1,dniProv);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {pstmt.close();}
				DbHandler.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void updateProveedor(String dniProveedor, String nombre, String apellido,String tel, String direccion, String mail) {
		PreparedStatement pstmt=null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("update proveedor set nombre=?, apellido=?, tel=?, direccion=?, mail=? where dniProveedor=?");
			pstmt.setString(1,nombre);
			pstmt.setString(2,apellido);
			pstmt.setString(3,tel);
			pstmt.setString(4,direccion);
			pstmt.setString(5,mail);
			pstmt.setString(6,dniProveedor);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {pstmt.close();}
				DbHandler.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void updateDniProveedor(String dniProveedor) {
		PreparedStatement pstmt=null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("update Proveedor set dniProveedor=? where dniProveedor=?");
			pstmt.setString(1,dniProveedor);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {pstmt.close();}
				DbHandler.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Proveedor searchByDni(String dniProveedor){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Proveedor prov = null;
		//Proveedor prov = new Proveedor(0, "", "", "", "", "");
	
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("select * from proveedor where dniProveedor=?");
			pstmt.setString(1, dniProveedor);
			rs = pstmt.executeQuery();
	
            if(rs!=null && rs.next()) {
            	prov = new Proveedor(
    	                rs.getString("dniProveedor"),
    	                rs.getString("nombre"),
    	                rs.getString("apellido"),
    	                rs.getString("mail"),
    	                rs.getString("telefono"),
    	                rs.getString("direccion")
    	         );
            }
        
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
						if(rs!=null) {rs.close();}
						if(pstmt!=null) {pstmt.close();}
						DbHandler.getInstancia().releaseConn();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		return prov;
	}
}
