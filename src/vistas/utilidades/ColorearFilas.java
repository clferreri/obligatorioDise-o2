/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas.utilidades;

import java.awt.Color;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import modelos.FachadaSistema;
import modelos.Mesa;
import modelos.excepciones.FindMesaException;

/**
 *
 * @author cferreri
 */
public class ColorearFilas extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col){
        
        Mesa m = (Mesa)table.getValueAt(row, 0);
        if(m.estaAbierta()){
            setBackground(Color.GREEN);
        }else{
            setBackground(Color.GRAY);
        }
        return super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
    }
    
}
