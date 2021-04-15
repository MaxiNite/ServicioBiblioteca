/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

/**
 *
 * @author Dhtey
 */
public class Ejemplar extends Libro{
    private int id;

    public Ejemplar() {
    }
    public Ejemplar(String nombre, String descripccion, String autor, String genero, int cantidad) {
        super(nombre, descripccion, autor, genero, cantidad);
    }

    public Ejemplar(int id, String nombre, String descripccion, String autor, String genero, int cantidad) {
        super(nombre, descripccion, autor, genero, cantidad);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ejemplar " + "id= " + id;
    }
}
