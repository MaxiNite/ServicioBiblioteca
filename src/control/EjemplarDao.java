/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import conexion.Conexion;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Libro;
import objetosNegocio.Prestamo;
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
            cs.setString(2, obj.getDescripccion());
            cs.setString(3, obj.getAutor());
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
            cs.setString(3, obj.getDescripccion());
            cs.setString(4, obj.getAutor());
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
    public boolean Eliminar(int codigo) {
        boolean band=false;
        try {
            CallableStatement cs = cn.prepareCall("{call USP_ELIMINARLIBRO(?)}");
            cs.setInt(1, codigo);
            
            if(cs.executeUpdate()>0)
                band=true;
            
        } catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }
        
        return band;
    }
    
    

    @Override
    public DefaultTableModel buscarLibroGenero(String gen) {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("Codigo");
        mdl.addColumn("Nombre");
        mdl.addColumn("Descripción");
        mdl.addColumn("Autor");
        mdl.addColumn("Genero");
        mdl.addColumn("Cantidad");
        
        try {
            CallableStatement cs=cn.prepareCall("{call USP_LISTADOLIBROGENERO(?)}");
            cs.setString(1, gen);
            ResultSet rs=cs.executeQuery();
            
            while(rs.next()){
                Object data[]={rs.getString(1),rs.getString(2),
                               rs.getString(3),rs.getString(4),
                               rs.getString(5),rs.getString(6)};
                
                mdl.addRow(data);
            }
            
        } catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }
        return mdl;

    

    }
    
    @Override
    public DefaultTableModel buscarLibroAutor(String aut) {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("Codigo");
        mdl.addColumn("Nombre");
        mdl.addColumn("Descripción");
        mdl.addColumn("Autor");
        mdl.addColumn("Genero");
        mdl.addColumn("Cantidad");
        
        try {
            CallableStatement cs=cn.prepareCall("{call USP_LISTADOLIBROAUTOR(?)}");
            cs.setString(1, aut);
            ResultSet rs=cs.executeQuery();
            
            while(rs.next()){
                Object data[]={rs.getString(1),rs.getString(2),
                               rs.getString(3),rs.getString(4),
                               rs.getString(5),rs.getString(6)};
                
                mdl.addRow(data);
            }
            
        } catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }
        return mdl;

    

    }
    
    @Override
    public DefaultTableModel buscarLibroNombre(String nom) {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("Codigo");
        mdl.addColumn("Nombre");
        mdl.addColumn("Descripción");
        mdl.addColumn("Autor");
        mdl.addColumn("Genero");
        mdl.addColumn("Cantidad");
        
        try {
            CallableStatement cs=cn.prepareCall("{call USP_LISTADOLIBRONOMBRE(?)}");
            cs.setString(1, nom);
            ResultSet rs=cs.executeQuery();
            
            while(rs.next()){
                Object data[]={rs.getString(1),rs.getString(2),
                               rs.getString(3),rs.getString(4),
                               rs.getString(5),rs.getString(6)};
                
                mdl.addRow(data);
            }
            
        } catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }
        return mdl;

    

    }
    
    @Override
    public DefaultTableModel lista() {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("Codigo");
        mdl.addColumn("Nombre");
        mdl.addColumn("Descripción");
        mdl.addColumn("Autor");
        mdl.addColumn("Genero");
        mdl.addColumn("Cantidad");
        
        try {
            CallableStatement cs=cn.prepareCall("{call USP_LISTADOLIBROS}");
            ResultSet rs=cs.executeQuery();
            
            while(rs.next()){
                Object data[]={rs.getString(1),rs.getString(2),
                               rs.getString(3),rs.getString(4),
                               rs.getString(5),rs.getString(6)};
                
                mdl.addRow(data);
            }
            
        } catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }
        return mdl;

    }

    

}
