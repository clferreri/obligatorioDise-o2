package obligatorio2;

import modelos.FachadaSistema;
import modelos.Mesa;
import modelos.UsuarioMozo;
import modelos.UsuarioGestor;
import modelos.UnidadProcesadora;

public class DatosPrueba {

    public static void cargar() {
        //CARGA DE DATOS DE MOZOS
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
        //FIN CARGA DE DATOS DE MOZO
        
        //CARGA DE DATOS DE GESTOR
        UsuarioGestor gestor1 = new UsuarioGestor("palopez", "pablo123", "Pablo Lopez");
        UsuarioGestor gestor2 = new UsuarioGestor("aguirreju", "juan123", "Juan Aguirre");
        UsuarioGestor gestor3 = new UsuarioGestor("pirezni", "nicolas123", "Nicolas Pirez");
        UsuarioGestor gestor4 = new UsuarioGestor("monteslu", "lucia123", "Lucia Montes");
        UsuarioGestor gestor5 = new UsuarioGestor("rodriguezPa", "patricia123", "Patricia Rodriguez");
        FachadaSistema.getInstancia().agregarGestor(gestor1);
        FachadaSistema.getInstancia().agregarGestor(gestor2);
        FachadaSistema.getInstancia().agregarGestor(gestor3);
        FachadaSistema.getInstancia().agregarGestor(gestor4);
        FachadaSistema.getInstancia().agregarGestor(gestor5);
        //FIN CARGA DE DATOS DE GESTOR
        
        
        //CARGA DE DATOS DE MESA
        Mesa mesa1 = new Mesa(1, mozo1);
        Mesa mesa2 = new Mesa(2, mozo1);
        Mesa mesa3 = new Mesa(3, mozo2);
        Mesa mesa4 = new Mesa(4, mozo3);
        Mesa mesa5 = new Mesa(5, mozo3);
        Mesa mesa6 = new Mesa(6, mozo3);
        Mesa mesa7 = new Mesa(7, mozo5);
        Mesa mesa8 = new Mesa(8, mozo1);
        Mesa mesa9 = new Mesa(9, null);
        Mesa mesa10 = new Mesa(10, null);
        Mesa mesa11 = new Mesa(11, null);
        Mesa mesa12 = new Mesa(12, null);
        Mesa mesa13 = new Mesa(13, null);
        Mesa mesa14 = new Mesa(14, null);
        

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
        
        FachadaSistema.getInstancia().abrirMesa(mesa1.getNumero());
        FachadaSistema.getInstancia().abrirMesa(mesa8.getNumero());
        //FIN CARGA DE DATOS DE MESA
        
        UnidadProcesadora unidad1 = new UnidadProcesadora("Cocina");
        UnidadProcesadora unidad2 = new UnidadProcesadora("Bar");
        FachadaSistema.getInstancia().agregarUnidadProcesadora(unidad1);
        FachadaSistema.getInstancia().agregarUnidadProcesadora(unidad2);
        
    }
}
