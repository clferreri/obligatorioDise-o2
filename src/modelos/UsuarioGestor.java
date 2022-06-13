
package modelos;

import java.util.ArrayList;
import java.util.Date;

public class UsuarioGestor extends Usuario {

    private Date ultimoAcceso;
    private UnidadProcesadora unidad;
    private ArrayList<Pedido> pedidos;

    public UsuarioGestor(String usuario, String contrasenia, String nombreCompleto) {
        super(usuario, contrasenia, nombreCompleto);
    }
    
    public void setUnidadProcesador(UnidadProcesadora unidad)
    {
        this.unidad = unidad;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public UnidadProcesadora getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadProcesadora unidad) {
        this.unidad = unidad;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    

}
