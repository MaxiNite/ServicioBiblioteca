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
    Utilitarios uti = new Utilitarios();
    private static String driver = "com.mysql.jdbc.Driver";
    private static String usuario = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost:3306/bd_repaso";

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
            uti.msj(e.toString(), 0);
        }
        return cn;
    }
}
