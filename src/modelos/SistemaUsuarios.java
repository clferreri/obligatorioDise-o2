package modelos;

import java.util.ArrayList;
import modelos.excepciones.ActiveSessionException;
import modelos.excepciones.FindGestorException;
import modelos.excepciones.FindMesaException;
import modelos.excepciones.FindMozoException;
import modelos.excepciones.LoginException;
import modelos.excepciones.MesaIsOpenException;

public class SistemaUsuarios {

    private ArrayList<UsuarioMozo> mozos;
    private ArrayList<UsuarioGestor> gestores;
    private ArrayList<UsuarioMozo> mozosActivos;
    private ArrayList<UsuarioGestor> gestoresActivos;

    private static SistemaUsuarios instancia;

    //Funciones generales
    private SistemaUsuarios() {
        mozos = new ArrayList();
        gestores = new ArrayList();
        mozosActivos = new ArrayList();
        gestoresActivos = new ArrayList();
    }

    public static SistemaUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new SistemaUsuarios();
        }
        return instancia;
    }

    public boolean estaLogeado(String usu) {
        for (UsuarioGestor u : gestoresActivos) {
            if (u.getUsuario().equals(usu)) {
                return true;
            }
        }
        for (UsuarioMozo u : mozosActivos) {
            if (u.getUsuario().equals(usu)) {
                return true;
            }
        }
        return false;
    }

    //Usuario Mozo
    public void agregarMozo(UsuarioMozo mozo) {
        this.mozos.add(mozo);
    }

    public UsuarioMozo loginMozo(String usu, String pass) throws Exception {
        UsuarioMozo mozo = this.obtenerUsuarioMozo(usu, pass);

        if (mozo == null) {
            throw new FindMozoException();
        }

        if (this.estaLogeado(usu)) {
            throw new ActiveSessionException();
        }

        this.agregarSesionMozo(mozo);
        return mozo;
    }

    public void agregarSesionMozo(UsuarioMozo u) {
        this.mozosActivos.add(u);
    }

    public UsuarioMozo obtenerUsuarioMozo(String usu, String pass) throws FindMozoException {
        UsuarioMozo mozo = null;
        for (UsuarioMozo u : mozos) {
            if (u.getUsuario().equals(usu) && u.getContrasenia().equals(pass)) {
                mozo = u;
                break;
            }
        }

        return mozo;
    }

    public boolean cerrarSesionMozo(UsuarioMozo m) {
        return this.mozosActivos.remove(m);
    }

    //Usuario Gestor
    public void agregarGestor(UsuarioGestor gestor) {
        this.gestores.add(gestor);
    }

    public void agregarSesion(UsuarioGestor u) {
        this.gestoresActivos.add(u);
    }

    public UsuarioGestor loginGestor(String usu, String pass) throws Exception {
        UsuarioGestor gestor = this.obtenerUsuarioGestor(usu, pass);

        if (gestor == null) {
            throw new FindGestorException();
        }

        if (this.estaLogeado(usu)) {
            throw new ActiveSessionException();
        }

        this.agregarSesion(gestor);
        return gestor;
    }

    public boolean cerrarSesionGestor(UsuarioGestor g) {
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
}
