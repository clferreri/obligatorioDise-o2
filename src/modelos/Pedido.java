package modelos;

public class Pedido {

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
}
