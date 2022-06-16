/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.excepciones;

/**
 *
 * @author cferreri
 */
public class MesaIsCloseException extends Exception{
    public MesaIsCloseException() { super("La mesa está cerrada");}
    public MesaIsCloseException(String mensaje) { super (mensaje);} 
}
