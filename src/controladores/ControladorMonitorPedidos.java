package controladores;

import modelos.FachadaSistema;
import modelos.UsuarioGestor;

/**
 *
 * @author cferreri
 */
public class ControladorMonitorPedidos {

    private VistaMonitorPedidos vista;
    private UsuarioGestor gestor;
    private FachadaSistema sistema = FachadaSistema.getInstancia();

    public ControladorMonitorPedidos(VistaMonitorPedidos vista, UsuarioGestor gestor) {
        this.vista = vista;
        //Agrego el observer? - leer esto
        this.gestor = gestor;
        this.mostrarUnidadesProcesadoras();
    }

    public void mostrarUnidadesProcesadoras() {
        vista.mostrarUnidadesProcesadoras(sistema.getUnidadesProcesadoras());
    }

    public boolean cerrarSesion() {
        return this.sistema.cerrarSesionGestor(this.gestor);
    }
}
