/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Libro;
import objetosNegocio.Utilitarios;

/**
 *
 * @author Dhtey
 */
public class UsuarioDao implements IPersistencia<Libro> {

    Connection cn = new Conexion().getCn();
    Utilitarios uti = new Utilitarios();

    public UsuarioDao() {

    }

    @Override
    public Libro buscar(Libro obj) {
        return null;

    }

    @Override
    public boolean Registrar(Libro obj) {
        return true;
    }

    @Override
    public boolean Actualizar(Libro obj) {
        return true;
    }
    

    @Override
    public boolean Eliminar(int codigo) {
        boolean band=false;
        try {
            CallableStatement cs = cn.prepareCall("{call USP_ELIMINARUSUARIO(?)}");
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
       return null;

    

    }
    
    @Override
    public DefaultTableModel buscarLibroAutor(String aut) {
        return null;
    

    }
    
    @Override
    public DefaultTableModel buscarLibroNombre(String nom) {
        return null;

    

    }
    
    @Override
    public DefaultTableModel lista() {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("Nombre");
        mdl.addColumn("Tipo");

        
        try {
            CallableStatement cs=cn.prepareCall("{call USP_LISTADOUSUARIOS}");
            ResultSet rs=cs.executeQuery();
            
            while(rs.next()){
                Object data[]={rs.getString(2),
                               rs.getString(4)};
                
                mdl.addRow(data);
            }
            
        } catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }
        return mdl;

    }

    

}
