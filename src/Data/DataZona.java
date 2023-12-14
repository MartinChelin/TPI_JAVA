package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import Entidades.Cliente;
import Entidades.Zona;

public class DataZona {
	public void addZona(Zona z) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbHandler.getInstancia().getConn().
					prepareStatement(
							"insert into zona(codZona, descripcion) values(?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, z.getCodZona());
			stmt.setString(2, z.getDescripcion());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                z.setCodZona(keyResultSet.getInt(1));
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
	
	public static LinkedList<Zona> getAll(){
		LinkedList<Zona> zonas = new LinkedList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DbHandler.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from zona");
			if (rs!=null) {
				while (rs.next()) {
					Zona z = new Zona();
					z.setCodZona(rs.getInt("codZona"));
					z.setDescripcion(rs.getString("descripcion"));
					zonas.add(z);
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
		return zonas;
	}
	public static void deleteZona(String codZona) {
		PreparedStatement pstmt = null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("delete from zona where codZona=?");
			pstmt.setString(1,codZona);
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

	public static Zona searchByCod(int codZona){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Zona zona = new Zona(0, "");
	
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("select * from zona where codZona=?");
			pstmt.setInt(1, codZona);
			rs = pstmt.executeQuery();
	
            if(rs!=null && rs.next()) {
            	zona.setCodZona(rs.getInt(("codZona")));
            	zona.setDescripcion(rs.getString(("descripcion")));
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
		return zona;
	}

	public static void updateZona(int codZona, String descripcion) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("update zona set descripcion=? where codZona=?");
			pstmt.setString(1,descripcion);
			pstmt.setInt(2,codZona);
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
