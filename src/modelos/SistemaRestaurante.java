package modelos;

import java.util.ArrayList;
import modelos.UnidadProcesadora;
import modelos.Producto;
import modelos.Mesa;
import modelos.excepciones.ClientNotFoundException;
import modelos.excepciones.FindMesaException;
import modelos.excepciones.MesaIsCloseException;
import modelos.excepciones.MesaIsOpenException;
import modelos.excepciones.MesaWithPendingOrdersException;
import modelos.excepciones.NoCountException;
import modelos.excepciones.NoStockException;

public class SistemaRestaurante {

    private static SistemaRestaurante instancia;
    private ArrayList<Producto> productos;
    private ArrayList<Mesa> mesas;
    private ArrayList<UnidadProcesadora> unidadesProcesadoras;
    private ArrayList<Servicio> servicios;
    private ArrayList<Cliente> clientes;

    private SistemaRestaurante() {
        mesas = new ArrayList();
        servicios = new ArrayList();
        productos = new ArrayList();
        unidadesProcesadoras = new ArrayList();
        this.clientes = new ArrayList<Cliente>();
    }

    static SistemaRestaurante getInsancia() {
        if (instancia == null) {
            instancia = new SistemaRestaurante();
        }
        return instancia;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<UnidadProcesadora> getUnidadesProcesadoras() {
        return unidadesProcesadoras;
    }

    public UnidadProcesadora ObtenerUnidadProcesadora(String nombre) {
        if (nombre != "" && this.unidadesProcesadoras.size() > 0) {
            for (UnidadProcesadora u : this.unidadesProcesadoras) {
                if (u.getNombre().equals(nombre)) {
                    return u;
                }
            }
        }
        return null;
    }

    public Producto ObtenerProducto(String codigo) {
        Producto unProducto = null;
        if (codigo != "" && this.productos.size() > 0) {
            for (Producto p : this.productos) {
                if (p.getCodigo().equals(codigo)) {
                    unProducto = p;
                }
            }
        }
        return unProducto;
    }

    public ArrayList<Mesa> getMesasAsignadas(UsuarioMozo m)
    {
        ArrayList<Mesa> mesasAsignadas = new ArrayList<Mesa>();
        
        for(Mesa me : this.mesas){
            UsuarioMozo mozoMesa = me.getMozo();
            if(mozoMesa != null && mozoMesa.equals(m)){
                mesasAsignadas.add(me);
            }
        }
        
        return mesasAsignadas;
    }
    
    public Mesa obtenerMesa(int numero) throws FindMesaException
    {
        Mesa m = this.getMesa(numero);
        if (m == null){
            throw new FindMesaException();
        }
        
        return m;
    }
    
    
    private Mesa getMesa(int numero){
        Mesa me = null;
        for(Mesa m : this.mesas){
            if(m.getNumero() == numero){
                me = m;
                break;
            }
        }
        
        return me;
    }
    
    public boolean abrirMesa(int numero) throws FindMesaException, MesaIsOpenException{
        Mesa m = this.getMesa(numero);
        if(m == null){
            throw new FindMesaException();
        }
        
        if(m.estaAbierta()){
            throw new MesaIsOpenException();
        }
        
        Servicio servicioNuevo = new Servicio(m);
        this.servicios.add(servicioNuevo);
        m.setServicio(servicioNuevo);
        return true;
    }
    
    public boolean agregarPedido(Mesa m, String codigo, int cantidad, String descripcion) throws NoStockException, NoCountException, MesaIsCloseException{
        if(cantidad < 1){
            throw new NoCountException();
        }
        
        if(!m.estaAbierta()){
            throw new MesaIsCloseException();
        }
        Producto prod = this.ObtenerProducto(codigo);
        
        
        if(!prod.stockSuficiente(cantidad)){
            throw new NoStockException(prod.getStock());
        }
        
        Pedido ped = new Pedido(prod, cantidad, descripcion, m.getServicio());
        if(m.getServicio().AgregarPedido(ped)){
            prod.descontarCantidad(cantidad);
            ped.getProducto().getUnidadProcesadora().agregarPedido(ped);
        }
        
        return true;
    }
    
    public ArrayList<Producto> getProductosConStock()
    {
        ArrayList<Producto> aux = new ArrayList<Producto>();
        for(Producto p : this.productos)
        {
            if(p.tieneStock())
            {
                aux.add(p);
            }
        }
        return aux;
    }
   
    public boolean tieneMesasAbiertas(UsuarioMozo m)
    {
        ArrayList<Mesa> mesasMozo = this.getMesasAsignadas(m);
        
        for(Mesa me : mesasMozo){
            if(me.estaAbierta()){
                return true;
            }
        }
        return false;
    }
    
    public Servicio cerrarMesa(int numeroMesa, int idCliente) throws MesaIsCloseException, MesaWithPendingOrdersException, ClientNotFoundException{
        Mesa m = this.getMesa(numeroMesa);
        
        if(!m.estaAbierta()){
            throw new MesaIsCloseException("La mesa no esta abierta");
        }
        
        if(m.getServicio().tienePedidosPendientes()){
            throw new MesaWithPendingOrdersException();
        }
        
        Cliente cli = this.obtenerCliente(idCliente);
        
        if(cli == null){
            throw new ClientNotFoundException();
        }
        
        Servicio s = m.getServicio();
        s.asignarCliente(cli);
        m.cerrarMesa();
        
        return s;
    }
    

    public Cliente obtenerCliente(int idCliente){
        for(Cliente cli : this.clientes)
        {
            if(cli.getId() == idCliente){
                return cli;
            }
        }
        return null;
    }
    
    // METODOS USADOS SOLO EN LA CARGA DE DATOS (podrian usarse si se pidiera un sistema de altas)  
    public void agregarMesa(Mesa mesa)
    {
        this.mesas.add(mesa);
    }
    
    public void agregarProducto(Producto prod)
    {
        this.productos.add(prod);
    }
    
    public void agregarCliente(Cliente cli)
    {
        this.clientes.add(cli);
    }
}
