/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import objetosNegocio.Libro;

/**
 *
 * @author Dhtey
 */
public interface IPersistencia {
    public void RegistrarLibro(Libro libro);
    public void ActualizarLibro(Libro libro);
    public void EliminarLibro(Libro libro);
    public void BuscarLibro(Libro libro);
    public void PrestarLibro(Libro libro);
}
