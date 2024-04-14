package Tienda_Package;

import java.util.*;

public class Almacen {

    Map<String, Integer> Mapa;
    List<Venta> Venta;

    public Almacen() {
        Mapa = new LinkedHashMap<>();
        Venta = new LinkedList<>();
    }

    public void Añadirproducto(String nombre, Integer stock) {
        if (Mapa.containsKey(nombre)) {
            System.out.println("Este producto ya está en el Almacén");
        } else {
            Mapa.put(nombre, stock);
        }
    }

    public void ListaProductos() {
        System.out.println("\tNombre\t\tStock");
        System.out.println("=====================================");
        for (Map.Entry<String, Integer> entry : Mapa.entrySet()) {
            String nombre = entry.getKey();
            Integer stock = entry.getValue();
            System.out.printf("\t%-10s\t%d\n", nombre, stock);
        }
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
            ArrayList.add(new Productos(nombre, Mapa.get(nombre)));
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
        return Mapa.containsKey(nombre);
    }

    public void VenderProducto(String nombre, double precio, Integer cantidad) {

        int stock = Mapa.get(nombre);
        if (cantidad > stock) {
            System.out.println("No hay suficiente stock");
        } else {
            Mapa.put(nombre, (stock - cantidad));
            Venta.add(new Venta(nombre, precio, cantidad));
        }
    }

    public void Ventarealizada() {
        System.out.println("\tNombre\t\tCantidad\tPrecio \tTotal");
        System.out.println("=============================================================");
        double ventafinal = 0.0;
        for (Venta venta : Venta) {
            double totalproducto = venta.getPrecio() * venta.getCantidad();
            ventafinal += totalproducto;
            System.out.printf("\t%-10s\t%d\t\t%.2f\t\t%.2f\n", venta.getNombre(), venta.getCantidad(), venta.getPrecio(), totalproducto);
        }
        System.out.println("=============================================================");
        System.out.printf("Total de la compra: %.2f\n", ventafinal);
    }

    public Map<String, Integer> getMapa() {
        return Mapa;
    }

    public void setMapa(Map<String, Integer> mapa) {
        Mapa = mapa;
    }

}
