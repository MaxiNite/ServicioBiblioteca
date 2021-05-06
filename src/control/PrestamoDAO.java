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
import objetosNegocio.Prestamo;
import objetosNegocio.Utilitarios;

/**
 *
 * @author alexis
 */
public class PrestamoDAO implements IPersistencia<Prestamo> {
    Connection cn = new Conexion().getCn();
    Utilitarios uti = new Utilitarios();
    
    @Override
    public boolean Registrar(Prestamo obj) {
        boolean band = false;
        try {
            CallableStatement cs = cn.prepareCall("{call USP_PRESTAMOLIBRO(?,?,?,?)}");

            cs.setString(1, obj.getNombreLibro());
            cs.setString(2, obj.getFechaPrestamo());
            cs.setString(3, obj.getNinho());
            cs.setString(4, obj.getGrado());

            if (cs.executeUpdate() > 0) {
                band = true;
            }

        } catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }

        return band;
    }

    @Override
    public Prestamo buscar(Prestamo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Actualizar(Prestamo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Eliminar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel buscarLibroNombre(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel buscarLibroAutor(String au) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel buscarLibroGenero(String gen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DefaultTableModel lista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
