package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

import Entidades.Cliente;
import Entidades.ValorHistorico;

public class DataValorHistorico {

	
	public static LinkedList<ValorHistorico> getAll(){
		LinkedList<ValorHistorico> vhs = new LinkedList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DbHandler.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT  vhp.codProductoVH, vhp.valor, p.nombre, vhp.fechaDesde, c.descripcion FROM valor_historico_producto vhp INNER JOIN producto p ON p.codProducto = vhp.codProductoVH INNER JOIN categoria c ON c.codCategoria = p.codCategoria");
			if (rs!=null) {
				while (rs.next()) {
					ValorHistorico vh = new ValorHistorico();
					vh.setCodProductoVH(rs.getInt("vhp.codProductoVH"));
					vh.setValor(rs.getDouble("vhp.valor"));
					vh.setNombreProducto(rs.getString("p.nombre"));
					vh.setFechaDesde(rs.getObject("vhp.fechaDesde", LocalDate.class));
					vh.setDescripcion(rs.getString("c.descripcion"));
					vhs.add(vh);
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
		return vhs;
	}

	public void addVH(ValorHistorico vh) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbHandler.getInstancia().getConn().
					prepareStatement(
							"insert into valor_historico_producto(codProductoVH, fechaDesde, valor) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, vh.getCodProductoVH());
			stmt.setObject(2, vh.getFechaDesde());
			stmt.setDouble(3, vh.getValor());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
            	vh.setCodProductoVH(keyResultSet.getInt(1));
            	vh.setFechaDesde((LocalDate) keyResultSet.getObject(2));
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
