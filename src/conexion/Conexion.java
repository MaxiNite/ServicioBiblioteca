/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Dhtey
 */
public class Conexion {
    
    Connection cn = null;
//    Utilitarios uti = new Utilitarios();
    private static String driver = "com.mysql.jdbc.Driver";
    private static String usuario = "biblioteca";
    private static String password = "biblioteca";
    private static String url = "jdbc:mysql://26.19.68.139/servicioBiblioteca";

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Proyecto", 0);
        }
    }

    public Connection getCn(){
        try {
            cn = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            e.getStackTrace();
//            uti.msj(e.toString(), 0);
        }
        return cn;
    }
}
