/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import control.UsuarioDao;
import java.awt.BorderLayout;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Usuario;

/**
 *
 * @author alexis
 */
public class EliminarUsuario extends javax.swing.JFrame {
    private Connection conexion = null;
    private Statement comando = null;
    private ResultSet resultados = null;
    //private JTable tabla = null;
    DefaultTableModel modelo = null;
    /**
     * Creates new form EliminarUsuario
     */
    public EliminarUsuario() throws SQLException, ClassNotFoundException {
        initComponents();
        setLocationRelativeTo(null);
        llenarTabla();
    }
    
    UsuarioDao dao = new UsuarioDao();
    ArrayList<Usuario> usuarios = new ArrayList();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre del usuario", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazgrafica/delete.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Eliminar un Usuario");

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnEliminar)
                        .addGap(64, 64, 64)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar)
                            .addComponent(btnCancelar))
                        .addGap(35, 35, 35))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                
    private void leerDatosUsuarios() throws ClassNotFoundException, SQLException {
        String instruccion = "SELECT * FROM usuarios";
        conexion = Conexion.obtener();
        comando = (Statement) conexion.createStatement();
        resultados = comando.executeQuery(instruccion);
    }

    public void eliminar(Connection conexion, int id) throws SQLException {
        try {
            PreparedStatement consulta;

            consulta = (PreparedStatement) conexion.prepareStatement("DELETE FROM usuario WHERE usuario.id = " + id);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(this, "¡Se eliminó el usuario con exito!");
            llenarTabla();
            //conexion.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error con el registro");
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EliminarLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarTabla() throws SQLException, ClassNotFoundException {
        usuarios.removeAll(usuarios);
        this.leerDatosUsuarios();
        // Nombre de las columnas como apareceran en la tabla
        String[] columnas = {"Nombre", "Tipo"};
        modelo = new DefaultTableModel();
        String nombre, tipo;
        int id;
        Blob contraseña;

        this.setLayout(new BorderLayout());
        modelo.setColumnIdentifiers(columnas);
        tablaUsuarios.setModel(modelo);

        try {

            while (resultados.next() == true) {
                
                id = resultados.getInt("id");
                nombre = resultados.getString("nombre");
                contraseña = resultados.getBlob("pass");
                tipo = resultados.getString("tipo");

                usuarios.add(new Usuario(nombre, tipo));
                System.out.println("Se agregó: " + new Usuario(nombre, tipo).toString());

            }

            if (usuarios.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay usuarios registrados");
            } else {
                for (Usuario elemento : usuarios) {
                    modelo.addRow(new Object[]{elemento.getNombre(),  elemento.getTipo()});
                }
            }

            //this.cerrar();
        } catch (SQLException e) {
            System.out.println("Error de lectura de BD\n\n");
            e.printStackTrace();
        }

    }
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (tablaUsuarios.getSelectedRow() >= 0) {
            try {
                Usuario usuario = usuarios.get(tablaUsuarios.getSelectedRow());
                String mensaje = "¿Seguro que quiere eliminar el usuario: " + usuario.getNombre() + "?";
                int reply = JOptionPane.showConfirmDialog(null, mensaje, "Eliminar usuario", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    eliminar(Conexion.obtener(), usuario.getIdUsuario());
                } else {
                }
            } catch (SQLException ex) {
                Logger.getLogger(EliminarLibro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EliminarLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Elija un usuario a eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        tablaUsuarios.setModel(dao.lista());
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EliminarUsuario().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(EliminarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EliminarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}