/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.excepciones;

/**
 *
 * @author cferreri
 */
public class CloseSessionMozoException extends Exception{
    public CloseSessionMozoException() { super("Debe cerrar las mesas abiertas antes de salir");}
}
