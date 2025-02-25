package Data;

import Entidades.Categoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DataCategoria {

	public static LinkedList<Categoria> getAll(){
		LinkedList<Categoria> cats = new LinkedList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DbHandler.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select codCategoria, descripcion from categoria");
			if (rs!=null) {
				while (rs.next()) {
					Categoria c = new Categoria();
					c.setCodCat(rs.getInt("codCategoria"));
					c.setDescripcion(rs.getString("descripcion"));
					cats.add(c);
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
		return cats;
	}
	
	public void addCat(Categoria addc) {
		PreparedStatement pstmt = null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("insert into categoria (codCategoria,descripcion) values (?,?)");
			pstmt.setInt(1,addc.getCodCat());
			pstmt.setString(2,addc.getDescripcion());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(pstmt!=null) {pstmt.close();}
					DbHandler.getInstancia().releaseConn();
				} catch (SQLException e){
					e.printStackTrace();
				}
		}
	}
	
	public static void deleteCat(int delc) {
		PreparedStatement pstmt = null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("delete from categoria where codCategoria=?");
			pstmt.setInt(1,delc);
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
	
	public static void updateCat(int codCategoria, String descripcion) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("update categoria set descripcion=? where codCategoria=?");
			pstmt.setString(1,descripcion);
			pstmt.setInt(2,codCategoria);
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
		
	public static Categoria getOne(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Categoria c = new Categoria();
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("select * from categoria where codCategoria = ?");
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();
			if (rs!=null && rs.next()) {
					c.setCodCat(rs.getInt("codCategoria"));
					c.setDescripcion(rs.getString("descripcion"));
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
		return c;
	}
}
