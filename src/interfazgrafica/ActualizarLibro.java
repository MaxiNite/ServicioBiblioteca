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
import control.EjemplarDao;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Libro;

/**
 *
 * @author Asus
 */
public class ActualizarLibro extends javax.swing.JFrame {

    public Libro libroAuxiliar;
    private Connection conexion = null;
    private Statement comando = null;
    private ResultSet resultados = null;
    //private JTable tabla = null;
    DefaultTableModel modelo = null;
    EjemplarDao dao = new EjemplarDao();
    ArrayList<Libro> libros = new ArrayList();

    /**
     * Creates new form ActualizarLibro
     */
    public ActualizarLibro() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        btnContinuar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Actualizar Libro");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar un Libro");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfazgrafica/refresh.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Por favor, seleccione el libro que desee actualizar:");

        tablaLibros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre del Libro", "Autor", "Género", "Descripción", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaLibros);

        btnContinuar.setBackground(new java.awt.Color(0, 255, 0));
        btnContinuar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btnContinuar)
                        .addGap(124, 124, 124)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinuar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        EjemplarDao dao = new EjemplarDao();
        tablaLibros.setModel(dao.lista());
        try {
            llenarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(ActualizarLibro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ActualizarLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void leerDatosLibros() throws ClassNotFoundException, SQLException {
        String instruccion = "SELECT * FROM libro";
        conexion = Conexion.obtener();
        comando = (Statement) conexion.createStatement();
        resultados = comando.executeQuery(instruccion);
    }

    private void llenarTabla() throws SQLException, ClassNotFoundException {
        libros.removeAll(libros);
        this.leerDatosLibros();
        // Nombre de las columnas como apareceran en la tabla
        String[] columnas = {"Codigo", "Nombre", "Descripcción", "Autor", "Genero", "Cantidad"};
        modelo = new DefaultTableModel();
        int id, cantidad;
        String nombre, descripcion, genero, autor;

        this.setLayout(new BorderLayout());
        modelo.setColumnIdentifiers(columnas);
        tablaLibros.setModel(modelo);

        try {

            while (resultados.next() == true) {
                id = resultados.getInt("id_libro");
                nombre = resultados.getString("nombre");
                descripcion = resultados.getString("descripcion");
                autor = resultados.getString("autor");
                genero = resultados.getString("genero");
                cantidad = resultados.getInt("cantidad");

                libros.add(new Libro(id, nombre, descripcion, autor, genero, cantidad));
                System.out.println("Se agregó: " + new Libro(id, nombre, descripcion, autor, genero, cantidad).toString());

            }

            if (libros.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay libros registrados");
            } else {
                for (Libro elemento : libros) {
                    modelo.addRow(new Object[]{elemento.getId(), elemento.getNombre(), elemento.getDescripccion(), elemento.getAutor(), elemento.getGenero(), elemento.getCantidad()});
                }
            }

            //this.cerrar();
        } catch (SQLException e) {
            System.out.println("Error de lectura de BD\n\n");
            e.printStackTrace();
        }

    }
    
    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed

        // TODO add your handling code here:
        //codigo agregar
        if (tablaLibros.getSelectedRowCount() >= 0) {

            String id = tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 0).toString();
            int idN = Integer.parseInt(id);
            String nombre = tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 1).toString();
            String descripcion = tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 2).toString();
            String autor = tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 3).toString();
            String genero = tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 4).toString();
            String cantidad = tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 5).toString();
            int can = Integer.parseInt(cantidad);
            System.out.println(idN+nombre+descripcion+autor+genero+can);
            
            Libro libro = new Libro(idN,nombre,descripcion,autor,genero,can);

            ActualizarLibro2 actualizarLibro2 = new ActualizarLibro2(libro);
            actualizarLibro2.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Elija un libro a actualizar");
        }


    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ActualizarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLibros;
    // End of variables declaration//GEN-END:variables
}
