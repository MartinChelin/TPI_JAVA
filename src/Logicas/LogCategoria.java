package Logicas;

import java.util.LinkedList;

import Data.DataCategoria;
import Entidades.Categoria;

public class LogCategoria {
	private DataCategoria dc;
	
	public LogCategoria() {
		dc = new DataCategoria();
	}
	
	public LinkedList<Categoria> getAll(){
		return dc.getAll();
	}
	
	public void add(Categoria addc) {
		dc.addCat(addc);
	}
	
	public void delete(int delc) {
		dc.deleteCat(delc);
	}
	
	public void update(Categoria updc) {
		dc.updateCat(updc);
	}
	
	public Categoria getOne(int searchc) {
		return dc.getOne(searchc);
	}
}
