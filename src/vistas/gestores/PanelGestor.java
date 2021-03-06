/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.gestores;

import controladores.ControladorGestor;
import controladores.VistaSistemaGestor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Pedido;
import modelos.UnidadProcesadora;
import modelos.UsuarioGestor;

/**
 *
 * @author cferreri
 */
public class PanelGestor extends javax.swing.JFrame implements VistaSistemaGestor{

    private ControladorGestor controlador;
    /**
     * Creates new form PanelGestor
     */
    public PanelGestor(UsuarioGestor u) {
        initComponents();
        this.setTitle("Sistema de Gestores");
        this.setLocationRelativeTo(null);
        this.controlador = new ControladorGestor(this,u);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbUnidades = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSeleccionarUnidad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        cmbUnidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una unidad..." }));

        jLabel1.setText("Unidad procesadora:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 753, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnSeleccionarUnidad.setText("Seleccionar unidad");
        btnSeleccionarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarUnidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbUnidades, 0, 163, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(btnSeleccionarUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 437, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.cerrarSesion();
    }//GEN-LAST:event_formWindowClosed

    private void btnSeleccionarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarUnidadActionPerformed
        this.monitorUnidad(this.cmbUnidades.getSelectedItem().toString());
    }//GEN-LAST:event_btnSeleccionarUnidadActionPerformed

    private void monitorUnidad(String unidad) {
        this.controlador.mostrarPedidosUnidadProcesadora(unidad);
    }
    
    private void cargarContenido(javax.swing.JPanel panel) {
        panel.setSize(700, 500);
        this.jPanel1.removeAll();
        this.cmbUnidades.setEnabled(false);
        this.btnSeleccionarUnidad.setEnabled(false);

        jPanel1.add(panel);
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    @Override
    public void cerrarSesion() {
        this.controlador.cerrarSesion();
        this.dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionarUnidad;
    private javax.swing.JComboBox<String> cmbUnidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarUnidadesProcesadoras(ArrayList<UnidadProcesadora> unidades) {
        for (UnidadProcesadora u : unidades) {
            cmbUnidades.addItem(u.getNombre());
        }
    }

    @Override
    public void cargarPedidosSistema(ArrayList<Pedido> pedidos) {
        PedidosUnidad pe = new PedidosUnidad(this, pedidos);
        this.cargarContenido(pe);
    }

    @Override
    public void error(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
