
package modelos;

import java.util.ArrayList;
import modelos.excepciones.LoginException;

public class FachadaSistema {
    
    private SistemaMozo sMozo = SistemaMozo.getInstancia();
    private SistemaGestor sGestor = SistemaGestor.getInsancia();
    private static FachadaSistema instancia = new FachadaSistema();
    
    private FachadaSistema(){}
    public static FachadaSistema getInstancia()
    {
        return instancia;
    }
    
    public UsuarioMozo loginMozo(String usu, String pass) throws LoginException
    {
        //podiria volver a validar que el usuario y contraseña no esten vacios
        UsuarioMozo u = sMozo.obtenerUsuarioMozo(usu, pass);
        if(u == null){
            throw new LoginException("Usuario y/o contraseñas incorrectos");
        }
        
        if(sMozo.estaLogeado(usu)){
            throw new LoginException("Ud. ya está logeado");
        }
        
        sMozo.login(u);
        return u;
    }
    
    
    public boolean cerrarSesionMozo(UsuarioMozo mozo)
    {
        return this.sMozo.cerrarSesionMozo(mozo);
    }
    
    
    public ArrayList<Mesa> getMesasAsignadas(UsuarioMozo mozo)
    {
        return this.sMozo.getMesasAsignadas(mozo);
    }
    
    
    public void agregarMozo(UsuarioMozo mozo)
    {
        this.sMozo.agregarMozo(mozo);
    }
    
        public void agregarGestor(UsuarioGestor gestor)
    {
        this.sGestor.agregarGestor(gestor);
    }
        
    public void agregarMesa(Mesa mesa){
        this.sMozo.agregarMesa(mesa);
    }
    
}
