/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.Objects;

/**
 *
 * @author Dario
 */
public class UsuarioMozo extends Usuario {

    private String telefono;

    public UsuarioMozo(String usuario, String contrasenia, String nombreCompleto,String telefono)
    {
        super(usuario, contrasenia, nombreCompleto);
        this.telefono = telefono;
    }


    @Override
    public boolean equals(Object obj) {
        return this.getUsuario().equals(((UsuarioMozo)obj).getUsuario());
    }
    
    
    
}
