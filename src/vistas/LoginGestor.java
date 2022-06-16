/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import vistas.gestores.PanelGestor;
import java.awt.Frame;
import javax.swing.JOptionPane;
import modelos.FachadaSistema;
import modelos.UsuarioGestor;

/**
 *
 * @author cferreri
 */
public class LoginGestor extends Login{

    public LoginGestor(Frame parent){
        super(parent, "Sistema de Gestores");
    }
    
    @Override
    public Object ejecutarLogin(String usu, String pwd) {
        try{
            return FachadaSistema.getInstancia().loginGestor(usu, pwd);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        return null; //nunca retorna null pero si no pongo esta sentencia no me deja continuar
    }

    @Override
    public void ejecutarCasoUso(Object obj) {
        try{
            this.dispose();
            PanelGestor panel = new PanelGestor((UsuarioGestor)obj);
            panel.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
}
