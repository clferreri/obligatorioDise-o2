/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio2;

import modelos.FachadaSistema;
import modelos.Mesa;
import modelos.UsuarioMozo;

/**
 *
 * @author cferreri
 */
public class DatosPrueba {
    
    public static void cargar() {
        UsuarioMozo mozo1 = new UsuarioMozo("lgperez", "perez123", "Luis German Perez", "093456879");
        UsuarioMozo mozo2 = new UsuarioMozo("sahernandez", "zanahoria1", "Sofia Agustina Hernandez", "093456874");
        UsuarioMozo mozo3 = new UsuarioMozo("pxtorres", "torres1", "Pablo Xavier Torres", "093456855");
        UsuarioMozo mozo4 = new UsuarioMozo("patorres", "torres2", "Paula Alma Torres", "094256630");
        UsuarioMozo mozo5 = new UsuarioMozo("ropuerta", "puerta", "Rodrigo Olmedo Puerta", "099456678");
        
        FachadaSistema.getInstancia().agregarMozo(mozo1);
        FachadaSistema.getInstancia().agregarMozo(mozo2);
        FachadaSistema.getInstancia().agregarMozo(mozo3);
        FachadaSistema.getInstancia().agregarMozo(mozo4);
        FachadaSistema.getInstancia().agregarMozo(mozo5);
        
        
        Mesa mesa1 = new Mesa(1, mozo1);
        Mesa mesa2 = new Mesa(1, mozo1);
        Mesa mesa3 = new Mesa(1, mozo2);
        Mesa mesa4 = new Mesa(1, mozo3);
        Mesa mesa5 = new Mesa(1, mozo3);
        Mesa mesa6 = new Mesa(1, mozo3);
        Mesa mesa7 = new Mesa(1, mozo5);
        Mesa mesa8 = new Mesa(1, mozo1);
        Mesa mesa9 = new Mesa(1, null);
        Mesa mesa10 = new Mesa(1, null);
        Mesa mesa11 = new Mesa(1, null);
        Mesa mesa12 = new Mesa(1, null);
        Mesa mesa13 = new Mesa(1, null);
        Mesa mesa14 = new Mesa(1, null);
        Mesa mesa15 = new Mesa(1, null);
        
       FachadaSistema.getInstancia().agregarMesa(mesa1);
       FachadaSistema.getInstancia().agregarMesa(mesa2);
       FachadaSistema.getInstancia().agregarMesa(mesa3);
       FachadaSistema.getInstancia().agregarMesa(mesa4);
       FachadaSistema.getInstancia().agregarMesa(mesa5);
       FachadaSistema.getInstancia().agregarMesa(mesa6);
       FachadaSistema.getInstancia().agregarMesa(mesa7);
       FachadaSistema.getInstancia().agregarMesa(mesa8);
       FachadaSistema.getInstancia().agregarMesa(mesa9);
       FachadaSistema.getInstancia().agregarMesa(mesa10);
       FachadaSistema.getInstancia().agregarMesa(mesa11);
       FachadaSistema.getInstancia().agregarMesa(mesa12);
       FachadaSistema.getInstancia().agregarMesa(mesa13);
       FachadaSistema.getInstancia().agregarMesa(mesa14);
       FachadaSistema.getInstancia().agregarMesa(mesa15);
    }
}
