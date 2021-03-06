/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.FachadaSistema;
import modelos.UsuarioGestor;
import modelos.UsuarioMozo;

/**
 *
 * @author cferreri
 */
public class ControladorGestor {
    
    private VistaSistemaGestor vista;
    private UsuarioGestor gestor;
    private FachadaSistema sistema = FachadaSistema.getInstancia();
    
    public ControladorGestor(VistaSistemaGestor vista, UsuarioGestor gestor)
    {
        this.vista = vista;
        //Agrego el observer? - leer esto
        this.gestor = gestor;
        this.mostrarUnidadesProcesadoras();
    }
    
    public boolean cerrarSesion()
    {
        return this.sistema.cerrarSesionGestor(this.gestor);
    }
    
    public void mostrarUnidadesProcesadoras() {
        try {
            vista.cargarUnidadesProcesadoras(this.sistema.getUnidadesProcesadoras());
        } catch (Exception ex) {
            vista.error(ex.getMessage());
        }
    }
    
    public void mostrarPedidosUnidadProcesadora(String unidad) {
        try {
            vista.cargarPedidosSistema(this.sistema.getPedidosUnidad(unidad));
        } catch (Exception ex) {
            vista.error(ex.getMessage());
        }
    }
}
