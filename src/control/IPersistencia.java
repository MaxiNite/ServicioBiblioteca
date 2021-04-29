/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dhtey
 */
public interface IPersistencia <T>{
    public T buscar(T obj);
    public boolean Registrar(T obj);
    public boolean Actualizar(T obj);
    public boolean Eliminar(int codigo);
    DefaultTableModel buscarLibroNombre(String nom);
    DefaultTableModel buscarLibroAutor(String au);
    DefaultTableModel buscarLibroGenero(String gen);
    DefaultTableModel lista();
}
