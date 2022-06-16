/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author cferreri
 */
public class TipoClientePreferencial extends TipoCliente{

    private Producto productoDescuento = new Producto("AG1","Agua Mineral",150,0,new UnidadProcesadora("Cocina"));
    @Override
    public String beneficio() {
        return "Invitacion de agua";
    }

    @Override
    public String tipo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float getTotalBeneficio(Servicio servicio) {
        float totalBeneficio = servicio.getTotal(productoDescuento);
        
        if(servicio.getTotal() > 2000){
            return (float)(totalBeneficio + servicio.getTotal() * 0.05);
        }
        return totalBeneficio;
    }
    
}
