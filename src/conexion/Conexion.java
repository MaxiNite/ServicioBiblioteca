/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
import objetosNegocio.Utilitarios;

/**
 *
 * @author Dhtey
 */
public class Conexion {
    
    Connection cn = null;
    Utilitarios uti = new Utilitarios();
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String usuario = "adminBiblioteca";
    private static String password = "biblioteca";
    private static String url = "jdbc:mysql://localhost:3306/serviciobiblioteca";

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Proyecto", 0);
        }
    }

    public Connection getCn(){
        try {
            cn =(Connection) DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            uti.msj(e.toString(), 0);
        }
        return cn;
    }
}
