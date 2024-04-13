package Tienda_Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Almacen {

	Map<String, Integer> Mapa;

	public Almacen() {
		Mapa = new LinkedHashMap<>();

	}

	public void Añadirproducto(String nombre, Integer stock) {
		if (Mapa.containsKey(nombre)) {
			System.out.println("Este producto ya está en el Almacén");
		} else {
			Mapa.put(nombre, stock);
		}
	}

	public void ListaProductos() {
		StringBuilder Lista = new StringBuilder();
		Lista.append("   Nombre               Stock\n");
		Lista.append("============         ===========\n");

		for (String nombre : Mapa.keySet()) {
			Integer stock = Mapa.get(nombre);
			Lista.append(String.format("%5s\t\t\t%d\n", nombre, stock));
		}
		System.out.println(Lista.toString());
	}

	public void retirarProducto(String nombre) {
		if (Mapa.containsKey(nombre)) {
			Mapa.remove(nombre);
			System.out.println("El producto ha sido retirado con éxito");
		} else {
			System.out.println("Ese producto no existe");
		}
	}

	public void OrdenarProducto() {
		List<Productos> ArrayList = new ArrayList<>();
		for (String nombre : Mapa.keySet()) {
			Integer stock = Mapa.get(nombre);
			ArrayList.add(new Productos(nombre, stock));
		}
		ArrayList.sort((o, o2) -> o.getNombre().compareToIgnoreCase(o2.getNombre()));
		Mapa.clear();
		for (Productos producto : ArrayList) {
			Mapa.put(producto.getNombre(), producto.getStock());
		}
	}

	public void ProductosSinStock() {
		List<Productos> psinstock = new ArrayList<>();
		for (String nombre : Mapa.keySet()) {
			Integer stock = Mapa.get(nombre);
			if (stock == 0) {
				psinstock.add(new Productos(nombre, stock));
			}

		}
		for (Productos producto : psinstock) {
			System.out.println(producto);
		}
	}

	public void reponerStock(String nombre, Integer adicionalstock) {
		Integer Suma = adicionalstock + Mapa.get(nombre);
		Mapa.put(nombre, Suma);
	}

	public boolean existeProducto(String nombre) {
		if (Mapa.containsKey(nombre)) {
			return true;
		} else
			return false;

	}

	public Map<String, Integer> getMapa() {
		return Mapa;
	}

	public void setMapa(Map<String, Integer> mapa) {
		Mapa = mapa;
	}

}
