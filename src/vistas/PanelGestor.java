package vistas;


import java.util.ArrayList;
import modelos.UsuarioGestor;
import modelos.UnidadProcesadora;
import controladores.VistaMonitorPedidos;
import controladores.ControladorMonitorPedidos;
import javax.swing.JOptionPane;


public class PanelGestor extends javax.swing.JFrame implements VistaMonitorPedidos {

    private ControladorMonitorPedidos controlador;
    private ArrayList<UnidadProcesadora> unidades;

    /**
     * Creates new form PanelGestor
     */
    public PanelGestor(UsuarioGestor u) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controlador = new ControladorMonitorPedidos(this, u);
        this.setTitle("PROCESADORA DE PEDIDOS - USUARIO LOGUEADO: " + u.getNombreCompleto());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListUnidadesPro = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jButtonSeleccionarUnidad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROCESADORA DE PEDIDOS");

        jListUnidadesPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListUnidadesProMouseClicked(evt);
            }
        });
        jListUnidadesPro.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListUnidadesProValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListUnidadesPro);

        jLabel2.setText("Unidades Procesadoras");

        jButtonSeleccionarUnidad.setText("Seleccionar Unidad");
        jButtonSeleccionarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarUnidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButtonSeleccionarUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSeleccionarUnidad)
                .addGap(0, 151, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.cerrarSesion();
    }//GEN-LAST:event_formWindowClosed

    private void jListUnidadesProValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListUnidadesProValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jListUnidadesProValueChanged

    private void jListUnidadesProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListUnidadesProMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jListUnidadesProMouseClicked

    private void jButtonSeleccionarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarUnidadActionPerformed
        this.ejecutarCasoDeUsoGestor();
    }//GEN-LAST:event_jButtonSeleccionarUnidadActionPerformed

    @Override
    public void cerrarSesion() {
        this.controlador.cerrarSesion();
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSeleccionarUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jListUnidadesPro;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarUnidadesProcesadoras(ArrayList<UnidadProcesadora> unidadesProcesadoras) {
        this.unidades=unidadesProcesadoras;
        ArrayList<String> lista = new ArrayList();

        for (UnidadProcesadora u : unidadesProcesadoras) {
            lista.add(u.getNombre());
        }
        jListUnidadesPro.setListData(lista.toArray());

    }

    private void ejecutarCasoDeUsoGestor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
