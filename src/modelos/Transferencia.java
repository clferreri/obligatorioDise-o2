/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author cferreri
 */
public class Transferencia {
    private UsuarioMozo mozoOrigen;
    private UsuarioMozo mozoDestino;
    private Mesa mesa;
    
    
    public Transferencia(UsuarioMozo mozoOrigen, UsuarioMozo mozoDestino, Mesa mesa)
    {
        this.mozoOrigen = mozoOrigen;
        this.mozoDestino = mozoDestino;
        this.mesa = mesa;
    }
}
