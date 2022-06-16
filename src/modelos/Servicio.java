package modelos;

import java.util.ArrayList;
import observadores.Observable;

public class Servicio extends Observable{
    
    private ArrayList<Pedido> pedidos;
    private Mesa mesa;
    private Cliente cliente;

    public enum Eventos {
        nuevoPedido
    };
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
        this.mesa = mesa;
        this.pedidos = new ArrayList<Pedido>();
    }
    
    
    public boolean AgregarPedido(Pedido p)
    {
        this.pedidos.add(p);
        FachadaSistema.getInstancia().avisar(FachadaSistema.Eventos.eventoStock);
        return true;
    }
    
    public boolean tienePedidosPendientes()
    {
        for(Pedido ped : this.pedidos)
        {
            if(!ped.isFinalizado()){
                return true;
            }
        }
        return false;
    }
    
    public float getTotal()
    {
        float total = 0;
        for(Pedido ped : this.pedidos)
        {
            total += ped.getTotal(); 
        }
        return total;
    }
    
    public float getTotal(Producto p)
    {
        float total = 0;
        for(Pedido ped : this.pedidos)
        {
            if(ped.mismoProducto(p)){
                total += ped.getTotal();
            }
             
        }
        return total;
    }
    
    public void asignarCliente(Cliente cli){
        if(cli != null){
            this.cliente = cli;
        }
    }
    
    public String getBeneficio()
    {
        if(this.cliente == null){
            return "SIN BENEFICIO";
        }
        
        return this.cliente.getNombreBeneficio();
    }
    
    public float getTotalBeneficio()
    {
        if(this.cliente == null){
            return 0;
        }
        
        return this.cliente.getTotalBeneficio(this);
    }
    
    public String getNombreCliente()
    {
        if(this.cliente == null){
            return "";
        }
        
        return this.cliente.getNombre();
    }
        
    
    
}


