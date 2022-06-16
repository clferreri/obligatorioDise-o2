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
import observadores.Observable;
import observadores.Observador;

public class ControladorMozo implements Observador{

/**
 *
 * @author cferreri
 */ 
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
    
//    @Override
//    public void actualizar(Object evento, Observable origen) {
//
//        if ("modelo.Participacion".equals(origen.getClass().getName())) {
//
//            switch ((modelo.Participacion.Eventos) evento) {
//                case salir:
//                    this.salir();
//                    break;
//                case saldoModificado:
//                    this.setearSaldoJugador();
//                    break;
//                case juegoTerminado:
//                    this.juegoTerminado();
//                    break;
//                case modificarEstado:
//                    this.modificarEstado();
//                    break;
//
//            }
//        } else {
//
//            switch ((modelo.Juego.Eventos) evento) {
//                case terminarParticipacion:
//                    this.mostrarJugadoresActivos();
//                    break;
//                case accionRealizada:
//                    this.mostrarJugadoresActivos();
//                    break;
//                case apuestaFijada:
//                    this.mostrarApuestaActual();
//                    this.mostrarNombreJugadorApostador();
//                    break;
//                case actualizacionPozo:
//                    this.mostrarApuestaActual();
//                    this.mostrarPozoActual();
//                    break;
//                case nuevaMano:
//                    this.IniciarVentana();
//                    break;
//                case mostrarGanador:
//                    this.mostrarGanador();
//                    break;
//            }
//        }
//    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
