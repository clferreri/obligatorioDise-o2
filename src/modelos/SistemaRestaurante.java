package modelos;

import java.util.ArrayList;
import modelos.UnidadProcesadora;
import modelos.Producto;
import modelos.Mesa;
import modelos.excepciones.FindMesaException;
import modelos.excepciones.MesaIsOpenException;

public class SistemaRestaurante {

    private static SistemaRestaurante instancia;
    private ArrayList<Producto> productos;
    private ArrayList<Mesa> mesas;
    private ArrayList<UnidadProcesadora> unidadesProcesadoras;
    private ArrayList<Servicio> servicios;

    private SistemaRestaurante() {
        productos = new ArrayList();
        mesas = new ArrayList();
        unidadesProcesadoras = new ArrayList();
        servicios = new ArrayList();
    }

    static SistemaRestaurante getInsancia() {
        if (instancia == null) {
            instancia = new SistemaRestaurante();
        }
        return instancia;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<UnidadProcesadora> getUnidadesProcesadoras() {
        return unidadesProcesadoras;
    }

    public UnidadProcesadora ObtenerUnidadProcesadora(String nombre) {
        UnidadProcesadora unaUnidad = new UnidadProcesadora();
        if (nombre != "" && this.unidadesProcesadoras.size() > 0) {
            for (UnidadProcesadora u : this.unidadesProcesadoras) {
                if (u.getNombre().equals(nombre)) {
                    unaUnidad = u;
                }
            }
        }
        return unaUnidad;
    }

    public Producto ObtenerProducto(String codigo) {
        Producto unProducto = new Producto();
        if (codigo != "" && this.productos.size() > 0) {
            for (Producto p : this.productos) {
                if (p.getCodigo().equals(codigo)) {
                    unProducto = p;
                }
            }
        }
        return unProducto;
    }

    public void agregarMesa(Mesa mesa) {
        this.mesas.add(mesa);
    }

    public void agregarProducto(Producto prod) {
        this.productos.add(prod);
    }

    public void agregarUnidadProcesadora(UnidadProcesadora u) {
        this.unidadesProcesadoras.add(u);
    }

    public ArrayList<Mesa> getMesasAsignadas(UsuarioMozo m) {
        ArrayList<Mesa> mesasAsignadas = new ArrayList<Mesa>();

        for (Mesa me : this.mesas) {
            UsuarioMozo mozoMesa = me.getMozo();
            if (mozoMesa != null && mozoMesa.equals(m)) {
                mesasAsignadas.add(me);
            }
        }

        return mesasAsignadas;
    }

    public Mesa obtenerMesa(int numero) throws FindMesaException {
        Mesa m = this.getMesa(numero);
        if (m == null) {
            throw new FindMesaException();
        }

        return m;
    }

    private Mesa getMesa(int numero) {
        Mesa me = null;
        for (Mesa m : this.mesas) {
            if (m.getNumero() == numero) {
                me = m;
                break;
            }
        }

        return me;
    }

    public boolean abrirMesa(int numero) throws FindMesaException, MesaIsOpenException {
        Mesa m = this.getMesa(numero);
        if (m == null) {
            throw new FindMesaException();
        }

        if (m.estaAbierta()) {
            throw new MesaIsOpenException();
        }

        Servicio servicioNuevo = new Servicio(m);
        this.servicios.add(servicioNuevo);
        m.setServicio(servicioNuevo);
        return true;
    }

    public boolean agregarPedido(Mesa m, Pedido p) {
        return m.getServicio().AgregarPedido(p);
    }
}
