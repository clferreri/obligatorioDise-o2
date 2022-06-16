package modelos;

import java.util.ArrayList;
import modelos.excepciones.ActiveSessionException;
import modelos.excepciones.FindGestorException;

public class SistemaGestor {

    private static SistemaGestor instancia;
    private ArrayList<UsuarioGestor> gestores;
    private ArrayList<UsuarioGestor> gestoresActivos;
    private ArrayList<UnidadProcesadora> unidades;

    private SistemaGestor() {
        this.gestores = new ArrayList<UsuarioGestor>();
        this.gestoresActivos = new ArrayList<UsuarioGestor>();
        this.unidades = new ArrayList<UnidadProcesadora>();
    }

    public static SistemaGestor getInsancia() {
        if (instancia == null) {
            instancia = new SistemaGestor();
        }
        return instancia;
    }

    public void agregarGestor(UsuarioGestor gestor) {
        this.gestores.add(gestor);
    }

    public void agregarSesion(UsuarioGestor u) {
        this.gestoresActivos.add(u);
    }
    
    public UsuarioGestor loginGestor(String usu, String pass) throws Exception 
    {
        UsuarioGestor gestor = this.obtenerUsuarioGestor(usu, pass);
        
        if(gestor == null){
            throw new FindGestorException();
        }
        
        if(this.estaLogeado(usu)){
            throw new ActiveSessionException();
        }
        
        this.agregarSesion(gestor);
        return gestor;
    }

    public boolean estaLogeado(String usu) {
        for (UsuarioGestor u : gestoresActivos) {
            if (u.getUsuario().equals(usu)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean cerrarSesion(UsuarioGestor g)
    {
        return this.gestoresActivos.remove(g);
    }

    public UsuarioGestor obtenerUsuarioGestor(String usu, String pass) {
        UsuarioGestor gestor = null;
        for (UsuarioGestor u : gestores) {
            if (u.getUsuario().equals(usu) && u.getContrasenia().equals(pass)) {
                gestor = u;
                break;
            }
        }
        return gestor;
    }
    
    
    public void agregarUnidadProcesadora(UnidadProcesadora u)
    {
        this.unidades.add(u);
    }

}
