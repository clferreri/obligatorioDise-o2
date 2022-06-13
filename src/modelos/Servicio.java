package modelos;

import java.util.ArrayList;

public class Servicio {
    
    private ArrayList<Pedido> pedidos;
    private Mesa mesa;
    private Cliente cliente;

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    
    public Servicio(Mesa mesa)
    {
        this.pedidos = new ArrayList<Pedido>();
    }
    
    
    
    
}


