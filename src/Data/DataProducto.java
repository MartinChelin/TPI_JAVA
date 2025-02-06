package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import Entidades.Producto;
import Logicas.LogicCategoria;

public class DataProducto {
	public LinkedList<Producto> getAll(){
		LinkedList<Producto> prods = new LinkedList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DbHandler.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select codProducto, nombre, descripcion, stock, precioBase, codCategoria from producto");
			if (rs!=null) {
				while (rs.next()) {
					Producto p = new Producto();
					p.setCodProd(rs.getInt("codProducto"));
					p.setNombre(rs.getString("nombre"));
					p.setDescripcion(rs.getString("descripcion"));
					p.setStock(rs.getInt("stock"));
					p.setPrecioBase(rs.getDouble("precioBase"));
					LogicCategoria control = new LogicCategoria();
					p.setCat(control.getOne(rs.getInt("codCategoria")));
					prods.add(p);
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
		return prods;
	}
	
	public void addProd(Producto addp) {
		PreparedStatement pstmt = null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("insert into producto (codProducto,nombre,descripcion,stock,precioBase,codCategoria) values (?,?,?,?,?,?)");
			pstmt.setInt(1,addp.getCodProd());
			pstmt.setString(2,addp.getNombre());
			pstmt.setString(3,addp.getDescripcion());
			pstmt.setInt(4,addp.getStock());
			pstmt.setDouble(5,addp.getPrecioBase());
			pstmt.setInt(6, addp.getCat().getCodCat());
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
	
	public void deleteProd(int delp) {
		PreparedStatement pstmt = null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("delete from producto where codProducto=?");
			pstmt.setInt(1,delp);
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

	public void updateProd(Producto updp) {
		PreparedStatement pstmt=null;
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("update producto set nombre=?, descripcion=?, stock=?, precioBase=?, codCategoria=? where codProducto=?");
			pstmt.setString(1,updp.getNombre());
			pstmt.setString(2,updp.getDescripcion());
			pstmt.setInt(3,updp.getStock());
			pstmt.setDouble(4,updp.getPrecioBase());
			pstmt.setInt(5, updp.getCat().getCodCat());
			pstmt.setInt(6,updp.getCodProd());
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
	
	public Producto getOne(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Producto p = new Producto();
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement("select * from producto where codProducto = ?");
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();
			if (rs!=null && rs.next()) {
					p.setCodProd(rs.getInt("codProducto"));
					p.setNombre(rs.getString("nombre"));
					p.setDescripcion(rs.getString("descripcion"));
					p.setStock(rs.getInt("stock"));
					p.setPrecioBase(rs.getDouble("precioBase"));
					LogicCategoria control = new LogicCategoria();
					p.setCat(control.getOne(rs.getInt("codCategoria")));
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
		return p;
	}
	
	public LinkedList<Producto> getProdByNom(String nom, String cat,String order) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<Producto> prods = new LinkedList<>();
		//Preparar consulta
		if (nom == null) {
			nom = "";
		}
		if (order == null) {
		    order = "";
		} else {
		    switch (order) {
		        case "preciomax":
		            order = " order by precioBase desc";
		            break;
				default:
					order = " order by precioBase asc";
					break;
		    }
		}
		if (cat == null) {
			cat = "";
		} else {
			cat = " and codCategoria = " + cat;
		}
		String sql = "select * from producto where nombre like ? "+ cat + "" + order + ";";
		try {
			pstmt = DbHandler.getInstancia().getConn().prepareStatement(sql);
			pstmt.setString(1,"%" + nom + "%");
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Producto p = new Producto();
					p.setCodProd(rs.getInt("codProducto"));
					p.setNombre(rs.getString("nombre"));
					p.setDescripcion(rs.getString("descripcion"));
					p.setStock(rs.getInt("stock"));
					p.setPrecioBase(rs.getDouble("precioBase"));
					LogicCategoria control = new LogicCategoria();
					p.setCat(control.getOne(rs.getInt("codCategoria")));
					prods.add(p);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				DbHandler.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return prods;
	}
}

