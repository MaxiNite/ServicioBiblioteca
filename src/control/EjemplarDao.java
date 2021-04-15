/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import conexion.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Libro;

/**
 *
 * @author Dhtey
 */
public class EjemplarDao implements IPersistencia<Libro> {
    
    Connection cn = new Conexion().getCn();

    private List<Libro> librosED;

    public EjemplarDao() {
        ArrayList<Libro> Listalibros = new ArrayList();
    }

    @Override
    public Libro buscar(Libro obj) {

    }

    @Override
    public void Registrar(Libro obj) {

    }

    @Override
    public void Actualizar(Libro obj) {

    }

    @Override
    public void Eliminar(Libro obj) {

    }

    @Override
    public DefaultTableModel lista() {

    }

}
