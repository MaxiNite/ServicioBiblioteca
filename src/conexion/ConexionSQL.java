/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import static conexion.PruebaConexion.PASSWORD;
import static conexion.PruebaConexion.URL;
import static conexion.PruebaConexion.USUARIO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author alexis
 */
public class ConexionSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
                "databaseName=servicioBiblioteca;user=biblioteca;password=biblioteca;";
            Connection con = DriverManager.getConnection(connectionUrl);
            System.out.println("Conexion exitosa");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Genero");

            while(rs.next()){
                String nombre = rs.getString(1);
                System.out.println(nombre);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
