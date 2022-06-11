/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.awt.Frame;

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
        System.out.print("GESTOR");
        return new Object();
    }

    @Override
    public void ejecutarCasoUso(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
