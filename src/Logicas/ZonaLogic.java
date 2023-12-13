package Logicas;

import Data.DataZona;
import Entidades.Zona;

public class ZonaLogic {
	public ZonaLogic() {
		super();
	}
	public void addNewZona(int codZona, String descripcion){
		DataZona zonaData = new DataZona();
		Zona z = new Zona(codZona, descripcion);
		
		zonaData.addZona(z);
	}
}
