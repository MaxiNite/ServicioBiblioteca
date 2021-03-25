/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciobiblioteca;

/**
 *
 * @author Dhtey
 */
public class Libro {

    private String nombre, descripccion, autor, genero;
    private int cantidad;

    public Libro() {
    }

    public Libro(String nombre, String descripccion, String autor, String genero, int cantidad) {
        this.nombre = nombre;
        this.descripccion = descripccion;
        this.autor = autor;
        this.genero = genero;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Libro " + "nombre= " + nombre + ", descripccion= " + 
                descripccion + ", autor= " + autor + ", genero= " + 
                genero + ", cantidad= " + cantidad;
    }
}
