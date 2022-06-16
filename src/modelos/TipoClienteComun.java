/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author cferreri
 */
public class TipoClienteComun extends TipoCliente{

    private Producto productoDescuento = new Producto("CA1","Cafe",150,0,new UnidadProcesadora("Cafeteria"));
    @Override
    public String tipo() {
        return "Comun";
    }

    @Override
    public float getTotalBeneficio(Servicio servicio) {
        return servicio.getTotal() - servicio.getTotal(this.productoDescuento);
    }

    @Override
    public String beneficio() {
        return "Café invitación";
    }
    
}
