/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author bolso
 */
public class Producto {

    private String codigo;
    private String nombre;
    private float precio;
    private int stock;
    private UnidadProcesadora unidadProcesadora;

    public Producto(String codigo, String nombre, float precio, int stock, UnidadProcesadora unidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.unidadProcesadora = unidad;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public UnidadProcesadora getUnidadProcesadora() {
        return unidadProcesadora;
    }

    public void setUnidadProcesadora(UnidadProcesadora unidadProcesadora) {
        this.unidadProcesadora = unidadProcesadora;
    }
    
    @Override
    public String toString()
    {
        return this.codigo + " - " + this.nombre;
    }
    
    public boolean tieneStock()
    {
        return this.stock > 0;
    }
    
    public boolean stockSuficiente(int cantidad){
        return this.stock >= cantidad;
    }
    
    public void descontarCantidad(int cantidad)
    {
        this.stock -= cantidad;
    }
    

}
