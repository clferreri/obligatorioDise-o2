/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.excepciones;

/**
 *
 * @author cferreri
 */
public class MesaWithPendingOrdersException extends Exception{
    public MesaWithPendingOrdersException() { super("Tiene pedidos pendientes");}
}
