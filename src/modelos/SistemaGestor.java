package modelos;

import java.util.ArrayList;

public class SistemaGestor {

    private static SistemaGestor instancia;
    private ArrayList<UsuarioGestor> gestores;
    private ArrayList<UsuarioGestor> gestoresActivos;

    private SistemaGestor() {
        this.gestores = new ArrayList<UsuarioGestor>();
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

    public void login(UsuarioGestor u) {
        this.gestoresActivos.add(u);
    }

    public boolean estaLogeado(String usu) {
        for (UsuarioGestor u : gestoresActivos) {
            if (u.getUsuario().equals(usu)) {
                return true;
            }
        }
        return false;
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
