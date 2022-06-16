
package controladores;

import java.util.ArrayList;
import modelos.UnidadProcesadora;

public interface VistaMonitorPedidos {
    
    public void cerrarSesion();
    
    public void mostrarUnidadesProcesadoras(ArrayList<UnidadProcesadora> unidadesProcesadoras);
}
