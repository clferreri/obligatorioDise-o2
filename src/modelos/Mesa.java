/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author bolso
 */
public class Mesa {
    
    private int numero;
    private UsuarioMozo mozo; //NO se si sacar este dato, por ahora lo dejo ahi sin usar

    public Mesa(int numero, UsuarioMozo mozo)
    {
        this.numero = numero;
        this.mozo   = mozo;
    }
}
