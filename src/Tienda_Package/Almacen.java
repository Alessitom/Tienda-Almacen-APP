package Tienda_Package;

import java.util.HashMap;
import java.util.Map;

public class Almacen {

	Map<String, Integer> Mapa;

	public Almacen() {
	 Mapa = new HashMap<>();

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


	public Map<String, Integer> getMapa() {
		return Mapa;
	}

	public void setMapa(Map<String, Integer> mapa) {
		Mapa = mapa;
	}

}
