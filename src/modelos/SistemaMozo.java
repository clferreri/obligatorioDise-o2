
package modelos;

import java.util.ArrayList;
import modelos.excepciones.ActiveSessionException;
import modelos.excepciones.CloseSessionMozoException;
import modelos.excepciones.FindMesaException;
import modelos.excepciones.FindMozoException;
import modelos.excepciones.LoginException;
import modelos.excepciones.MesaIsOpenException;

public class SistemaMozo {
    
    private static SistemaMozo instancia;
    private ArrayList<UsuarioMozo> mozos;
    private ArrayList<UsuarioMozo> mozosActivos;
    private ArrayList<Mesa> mesas;
    private ArrayList<Servicio> servicios;
    private ArrayList<Producto> productos;
    
    private SistemaMozo(){
        this.mozos          = new ArrayList<UsuarioMozo>();
        this.mozosActivos   = new ArrayList<UsuarioMozo>();
        this.mesas          = new ArrayList<Mesa>();
        this.servicios      = new ArrayList<Servicio>();
        this.productos      = new ArrayList<Producto>();
    }
    
    public static SistemaMozo getInstancia()
    {
        if(instancia == null){
            instancia = new SistemaMozo();
        }
        return instancia;
    }
    
    public void agregarSesionMozo(UsuarioMozo u)
    {
        this.mozosActivos.add(u);
    }
    
    public boolean cerrarSesionMozo(UsuarioMozo m) throws CloseSessionMozoException
    {
        ArrayList<Mesa> mesasAsignadas = this.getMesasAsignadas(m);
        
        for(Mesa me : mesasAsignadas){
            if(me.estaAbierta()){
                throw new CloseSessionMozoException();
            }
        }
        return this.mozosActivos.remove(m);
    }
    
    
    public UsuarioMozo loginMozo(String usu, String pass) throws Exception
    {
        UsuarioMozo mozo = this.obtenerUsuarioMozo(usu, pass);
        
        if(mozo == null){
            throw new FindMozoException();
        }
        
        if(this.estaLogeado(usu)){
            throw new ActiveSessionException();
        }
        
        this.agregarSesionMozo(mozo);
        return mozo;
    }
    
    
    public UsuarioMozo obtenerUsuarioMozo(String usu, String pass) throws FindMozoException
    {
        UsuarioMozo mozo = null;
        for(UsuarioMozo u : mozos)
        {
            if(u.getUsuario().equals(usu) && u.getContrasenia().equals(pass)){
                mozo = u;
                break;
            }
        }

        
        return mozo;
    }
    
    public boolean estaLogeado(String usu)
    {
        for(UsuarioMozo u : mozosActivos)
        {
            if(u.getUsuario().equals(usu)){
                return true;
            }
        }
        return false;
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
    
    public boolean agregarPedido(Mesa m, Pedido p){
        return m.getServicio().AgregarPedido(p);
    }
    
    public ArrayList<Producto> getProductosConStock()
    {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        
        
        return productos;
    }
    
    
    
    
    
    // METODOS USADOS SOLO EN LA CARGA DE DATOS (podrian usarse si se pidiera un sistema de altas)
    public void agregarMozo(UsuarioMozo mozo)
    {
        this.mozos.add(mozo);
    }
    
    public void agregarMesa(Mesa mesa)
    {
        this.mesas.add(mesa);
    }
    
    public void agregarProducto(Producto prod)
    {
        this.productos.add(prod);
    }
}
