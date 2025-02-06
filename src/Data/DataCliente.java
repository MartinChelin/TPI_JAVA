package Data;

import java.sql.*;
import Entidades.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class DataCliente {
	
	public static Cliente searchByUsername(String username){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dateFormat = "dd/MM/yyyy";
		DateTimeFormatter dFormat = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate fechaDefault = LocalDate.parse("01/01/1000", dFormat);
		
		Cliente cli = new Cliente("", "", "", "", fechaDefault, "", "", 0, 0);
	
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("select * from cliente where usuario=?");
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
	
            if(rs!=null && rs.next()) {
            	cli.setDniCliente(rs.getString(("dniCliente")));
            	cli.setNombre(rs.getString(("nombre")));
            	cli.setApellido(rs.getString(("apellido")));
            	cli.setMail(rs.getString(("mail")));
            	
            	cli.setFechaNac(rs.getObject("fechaNac", LocalDate.class));
            	cli.setUsuario(rs.getString(("usuario")));
            	cli.setContraseña(rs.getString(("contraseña")));
            	cli.setNroTarjeta(rs.getInt(("nro_tarjeta")));
            	cli.setEsAdmin(rs.getInt(("esAdmin")));
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
		return cli;
	}
	
	public static Cliente searchByDni(String dniCliente){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dateFormat = "dd/MM/yyyy";
		DateTimeFormatter dFormat = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate fechaDefault = LocalDate.parse("01/01/1000", dFormat);
		
		Cliente cli = new Cliente("", "", "", "", fechaDefault, "", "", 0, 0);
	
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("select * from cliente where usuario=?");
			pstmt.setString(1, dniCliente);
			rs = pstmt.executeQuery();
	
            if(rs!=null && rs.next()) {
            	cli.setDniCliente(rs.getString(("dniCliente")));
            	cli.setNombre(rs.getString(("nombre")));
            	cli.setApellido(rs.getString(("apellido")));
            	cli.setMail(rs.getString(("mail")));
            	cli.setFechaNac(rs.getObject("fechaNac", LocalDate.class));
            	cli.setUsuario(rs.getString(("usuario")));
            	cli.setContraseña(rs.getString(("contraseña")));
            	cli.setNroTarjeta(rs.getInt(("nro_tarjeta")));
            	cli.setEsAdmin(rs.getInt(("esAdmin")));
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
		return cli;
	}
	
	public Cliente searchByEmail(String email){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dateFormat = "dd/MM/yyyy";
		DateTimeFormatter dFormat = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate fechaDefault = LocalDate.parse("01/01/1000", dFormat);
		
		Cliente cli = new Cliente("", "", "", "", fechaDefault, "", "", 0, 0);
	
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("select * from cliente where usuario=?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
	
            if(rs!=null && rs.next()) {
            	cli.setDniCliente(rs.getString(("dniCliente")));
            	cli.setNombre(rs.getString(("nombre")));
            	cli.setApellido(rs.getString(("apellido")));
            	cli.setMail(rs.getString(("mail")));
            	cli.setFechaNac(rs.getObject("fechaNac", LocalDate.class));
            	cli.setUsuario(rs.getString(("usuario")));
            	cli.setContraseña(rs.getString(("contraseña")));
            	cli.setNroTarjeta(rs.getInt(("nro_tarjeta")));
            	cli.setEsAdmin(rs.getInt(("esAdmin")));
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
		return cli;
	}
	
	public void addCliente(Cliente cli) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbHandler.getInstancia().getConn().
					prepareStatement(
							"insert into cliente(dniCliente, nombre, apellido, mail, fechaNac, usuario, contraseña, nro_tarjeta, esAdmin) values(?,?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, cli.getDniCliente());
			stmt.setString(2, cli.getNombre());
			stmt.setString(3, cli.getApellido());
			stmt.setString(4, cli.getMail());
			stmt.setObject(5, cli.getFechaNac());
			stmt.setString(6, cli.getUsuario());
			stmt.setString(7, cli.getContraseña());
			stmt.setInt(8, cli.getNroTarjeta());
			stmt.setInt(9, 0);
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
	//Cuando un método en Java es declarado como static, significa que 
	//pertenece a la clase en lugar de una instancia específica de la clase. 
	public static LinkedList<Cliente> getAll(){
		LinkedList<Cliente> clientes = new LinkedList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		String dateFormat = "dd/MM/yyyy";
		DateTimeFormatter dFormat = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate fechaDefault = LocalDate.parse("01/01/1000", dFormat);
		
		try {
			stmt = DbHandler.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from cliente");
			if (rs!=null) {
				while (rs.next()) {
					Cliente c = new Cliente();
					c.setDniCliente(rs.getString("dniCliente"));
					c.setNombre(rs.getString("nombre"));
					c.setApellido(rs.getString("apellido"));
					c.setMail(rs.getString("mail"));
					c.setFechaNac(fechaDefault);
					c.setUsuario(rs.getString("usuario"));
					c.setContraseña(rs.getString("contraseña"));
					c.setNroTarjeta(rs.getInt("nro_tarjeta"));
					c.setEsAdmin(rs.getInt("esAdmin"));
					clientes.add(c);
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
		return clientes;
	}
	
	public static void deleteCliente(String dniCli) {
		PreparedStatement pstmt = null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("delete from cliente where dniCliente=?");
			pstmt.setString(1,dniCli);
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
	
	public void updateCliente(Cliente cli) {
		PreparedStatement pstmt=null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("update producto set nombre=?, apellido=?, mail=?, fechaNac=?, usuario=?, contraseña=?, nro_tarjeta=?, esAdmin=? where dniCliente=?");
			pstmt.setString(1,cli.getNombre());
			pstmt.setString(2,cli.getApellido());
			pstmt.setString(3,cli.getMail());
			pstmt.setObject(4,cli.getFechaNac());
			pstmt.setString(5, cli.getUsuario());
			pstmt.setString(6,cli.getContraseña());
			pstmt.setInt(7,cli.getNroTarjeta());
			pstmt.setInt(8,cli.getEsAdmin());
			pstmt.setString(9,cli.getDniCliente());
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
	
	public static void updateRolCliente(String dniCliente, int rolCliente) {
		PreparedStatement pstmt=null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("update Cliente set esAdmin=? where dniCliente=?");
			pstmt.setInt(1,rolCliente);
			pstmt.setString(2,dniCliente);
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
	
	
}
	
	//PROXS METODOS