package Logicas;

import Data.DataZona;
import Entidades.Zona;

public class LogicZona {
	public LogicZona() {
		super();
	}
	public void addNewZona(int codZona, String descripcion){
		DataZona zonaData = new DataZona();
		Zona z = new Zona(codZona, descripcion);
		
		zonaData.addZona(z);
	}
}
