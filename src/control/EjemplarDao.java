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

    }

    @Override
    public void Registrar(Libro obj) {

    }

    @Override
    public void Actualizar(Libro obj) {
         boolean band=false;
        try {
            CallableStatement cs = cn.prepareCall("{call USP_ACTUALIZAREJEMPLAR(?,?,?,?,?,?,?)}");
            cs.setInt(1, obj.getCodigo());
            cs.setString(1, obj.getNombre());
            cs.setString(2, obj.getPaterno());
            cs.setString(3, obj.getMaterno());
            cs.setString(4, obj.getDni());
            cs.setString(5, obj.getGenero());
            cs.setString(6, obj.getEspecialidad());
            
            if(cs.executeUpdate()>0)
                band=true;
            
        } catch (Exception ex) {
            uti.msj(ex.toString(), 0);
        }
        
        return band;
        /*DELIMITER $$
CREATE PROCEDURE USP_ACTUALIZARALUMNO
(
cod  int,
nom varchar(25),
pat varchar(25),
mat varchar(25),
dn varchar(8),
gen varchar(1),
esp varchar(30)
)
BEGIN
update tb_alumno
set nombre=nom,paterno=pat,materno=mat,dni=dn,genero=gen,especialidad=esp
where codigo=cod;
END$$
DELIMITER ;*/
        
    }

    @Override
    public void Eliminar(Libro obj) {

    }

    @Override
    public DefaultTableModel lista() {

    }

}
