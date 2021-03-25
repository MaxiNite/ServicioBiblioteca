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
public class Alumno {
    private String nombre, grupo;

    public Alumno() {
    }

    public Alumno(String nombre, String grupo) {
        this.nombre = nombre;
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Alumno" + " nombre= " + nombre + ", grupo= " + grupo;
    }
}
