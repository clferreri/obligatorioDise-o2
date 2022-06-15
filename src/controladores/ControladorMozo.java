/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.FachadaSistema;
import modelos.Mesa;
import modelos.Pedido;
import modelos.Producto;
import modelos.UsuarioMozo;
import modelos.excepciones.FindMesaException;
import modelos.excepciones.MesaIsOpenException;

/**
 *
 * @author cferreri
 */
public class ControladorMozo{
    
    private VistaSistemaMozo vista;
    private UsuarioMozo mozo;
    private FachadaSistema sistema = FachadaSistema.getInstancia();
    
    public ControladorMozo(VistaSistemaMozo vista, UsuarioMozo mozo){
        this.vista = vista;
        //Agrego el observer? - leer esto
        this.mozo = mozo;
        this.mostrarMesasActivas();
    }
    
    public void mostrarMesasActivas()
    {
        try{
            vista.cargarMesasMozo(this.sistema.getMesasAsignadas(this.mozo));
        }catch(Exception ex){
            vista.error(ex.getMessage());
        }
    }
    
    
    public void cerrarSesion()
    {
        try{
            this.sistema.cerrarSesionMozo(this.mozo);
            vista.cerrarSesion();
        }catch(Exception ex){
            vista.error(ex.getMessage());
        }
    }
    
    public void cargarInfoServicioMesa(Mesa mesa)
    {
        try{
            vista.mostrarInfoServicioMesa(mesa.getServicio());
        }catch(Exception ex){
            vista.error(ex.getMessage());
        }
        
    }
    
    public void abrirMesa(int numero) 
    {
        try{
            boolean resultado = this.sistema.abrirMesa(numero);
            vista.abrirMesa(resultado);
        }catch(FindMesaException | MesaIsOpenException ex){
            vista.error(ex.getMessage());
        }
    }
    
    public void vistaAgregarProductoServicio()
    {
        try{
            vista.vistaAgregarProductoServicio(this.sistema.getProductosConStock());
        }catch(Exception ex){
            vista.error(ex.getMessage());
        }
    }
    public void AgregarProducto(Mesa mesa, Producto p, int cantidad, String descripcion){
        try{
            Pedido nuevoPedido = new Pedido(p,cantidad,descripcion, null);
            this.sistema.agregarPedido(mesa, nuevoPedido);
            vista.agregarProductoServicio();
        }catch(Exception ex){
            vista.error(ex.getMessage());
        }
    }

}
