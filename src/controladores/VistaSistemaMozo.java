/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelos.Mesa;
import modelos.Producto;
import modelos.Servicio;

/**
 *
 * @author cferreri
 */
public interface VistaSistemaMozo {
    
    public void error(String mensage);
    public void cargarMesasMozo(ArrayList<Mesa> mesas);
    public void mostrarInfoServicioMesa(Servicio servicioMesa);
    public void abrirMesa(boolean resultado);
    public void vistaAgregarProductoServicio(ArrayList<Producto> productos);
    public void agregarProductoServicio();
    
    public void cerrarMesa(String cliente, float total, String Beneficio, float totalBeneficio);
    public void transferirMesa();
    public void cerrarSesion();
}
