/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelos.Pedido;
import modelos.UnidadProcesadora;

/**
 *
 * @author cferreri
 */
public interface VistaSistemaGestor {
    
    public void cerrarSesion();
    public void cargarUnidadesProcesadoras(ArrayList<UnidadProcesadora> unidades);
    public void cargarPedidosSistema(ArrayList<Pedido> pedidos);
    public void error(String mensaje);
}
