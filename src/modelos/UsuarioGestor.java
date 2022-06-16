
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

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    

}
