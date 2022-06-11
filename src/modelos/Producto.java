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
    private UnidadesProcesadoras unidadProcesadora;


    public Producto(String codigo, String nombre, float precio, int stock, UnidadesProcesadoras unidad)
    {
        this.codigo             = codigo;
        this.nombre             = nombre;
        this.precio             = precio;
        this.stock              = stock;
        this.unidadProcesadora  = unidad;
    }
}
