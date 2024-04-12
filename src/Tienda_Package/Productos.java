package Tienda_Package;

public class Productos {
	private  String Nombre;
	private  Integer Stock;
	
	public Productos(String nombre, Integer stock) {
		
		Nombre = nombre;
		Stock = stock;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Integer getStock() {
		return Stock;
	}

	public void setStock(Integer stock) {
		Stock = stock;
	}
	
}
