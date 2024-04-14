package Tienda_Package;

import java.util.Comparator;

public class Productos implements Comparator<Productos> {
    @Override
    public int compare(Productos o, Productos o2) {
        return o.getNombre().compareTo(o2.getNombre());
    }

    private String Nombre;
    private Integer Stock;


    public Productos(String nombre, Integer stock) {

        Nombre = nombre;
        Stock = stock;

    }

    @Override
    public String toString() {
        return "Nombre =" + Nombre + ", Stock =" + Stock;
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

