/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.FachadaSistema;
import modelos.UsuarioMozo;

/**
 *
 * @author cferreri
 */
public class ControladorMozo{
    
    private VistaSistemaMozo vista;
    private UsuarioMozo mozo;
    private FachadaSistema sistema = FachadaSistema.getInstancia();
    
    public ControladorMozo(VistaSistemaMozo vista, UsuarioMozo mozo){
        this.vista = vista;
        //Agrego el observer? - leer esto
        this.mozo = mozo;
        this.mostrarMesasActivas();
    }
    
    
    public boolean cerrarSesion()
    {
        return this.sistema.cerrarSesionMozo(this.mozo);
    }
    
    public void mostrarMesasActivas()
    {
        vista.cargarMesasMozo(this.sistema.getMesasAsignadas(this.mozo));
    }
}
