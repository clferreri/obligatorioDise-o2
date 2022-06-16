/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author cferreri
 */
public class TipoClienteDeLaCasa extends TipoCliente{

    @Override
    public String beneficio() {
        return "500 Gratis";
    }

    @Override
    public String tipo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float getTotalBeneficio(Servicio servicio) {
        return 500;
    }
    
}
