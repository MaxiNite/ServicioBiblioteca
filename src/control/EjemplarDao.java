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

/**
 *
 * @author Dhtey
 */
public class EjemplarDao implements IPersistencia<Libro> {
    
    Connection cn = new Conexion().getCn();

   

    public EjemplarDao() {
        
    }

    @Override
    public Libro buscar(Libro obj) {
        return null;

    }

    @Override
    public void Registrar(Libro obj) {
      boolean band=false;
        try {
            CallableStatement cs = cn.prepareCall("{call USP_AGREGAREJEMPLAR(?,?,?,?,?)}");
            
            cs.setString(1, obj.getNombre());
            cs.setString(2, obj.getAutor());
            cs.setString(3, obj.getDescripccion());
            cs.setString(4, obj.getGenero());
            cs.setInt(5, obj.getCantidad());
            
            if(cs.executeUpdate()>0)
                band=true;
            
        } catch (Exception ex) {
            ex.getStackTrace();
            //uti.msj(ex.toString(), 0);
        }    
    }

    @Override
    public void Actualizar(Libro obj) {
         boolean band=false;
        try {
            CallableStatement cs = cn.prepareCall("{call USP_ACTUALIZAREJEMPLAR(?,?,?,?,?,?)}");
            
            cs.setString(1, obj.getNombre());
            cs.setString(2, obj.getAutor());
            cs.setString(3, obj.getDescripccion());
            cs.setString(4, obj.getGenero());
            cs.setInt(5, obj.getCantidad());
            cs.setString(6, obj.toString());
            
            if(cs.executeUpdate()>0)
                band=true;
            
        } catch (Exception ex) {
            ex.getStackTrace();
            //uti.msj(ex.toString(), 0);
        }
        
    }

    @Override
    public void Eliminar(Libro obj) {

    }

    @Override
    public DefaultTableModel lista() {
        return null;

    }

}
