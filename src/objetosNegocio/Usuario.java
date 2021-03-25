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
public class Usuario {
    private String nombreUsuario, nombre, apellido, contrasena, puesto; 

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String nombre, String apellido, String contrasena, String puesto) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.puesto = puesto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Usuario " + "Nombre del Usuario= " + nombreUsuario + 
                ", nombre= " + nombre + ", apellido= " + apellido + 
                ", contrasena= " + contrasena + ", puesto= " + puesto;
    }
}
