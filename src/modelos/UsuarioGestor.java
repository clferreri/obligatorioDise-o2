/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dario
 */
public class UsuarioGestor extends Usuario{

    public UsuarioGestor(String usuario, String contrasenia, String nombreCompleto, Date ultimoAcceso, UnidadesProcesadoras unidad) {
        super(usuario, contrasenia, nombreCompleto);
        this.ultimoAcceso = ultimoAcceso;
        this.unidad = unidad;
        this.pedidos = new ArrayList<Pedido>();
    }
    
    
   private Date ultimoAcceso;
   private UnidadesProcesadoras unidad;
   private ArrayList<Pedido> pedidos;

}
