
package modelos;

import java.util.ArrayList;
import modelos.excepciones.ActiveSessionException;
import modelos.excepciones.FindMozoException;
import modelos.excepciones.LoginException;

public class SistemaMozo {
    
    private static SistemaMozo instancia;
    private ArrayList<UsuarioMozo> mozos;
    private ArrayList<UsuarioMozo> mozosActivos;
    private ArrayList<Mesa> mesas;
    
    private SistemaMozo(){
        this.mozos = new ArrayList<UsuarioMozo>();
        this.mozosActivos = new ArrayList<UsuarioMozo>();
        this.mesas = new ArrayList<Mesa>();
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
    
    public boolean cerrarSesionMozo(UsuarioMozo m)
    {
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
            if(me.getMozo().equals(m)){
                mesasAsignadas.add(me);
            }
        }
        
        return mesasAsignadas;
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
}
