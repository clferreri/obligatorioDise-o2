
package modelos;

public class Mesa {

    private int numero;
    private UsuarioMozo mozo;
    private Servicio servicioActual;

    public Mesa(int numero, UsuarioMozo mozo) {
        this.numero = numero;
        this.mozo = mozo;
    }
    
    public Mesa(int numero, UsuarioMozo mozo, Servicio servicio) {
        this.numero = numero;
        this.mozo = mozo;
        this.servicioActual = servicio;
    }

    public boolean estaAbierta() {
        return this.servicioActual != null;
    }
  
    public int getNumero()
    {
        return this.numero;
    }
    
    public UsuarioMozo getMozo()
    {
        return this.mozo;
    }
   
    
    public void setServicio(Servicio s)
    {
        this.servicioActual = s;
    }
    
    public Servicio getServicio()
    {
        return this.servicioActual;
    }
}
