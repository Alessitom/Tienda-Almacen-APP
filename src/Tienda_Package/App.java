package Tienda_Package;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		Almacen almacen = new Almacen();
		boolean salir = false;
		do {
			Menu();
			int opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				almacen.ListaProductos();
				break;
			 case 2:
                 System.out.println("Introduce el nombre del producto:");
                 scanner.nextLine(); // Consumir el salto de línea pendiente
                 String nombreProducto = scanner.nextLine();
                 System.out.println("Introduce el stock: ");
                 Integer stock = scanner.nextInt();
                 almacen.Añadirproducto(nombreProducto, stock);
                 break;
			case 7: 
				System.out.println("Has salido con éxito");
				 salir = true;
				 break;
			default:
				
			}
		} while (!salir);
		
	}
	
	
	
	
	public static void Menu() {
		System.out.println("********************------------MENÚ--------------**************************");
		System.out.println("1. Ver Inventario ");
		System.out.println("2. Añadir producto");
		System.out.println("3. Retirar producto");
		System.out.println("4. Ordenar Almacén (Por Orden Alfabético)");
		System.out.println("5. Productos que están sin stock");
		System.out.println("6. Reponer stock (Producto y Cantidad)");
		System.out.println("7. Salir ");
		System.out.println("********************------------MENÚ--------------**************************");
		
		
	}

}
