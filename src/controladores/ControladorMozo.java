/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelos.FachadaSistema;
import modelos.Mesa;
import modelos.Pedido;
import modelos.Producto;
import modelos.Servicio;
import modelos.UsuarioMozo;
import modelos.excepciones.CloseSessionMozoException;
import modelos.excepciones.FindMesaException;
import modelos.excepciones.MesaIsOpenException;
import observadores.Observable;
import observadores.Observador;

/**
 *
 * @author cferreri
 */
public class ControladorMozo implements Observador{
    
    private VistaSistemaMozo vista;
    private UsuarioMozo mozo;
    private FachadaSistema sistema = FachadaSistema.getInstancia();
    
    public ControladorMozo(VistaSistemaMozo vista, UsuarioMozo mozo){
        this.vista = vista;
        this.sistema.agregar(this);
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
        }catch(CloseSessionMozoException ex){
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
    public void agregarProducto(Mesa mesa, String codigo, int cantidad, String descripcion){
        try{
            this.sistema.agregarPedido(mesa, codigo, cantidad, descripcion);
            vista.agregarProductoServicio();
            
        }catch(Exception ex){
            vista.error(ex.getMessage());
        }
    }
    
    public void cerrarMesa(int numeroMesa, int idCliente){
        try{
            Servicio s = this.sistema.cerrarMesa(numeroMesa, idCliente);
            vista.cerrarMesa(s.getNombreCliente(), s.getTotal(), s.getBeneficio(), s.getTotalBeneficio());
        }catch(Exception ex){
            vista.error(ex.getMessage());
        }
        
    }
    
    public void mozosHabilitadosTransferencia(){
        vista.vistaTransferirMesa(this.sistema.getMozosDisponiblesTransferencia(this.mozo));
    }
    
    public void transferirMesa(Mesa mesa, UsuarioMozo mozo)
    {
        try{
            this.sistema.transferirMesa(mesa, this.mozo, mozo);
            vista.vistaTransferenciaCompleta();
        }catch(Exception ex)
        {
            vista.error(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        switch ((FachadaSistema.Eventos) evento) {
            case eventoStock:
                alerta();
                break;
        }
    }
    
    private void alerta()
    {
        vista.error("ES UNA PRUEBA DE ACCIONES");
    }

}
