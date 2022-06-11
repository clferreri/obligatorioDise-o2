/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author bolso
 */
public class UnidadesProcesadoras {

    private String nombre;
    private ArrayList<Pedido> pedidos;
    
    
    public UnidadesProcesadoras(String nombre)
    {
        this.nombre = nombre;
        this.pedidos = new ArrayList<Pedido>();
    }
}
