
package modelos;

import java.util.ArrayList;
import modelos.excepciones.ClientNotFoundException;
import modelos.excepciones.CloseSessionMozoException;
import modelos.excepciones.FindMesaException;
import modelos.excepciones.LoginException;
import modelos.excepciones.MesaIsCloseException;
import modelos.excepciones.MesaIsOpenException;
import modelos.excepciones.MesaWithPendingOrdersException;
import modelos.excepciones.NoCountException;
import modelos.excepciones.NoStockException;
import observadores.Observable;

public class FachadaSistema extends Observable{
    
    private SistemaUsuarios sUsuario = SistemaUsuarios.getInstancia();
    private SistemaRestaurante sRestaurante = SistemaRestaurante.getInsancia();
    private static FachadaSistema instancia = new FachadaSistema();
    
    private FachadaSistema(){}
    public static FachadaSistema getInstancia()
    {
        return instancia;
    }
    
    public enum Eventos {
        eventoStock 
    };
    
    //<editor-fold desc="Seccion de Sistema Mozos">
    
    /**
     * Inicia sesion de un mozo (en el sistema de mozos)
     * @param usu usuario del mozo
     * @param pass contraseña del mozo
     * @return usuarioMozo que inicio sesion
     * @throws Exception El usuario/contraseña son incorrectos o el usuario ya esta logeado
     */
    public UsuarioMozo loginMozo(String usu, String pass) throws Exception 
    {
        return sUsuario.loginMozo(usu, pass);
    }
    
    /**
     * Cierra la sesion de un mozo limpiandolo de las sesiones activas
     * @param mozo mozo que esta cerrando la sesion
     * @return si se cerro correctamente la sesion
     */
    public boolean cerrarSesionMozo(UsuarioMozo mozo) throws CloseSessionMozoException
    {
        return this.sUsuario.cerrarSesionMozo(mozo);
    }
      
      
    public ArrayList<Mesa> getMesasAsignadas(UsuarioMozo mozo)
    {
        return this.sRestaurante.getMesasAsignadas(mozo);
    }
    
    public Mesa getMesa(int numero) throws FindMesaException
    {
        return this.sRestaurante.obtenerMesa(numero);
    }
    
    public boolean abrirMesa(int numero) throws FindMesaException, MesaIsOpenException
    {
        return this.sRestaurante.abrirMesa(numero);
    }
   
    
    public boolean agregarPedido(Mesa mesa, String codigo, int cantidad, String descripcion) throws NoStockException, NoCountException, MesaIsCloseException
    {
        return this.sRestaurante.agregarPedido(mesa, codigo, cantidad, descripcion);
    }
    
    public ArrayList<Producto> getProductosConStock()
    {
        return this.sRestaurante.getProductosConStock();
    }
    
    public Servicio cerrarMesa(int numeroMesa, int idCliente) throws MesaIsCloseException, MesaWithPendingOrdersException, ClientNotFoundException
    {
       return this.sRestaurante.cerrarMesa(numeroMesa, idCliente);
    }
    
    public ArrayList<UsuarioMozo> getMozosDisponiblesTransferencia(UsuarioMozo mozo)
    {
        return this.sRestaurante.getMozosDisponiblesTransferencia(mozo);
    }
    
    public boolean transferirMesa(Mesa mesa,UsuarioMozo mozoOrigen, UsuarioMozo mozoDestino) throws FindMesaException
    {
        return this.sRestaurante.transferirMesa(mesa, mozoOrigen, mozoDestino);
    }
    
    //</editor-fold>
    
    
    
    //<editor-fold desc="Seccion de Sistema Gestores">
    
    public UsuarioGestor loginGestor(String usu, String pass) throws Exception 
    {
        return sUsuario.loginGestor(usu, pass);
    }
    
    /**
     * Cierra la sesion de un mozo limpiandolo de las sesiones activas
     * @param mozo mozo que esta cerrando la sesion
     * @return si se cerro correctamente la sesion
     */
    public boolean cerrarSesionGestor(UsuarioGestor gestor)
    {
        return this.sUsuario.cerrarSesionGestor(gestor);
    }
    
    
    public ArrayList<UnidadProcesadora> getUnidadesProcesadoras()
    {
        return this.sRestaurante.getUnidadesProcesadoras();
    }
    
    
    public ArrayList<Pedido> getPedidosUnidad(String unidad)
    {
        return this.sRestaurante.getPedidosUnidad(unidad);
    }
    
    //</editor-fold>
    
    
    public void agregarMozo(UsuarioMozo mozo)
    {
        this.sUsuario.agregarMozo(mozo);
    }
    
    
    public void agregarGestor(UsuarioGestor gestor)
    {
        this.sUsuario.agregarGestor(gestor);
    }
        
    public void agregarMesa(Mesa mesa){
        this.sRestaurante.agregarMesa(mesa);
    }
    
    public void agregarUnidadProcesadora(UnidadProcesadora unidad)
    {
        this.sRestaurante.agregarUnidadProcesadora(unidad);
    }
    
    public void agregarProducto(Producto prod){
        this.sRestaurante.agregarProducto(prod);
    }
    
    public void agregarCliente(Cliente cli)
    {
        this.sRestaurante.agregarCliente(cli);
    }
    
    
}
