package Data;

import java.sql.*;
import Entidades.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class ClienteData {
	
	public Cliente searchByUsername(String username){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dateFormat = "dd/MM/yyyy";
		DateTimeFormatter dFormat = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate fechaDefault = LocalDate.parse("01/01/1000", dFormat);
		
		Cliente cli = new Cliente("", "", "", "", fechaDefault, "", "", 0, "");
	
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
            	cli.setRol(rs.getString(("rol")));
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
	
	public Cliente searchByDni(String dniCliente){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dateFormat = "dd/MM/yyyy";
		DateTimeFormatter dFormat = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate fechaDefault = LocalDate.parse("01/01/1000", dFormat);
		
		Cliente cli = new Cliente("", "", "", "", fechaDefault, "", "", 0, "");
	
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
            	cli.setRol(rs.getString(("rol")));
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
		
		Cliente cli = new Cliente("", "", "", "", fechaDefault, "", "", 0, "");
	
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
            	cli.setRol(rs.getString(("rol")));
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
							"insert into cliente(dniCliente, nombre, apellido, mail, fechaNac, usuario, contraseña, nro_tarjeta,rol) values(?,?,?,?,?,?,?,?,?)",
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
			stmt.setString(9, cli.getRol());
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
	
	//PROXS METODOS