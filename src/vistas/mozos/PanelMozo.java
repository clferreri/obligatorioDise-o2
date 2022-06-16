package vistas.mozos;

import controladores.ControladorMozo;
import controladores.VistaSistemaMozo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        this.configuracion();
        this.lblNombreMozo.setText(u.getNombreCompleto());
        this.controlador = new ControladorMozo(this,u);
    }
    
    
    private void configuracion()
    {
        this.setTitle("Sistema de Mozos");
        this.setLocationRelativeTo(null);
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
        pnlBotonesAgregarProducto1 = new javax.swing.JPanel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mozo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 6, -1, -1));

        lblNombreMozo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreMozo.setText("jLabel2");
        getContentPane().add(lblNombreMozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 6, -1, -1));

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 38, 165, 219));

        pnlContenido.setMaximumSize(new java.awt.Dimension(400, 350));
        pnlContenido.setMinimumSize(new java.awt.Dimension(400, 350));

        javax.swing.GroupLayout pnlContenidoLayout = new javax.swing.GroupLayout(pnlContenido);
        pnlContenido.setLayout(pnlContenidoLayout);
        pnlContenidoLayout.setHorizontalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );
        pnlContenidoLayout.setVerticalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        getContentPane().add(pnlContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 38, 616, 270));

        btnAbrirMesa.setText("Abrir Mesa");
        btnAbrirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirMesaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbrirMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 271, 165, 37));

        pnlBotonesAgregarProducto1.setToolTipText("");

        javax.swing.GroupLayout pnlBotonesAgregarProducto1Layout = new javax.swing.GroupLayout(pnlBotonesAgregarProducto1);
        pnlBotonesAgregarProducto1.setLayout(pnlBotonesAgregarProducto1Layout);
        pnlBotonesAgregarProducto1Layout.setHorizontalGroup(
            pnlBotonesAgregarProducto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnlBotonesAgregarProducto1Layout.setVerticalGroup(
            pnlBotonesAgregarProducto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        getContentPane().add(pnlBotonesAgregarProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 400, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void tblMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMesasMouseClicked
        this.mostrarInfoMesa();
    }//GEN-LAST:event_tblMesasMouseClicked

    private void btnAbrirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirMesaActionPerformed
        this.abrirMesa();
    }//GEN-LAST:event_btnAbrirMesaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
          this.controlador.cerrarSesion();
    }//GEN-LAST:event_formWindowClosing

    
    protected void mostrarInfoMesa(){
        int row = this.tblMesas.getSelectedRow();
        this.controlador.cargarInfoServicioMesa((Mesa)this.tblMesas.getValueAt(row, 0));
    }
    
    private void abrirMesa()
    {
        int row = this.tblMesas.getSelectedRow();
        this.controlador.abrirMesa(Integer.parseInt(this.tblMesas.getValueAt(row, 0).toString()));
    }
    
    public void agregarProductoView(Servicio servicioMesa){
        this.controlador.vistaAgregarProductoServicio();
    }
    
    public void cerrarMesaView(){
        this.cargarContenido(new CerrarMesa(this));
    }
    
    public void cerrarMesa(String idCliente)
    {
        try{
            int id = -1;
            if(!idCliente.isBlank()){
                id = Integer.parseInt(idCliente);
            }
            int row = this.tblMesas.getSelectedRow();
            this.controlador.cerrarMesa(((Mesa)this.tblMesas.getValueAt(row, 0)).getNumero(), id);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "El id solo puede ser numerico.");
        }
    }
    
    public void agregarProducto(String codigo, int cantidad, String descripcion)
    {
        if(codigo.isBlank()){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto.");
        }
        if(cantidad < 1){
            JOptionPane.showMessageDialog(this, "Cantidad inválida.");
        }
        
        int row = this.tblMesas.getSelectedRow();
        this.controlador.agregarProducto((Mesa)this.tblMesas.getValueAt(row, 0), codigo, cantidad, descripcion);
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
    private javax.swing.JPanel pnlBotonesAgregarProducto1;
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
            this.cargarContenido(new InfoServicioMesa(servicioMesa, this));
        }else{
            this.pnlContenido.removeAll();
            this.pnlContenido.revalidate();
            this.pnlContenido.repaint();
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
    public void vistaAgregarProductoServicio(ArrayList<Producto> productos) {
        AgregarProductoServicio ap = new AgregarProductoServicio(this, productos);
        this.cargarContenido(ap);
    }
    
    @Override
    public void agregarProductoServicio() {
        JOptionPane.showMessageDialog(this, "Producto agregado correctamente");
        this.mostrarInfoMesa();
    }

    @Override
    public void cerrarMesa(String cliente, float total, String beneficio, float totalBeneficio) {
        this.cargarContenido(new DetalleCierreMesa(cliente, total, beneficio, totalBeneficio));
    }

    @Override
    public void transferirMesa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void error(String mensage) {
        JOptionPane.showMessageDialog(this, mensage);
    }


}
