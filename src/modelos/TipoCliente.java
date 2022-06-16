package modelos;

public abstract class TipoCliente {
    
    public abstract String beneficio();
    public abstract String tipo();
    public abstract float getTotalBeneficio(Servicio servicio);
}
