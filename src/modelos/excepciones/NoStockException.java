/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.excepciones;

/**
 *
 * @author cferreri
 */
public class NoStockException extends Exception{
    public NoStockException(int stock) { super("Sin stock, solo quedan (" + stock +")");}
}
