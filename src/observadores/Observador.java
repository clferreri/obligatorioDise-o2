/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observadores;

/**
 *
 * @author cferreri
 */
public interface Observador {
    
    public void actualizar(Object evento,Observable origen);  
}
