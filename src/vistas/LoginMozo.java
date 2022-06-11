/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.awt.Frame;
import javax.swing.JOptionPane;
import modelos.UsuarioMozo;
import modelos.FachadaSistema;
import modelos.excepciones.LoginException;

/**
 *
 * @author cferreri
 */
public class LoginMozo extends Login{

    public LoginMozo(Frame parent){
        super(parent, "Sistema de Mozos");
        
    }
    
    @Override
    public Object ejecutarLogin(String usu, String pwd) {
        try{
            return FachadaSistema.getInstancia().loginMozo(usu, pwd);
        }catch(LoginException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        return null; //nunca retorna null pero si no pongo esta sentencia no me deja continuar
    }

    @Override
    public void ejecutarCasoUso(Object obj) {
        try{
            this.dispose();
            PanelMozo panel = new PanelMozo((UsuarioMozo)obj);
            panel.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "LOGEADO PAPUUU", "Error", JOptionPane.ERROR_MESSAGE);
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
