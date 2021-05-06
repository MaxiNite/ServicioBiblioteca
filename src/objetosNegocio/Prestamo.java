/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

/**
 *
 * @author alexis
 */
public class Prestamo {

    int idprestamo;
    String nombreLibro;
    String fechaPrestamo;
    String ninho;
    String grado;

    public Prestamo() {

    }

    public Prestamo(String nombreLibro, String fechaPrestamo, String ninho, String grado) {
        this.nombreLibro = nombreLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.ninho = ninho;
        this.grado = grado;
    }

    public Prestamo(int idprestamo, String nombreLibro, String fechaPrestamo, String niño, String grado) {
        this.idprestamo = idprestamo;
        this.nombreLibro = nombreLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.ninho = niño;
        this.grado = grado;
    }

    public int getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(int idprestamo) {
        this.idprestamo = idprestamo;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getNinho() {
        return ninho;
    }

    public void setNinho(String ninho) {
        this.ninho = ninho;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return "prestamo{" + "idprestamo=" + idprestamo + ", nombreLibro=" + nombreLibro + ", fechaPrestamo=" + fechaPrestamo + ", niño=" + ninho + ", grado=" + grado + '}';
    }

}
