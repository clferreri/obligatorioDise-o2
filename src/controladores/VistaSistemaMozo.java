/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelos.Mesa;
import modelos.Servicio;

/**
 *
 * @author cferreri
 */
public interface VistaSistemaMozo {
    
    public void cargarMesasMozo(ArrayList<Mesa> mesas);
    public void mostrarInfoServicioMesa(Servicio servicioMesa);
    public void cerrarSesion();
}
