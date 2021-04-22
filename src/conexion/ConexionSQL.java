/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionSQL extends javax.swing.JFrame {

    // Declaramos la conexion a mysql
    private static Connection con;
    // Declaramos los datos de conexion a la bd
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "adminBiblioteca";
    private static final String pass = "biblioteca";
    private static final String url = "jdbc:mysql://localhost:3306/serviciobiblioteca";

    // Funcion que va conectarse a mi bd de mysql
    public void conector() {
        // Reseteamos a null la conexion a la bd
        con = null;
        try {
            Class.forName(driver);
            // Nos conectamos a la bd
            con = (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con != null) {
                JOptionPane.showMessageDialog(null, "Conexion establecida");
            }
        } // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Error de conexion" + e);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
}
