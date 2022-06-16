package vistas;

import controladores.ControladorMozo;
import controladores.VistaSistemaMozo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Mesa;
import modelos.Producto;
import modelos.Servicio;
import modelos.UsuarioMozo;
import modelos.excepciones.FindMesaException;
import modelos.excepciones.MesaIsOpenException;
import vistas.utilidades.ColorearFilas;

/**
 *
 * @author cferreri
 */
public class PanelMozo extends javax.swing.JFrame implements VistaSistemaMozo{

    private ControladorMozo controlador;
    /**
     * Creates new form PanelMozos
     */
    public PanelMozo(UsuarioMozo u) {
        initComponents();
        this.setTitle("Sistema de Mozos");
        this.setLocationRelativeTo(null);
        this.lblNombreMozo.setText(u.getNombreCompleto());
        this.controlador = new ControladorMozo(this,u);
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblNombreMozo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMesas = new javax.swing.JTable();
        pnlContenido = new javax.swing.JPanel();
        btnAbrirMesa = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mozo:");

        lblNombreMozo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreMozo.setText("jLabel2");

        tblMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Mesa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMesasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMesas);
        if (tblMesas.getColumnModel().getColumnCount() > 0) {
            tblMesas.getColumnModel().getColumn(0).setResizable(false);
        }

        pnlContenido.setMaximumSize(new java.awt.Dimension(400, 350));
        pnlContenido.setMinimumSize(new java.awt.Dimension(400, 350));

        javax.swing.GroupLayout pnlContenidoLayout = new javax.swing.GroupLayout(pnlContenido);
        pnlContenido.setLayout(pnlContenidoLayout);
        pnlContenidoLayout.setHorizontalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlContenidoLayout.setVerticalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnAbrirMesa.setText("Abrir Mesa");
        btnAbrirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreMozo)
                        .addGap(0, 582, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnAbrirMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNombreMozo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAbrirMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addComponent(pnlContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.cerrarSesion();
    }//GEN-LAST:event_formWindowClosed

    private void tblMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMesasMouseClicked
        this.mostrarInfoMesa();
    }//GEN-LAST:event_tblMesasMouseClicked

    private void btnAbrirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirMesaActionPerformed
        this.abrirMesa();
    }//GEN-LAST:event_btnAbrirMesaActionPerformed

    private void mostrarInfoMesa(){
        int row = this.tblMesas.getSelectedRow();
        this.controlador.cargarInfoServicioMesa((Mesa)this.tblMesas.getValueAt(row, 0));
    }
    
    private void abrirMesa()
    {
        try{
            int row = this.tblMesas.getSelectedRow();
            this.controlador.abrirMesa(Integer.parseInt(this.tblMesas.getValueAt(row, 0).toString()));
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblNombreMozo;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JTable tblMesas;
    // End of variables declaration//GEN-END:variables

    
    private void cargarContenido(javax.swing.JPanel panel)
    {
        panel.setSize(600,300);
        this.pnlContenido.removeAll();
        pnlContenido.add(panel);
        pnlContenido.revalidate();
        pnlContenido.repaint();
    }
    @Override
    public void cerrarSesion() {
        this.controlador.cerrarSesion();
        this.dispose();
    }

    @Override
    public void cargarMesasMozo(ArrayList<Mesa> mesas){ 
        ColorearFilas colorear = new ColorearFilas();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mesas");
        for(Mesa m : mesas){
            model.addRow(new Object[]{m});
        }
        this.tblMesas.setModel(model);
        this.tblMesas.getColumnModel().getColumn(0);
        this.tblMesas.setDefaultRenderer(this.tblMesas.getColumnClass(0), colorear);
    }

    @Override
    public void mostrarInfoServicioMesa(Servicio servicioMesa) {
        if(servicioMesa != null){
            this.cargarContenido(new InfoServicioMesa(servicioMesa));
        }
    }

    @Override
    public void abrirMesa(boolean resultado) {
        if(resultado){
            JOptionPane.showMessageDialog(this, "Mesa abierta correctamente.");
            this.mostrarInfoMesa();
        }else{
            JOptionPane.showMessageDialog(this, "No se pudo abrir la mesa.");
        }
    }

    @Override
    public void error(String mensage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void vistaAgregarProductoServicio(ArrayList<Producto> productos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarProductoServicio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cerrarMesa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void transferirMesa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
