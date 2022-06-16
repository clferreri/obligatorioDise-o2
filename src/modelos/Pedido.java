package modelos;

import observadores.Observable;

public class Pedido extends Observable{

    private Producto producto;
    private int cantidad;
    private String descripcion;
    private boolean finalizado;
    private Servicio servicio;
    
    public Pedido(Producto producto, int cantidad, String descripcion, Servicio servicio)
    {
        this.producto       = producto;
        this.cantidad       = cantidad;
        this.descripcion    = descripcion;
        this.servicio       = servicio;
        this.finalizado     = false;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public String getEstado()
    {
        return (this.finalizado) ? "Entregado" : "Preparando";
    }
    
    public float getTotal()
    {
        return this.producto.getPrecio() * this.cantidad;
    }
    
    public boolean mismoProducto(Producto p){
        return this.producto.equals(p);
    }
}
