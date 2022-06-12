
package modelos;

import java.util.ArrayList;

public class UnidadProcesadora {

    private String nombre;
    private ArrayList<Pedido> pedidos;
    
    
    public UnidadProcesadora(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
}
