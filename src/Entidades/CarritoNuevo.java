package Entidades;

import java.util.ArrayList;
import java.util.List;

public class CarritoNuevo {
	private List<ItemCarrito> items;
	
	// Getters y Setters
	public List<ItemCarrito> getItems() {
		return items;
	}
	

	public void setItems(List<ItemCarrito> items) {
		this.items = items;
	}
	
	// Constructores
	public CarritoNuevo() {
        this.items = new ArrayList<>();
    }
	
	// Metodos
	public void agregarProducto(Producto producto, int cantidad) {
        for (ItemCarrito item : items) {
            if (item.getProducto().getCodProd() == producto.getCodProd()) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        items.add(new ItemCarrito(producto, cantidad));
    }
	
	// Devuelve el item del carrito que contiene el producto pasado por parametro
	public ItemCarrito getItemCarrito(Producto producto) {
        for (ItemCarrito item : items) {
            if (item.getProducto().getCodProd() == producto.getCodProd()) {
                return item;
            }
        }
        return null;
        }
	
	// Elimina un producto del carrito
	public void eliminarProducto(Producto producto) {
		items.removeIf(item -> item.getProducto().getCodProd() == producto.getCodProd());
	}
	
	// Vacia el carrito
	public void vaciarCarrito() {
		items.clear();
	}
	
	// Calcula el total de la compra
	public double calcularTotal() {
		double total = 0;
		for (ItemCarrito item : items) {
			total += item.calcularSubtotal();
		}
		return total;
	}
	
	// Modifica la cantidad de un producto en el carrito
	public void modificarCantidad(Producto producto, int cantidad) {
		for (ItemCarrito item : items) {
			if (item.getProducto().getCodProd() == producto.getCodProd()) {
				item.setCantidad(cantidad);
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
