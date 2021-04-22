/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Libro;
import objetosNegocio.Utilitarios;

/**
 *
 * @author Dhtey
 */
public class EjemplarDao implements IPersistencia<Libro> {

    Connection cn = new Conexion().getCn();
    Utilitarios uti = new Utilitarios();

    public EjemplarDao() {

    }

    @Override
    public Libro buscar(Libro obj) {
        return null;

    }

    @Override
    public boolean Registrar(Libro obj) {
        boolean band = false;
        try {
            CallableStatement cs = cn.prepareCall("{call USP_AGREGARLIBRO(?,?,?,?,?)}");

            cs.setString(1, obj.getNombre());
            cs.setString(2, obj.getAutor());
            cs.setString(3, obj.getDescripccion());
            cs.setString(4, obj.getGenero());
            cs.setInt(5, obj.getCantidad());

            if (cs.executeUpdate() > 0) {
                band = true;
            }

        } catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }

        return band;
    }

    @Override
    public boolean Actualizar(Libro obj) {
        boolean band = false;
        try {
            CallableStatement cs = cn.prepareCall("{call USP_ACTUALIZARLIBRO(?,?,?,?,?,?)}");

            cs.setInt(1, obj.getId());
            cs.setString(2, obj.getNombre());
            cs.setString(3, obj.getAutor());
            cs.setString(4, obj.getDescripccion());
            cs.setString(5, obj.getGenero());
            cs.setInt(6, obj.getCantidad());

            if (cs.executeUpdate() > 0) {
                band = true;
            }

        } catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }

        return band;
    }

    @Override
    public boolean Eliminar(Libro obj) {
        return true;
    }

    @Override
    public DefaultTableModel lista() {
        return null;

    }

}
