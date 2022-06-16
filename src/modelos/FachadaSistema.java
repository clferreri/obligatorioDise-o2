package modelos;

import java.util.ArrayList;
import modelos.excepciones.FindMesaException;
import modelos.excepciones.LoginException;
import modelos.excepciones.MesaIsOpenException;


public class FachadaSistema {

    private SistemaUsuarios sUsuarios = SistemaUsuarios.getInstancia();
    //private SistemaGestor sGestor = SistemaGestor.getInsancia();
    private SistemaRestaurante sRestaurante = SistemaRestaurante.getInsancia();
    private static FachadaSistema instancia = new FachadaSistema();

    private FachadaSistema() {
    }

    public static FachadaSistema getInstancia() {
        return instancia;
    }

    //<editor-fold desc="Seccion de Sistema Mozos">
    /**
     * Inicia sesion de un mozo (en el sistema de mozos)
     *
     * @param usu usuario del mozo
     * @param pass contraseña del mozo
     * @return usuarioMozo que inicio sesion
     * @throws Exception El usuario/contraseña son incorrectos o el usuario ya
     * esta logeado
     */
    public UsuarioMozo loginMozo(String usu, String pass) throws Exception {
        return sUsuarios.loginMozo(usu, pass);
    }

    /**
     * Cierra la sesion de un mozo limpiandolo de las sesiones activas
     *
     * @param mozo mozo que esta cerrando la sesion
     * @return si se cerro correctamente la sesion
     */
    public boolean cerrarSesionMozo(UsuarioMozo mozo) {
        return this.sUsuarios.cerrarSesionMozo(mozo);
    }

    public ArrayList<Mesa> getMesasAsignadas(UsuarioMozo mozo) {
        return this.sRestaurante.getMesasAsignadas(mozo);
    }

    public Mesa getMesa(int numero) throws FindMesaException {
        return this.sRestaurante.obtenerMesa(numero);
    }

    public boolean abrirMesa(int numero) throws FindMesaException, MesaIsOpenException {
        return this.sRestaurante.abrirMesa(numero);
    }

    public boolean agregarPedido(Mesa mesa, Pedido pedido) {
        return this.sRestaurante.agregarPedido(mesa, pedido);
    }

    //</editor-fold>
    //<editor-fold desc="Seccion de Sistema Gestores">
    public UsuarioGestor loginGestor(String usu, String pass) throws Exception {
        return sUsuarios.loginGestor(usu, pass);
    }

    /**
     * Cierra la sesion de un mozo limpiandolo de las sesiones activas
     *
     * @param mozo mozo que esta cerrando la sesion
     * @return si se cerro correctamente la sesion
     */
    public boolean cerrarSesionGestor(UsuarioGestor gestor) {
        return this.sUsuarios.cerrarSesionGestor(gestor);
    }

    //</editor-fold>
    public void agregarMozo(UsuarioMozo mozo) {
        this.sUsuarios.agregarMozo(mozo);
    }

    public void agregarGestor(UsuarioGestor gestor) {
        this.sUsuarios.agregarGestor(gestor);
    }

    public void agregarMesa(Mesa mesa) {
        this.sRestaurante.agregarMesa(mesa);
    }

    public void agregarUnidadProcesadora(UnidadProcesadora unidad) {
        this.sRestaurante.agregarUnidadProcesadora(unidad);
    }

    public void agregarProducto(Producto prod) {
        this.sRestaurante.agregarProducto(prod);
    }

    //Sistema Restaurante
    public ArrayList<Producto> getProductos() {
        return sRestaurante.getProductos();
    }

    public ArrayList<UnidadProcesadora> getUnidadesProcesadoras() {
        return sRestaurante.getUnidadesProcesadoras();
    }

    public UnidadProcesadora ObtenerUnidadProcesadora(String nombre) {
        return sRestaurante.ObtenerUnidadProcesadora(nombre);
    }

    public Producto ObtenerProducto(String codigo) {
        return sRestaurante.ObtenerProducto(codigo);
    }

}
