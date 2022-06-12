
package modelos;

public class Mesa {

    private int numero;
    private UsuarioMozo mozo; //NO se si sacar este dato, por ahora lo dejo ahi sin usar

    public Mesa(int numero, UsuarioMozo mozo) {
        this.numero = numero;
        this.mozo = mozo;
    }

    public boolean estaAbierta() {
        return this.mozo != null;
    }
}
