/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import javax.swing.table.DefaultTableModel;
import modelos.Pedido;
import modelos.Servicio;

/**
 *
 * @author cferreri
 */
public class InfoServicioMesa extends javax.swing.JPanel {

    /**
     * Creates new form InfoServicioMesa
     */
    public InfoServicioMesa(Servicio servicio) {
        initComponents();
        int numeroMesa = servicio.getMesa().getNumero();
        this.lblNumeroMesa.setText(Integer.toString(numeroMesa));
        this.cargarTabla(servicio);
    }
    
    public void cargarTabla(Servicio servicio)
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Procesadora");
        model.addColumn("Estado");
        model.addColumn("Descripcion");
        
        for(Pedido p : servicio.getPedidos()){
            //model.addRow(new Object[]{p.getProducto(), p.getCantidad(), p.getProducto().getUnidadProcesadora(), p.getEstado(), p.getDescripcion()});
        }     
        this.tblServicio.setModel(model);
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
        lblNumeroMesa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicio = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(600, 350));
        setMinimumSize(new java.awt.Dimension(600, 350));
        setPreferredSize(new java.awt.Dimension(400, 200));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nro Mesa");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblNumeroMesa.setText("jLabel2");
        add(lblNumeroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        tblServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Producto", "Cantidad", "Descripcion", "Procesadora", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblServicio);
        if (tblServicio.getColumnModel().getColumnCount() > 0) {
            tblServicio.getColumnModel().getColumn(0).setResizable(false);
            tblServicio.getColumnModel().getColumn(1).setResizable(false);
            tblServicio.getColumnModel().getColumn(2).setResizable(false);
            tblServicio.getColumnModel().getColumn(3).setResizable(false);
            tblServicio.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 500, 160));

        jButton1.setText("Cerrar Mesa");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, 30));

        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 150, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        AgregarProductoServicio ag = new AgregarProductoServicio();
        ag.setVisible(true);
    }//GEN-LAST:event_btnAgregarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumeroMesa;
    private javax.swing.JTable tblServicio;
    // End of variables declaration//GEN-END:variables
}
