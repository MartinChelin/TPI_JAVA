package Logicas;

import java.util.LinkedList;
import Data.DataProducto;
import Entidades.Producto;

public class LogProducto {
	private DataProducto dp;
	
	public LogProducto() {
		dp = new DataProducto();
	}
	
	public LinkedList<Producto> getAll(){
		return dp.getAll();
	}
	
	public void add(Producto addp) {
		dp.addProd(addp);
	}
	
	public void delete(int delp) {
		dp.deleteProd(delp);
	}
	
	public void update(Producto updp) {
		dp.updateProd(updp);
	}
	
	public Producto getOne(int searchp) {
		return dp.getOne(searchp);
	}
}


