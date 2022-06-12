
package modelos;

import java.util.ArrayList;

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
    
    public void login(UsuarioMozo u)
    {
        this.mozosActivos.add(u);
    }
    
    public boolean cerrarSesionMozo(UsuarioMozo m)
    {
        return this.mozosActivos.remove(m);
    }
    
    public UsuarioMozo obtenerUsuarioMozo(String usu, String pass)
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
        
        //for(Mesa m : this.mesas){
          //  m.equals(m);
        //}
        
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
