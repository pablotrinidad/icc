/* -*- jde -*- */
/* <BuscadorPorTelefono.java> */

package icc.agenda;

import icc.util.Buscador;

/**
 * Clase que busca registros agenda con un Telefono dado.
 */
public class BuscadorPorTelefono implements Buscador {

    /* Telefono que se busca */
    private int telefonoBuscado;

    /**
     * Construye al buscador con el Telefono que
     * va a buscar.
     */
    public BuscadorPorTelefono(int telefono) {
        telefonoBuscado = telefono;
    }

    /**
     * Método que indica si el objeto pasado como parámetro
     * es el que se está buscando.
     * @param reg Registro que se desea saber si corresponde
     *        al Telefono buscado.
     * @returns si <code>reg</code> tiene ese Telefono.
     */
    public boolean esEste(Object o) {
        RegistroAgenda reg = (RegistroAgenda) o;
        if (reg.getTelefono() == this.telefonoBuscado) {
            return true;
        } else {
            return false;
        }
    }

}
