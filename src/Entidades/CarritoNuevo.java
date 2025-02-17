package Entidades;

import java.util.ArrayList;
import java.util.List;

public class CarritoNuevo {
	private List<ItemCarrito> items;
	
	
	public List<ItemCarrito> getItems() {
		return items;
	}
	
	public CarritoNuevo() {
        this.items = new ArrayList<>();
    }
	
	public void agregarProducto(Producto producto, int cantidad) {
        for (ItemCarrito item : items) {
            if (item.getProducto().getCodProd() == producto.getCodProd()) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        items.add(new ItemCarrito(producto, cantidad));
    }
	
	

	public void setItems(List<ItemCarrito> items) {
		this.items = items;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
