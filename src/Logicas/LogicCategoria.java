package Logicas;

import java.util.LinkedList;

import Data.DataCategoria;
import Entidades.Categoria;


public class LogicCategoria {
	private DataCategoria dc;
	
	public LogicCategoria() {
		dc = new DataCategoria();
	}
	
	public LinkedList<Categoria> getAll(){
		return DataCategoria.getAll();
	}
	
	public void add(Categoria addc) {
		dc.addCat(addc);
	}
	
	public void delete(int delc) {
		DataCategoria.deleteCat(delc);
	}
	
	public void update(Categoria updc) {
		DataCategoria.updateCat(updc.getCodCat(), updc.getDescripcion());
	}
	
	public Categoria getOne(int searchc) {
		return DataCategoria.getOne(searchc);
	}
}
