/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

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
}
