/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observadores;

import java.util.ArrayList;

/**
 *
 * @author cferreri
 */
public class Observable {

    private ArrayList<Observador> observadores = new ArrayList();

    public void agregar(Observador o) {
        if (!observadores.contains(o)) {
            observadores.add(o);
        }
    }

    public void quitar(Observador o) {
        observadores.remove(o);
    }

    public void avisar(Object evento) {
        ArrayList<Observador> copia = new ArrayList(observadores);

        for (Observador o : copia) {
            try {
                o.actualizar(evento, this);
            } catch (Exception e) {
                System.out.println("Error al avisar:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
