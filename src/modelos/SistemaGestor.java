/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author cferreri
 */
public class SistemaGestor {
    
    private static SistemaGestor instancia;
    
    private SistemaGestor(){
        
    }
    
    public static SistemaGestor getInsancia()
    {
        if(instancia == null){
            instancia = new SistemaGestor();
        }
        return instancia;
    }
}
