/* -*- jde -*- */
/* <BuscadorPorNombre.java> */

package icc.agenda;

import icc.util.IBuscador;

/**
 * Clase que busca registros agenda con un nombre dado.
 */
public class BuscadorPorNombre implements IBuscador {

    /* Nombre que se busca */
    private String nombreBuscado;

    /**
     * Construye al buscador con el nombre que
     * va a buscar.
     */
    public BuscadorPorNombre(String nombre) {
        nombreBuscado = nombre;
    }

    /**
     * Método que indica si el objeto pasado como parámetro
     * es el que se está buscando.
     * @param reg Registro que se desea saber si corresponde
     *        al nombre buscado.
     * @returns si <code>reg</code> tiene ese nombre.
     */
    public boolean esEste(RegistroAgenda reg) {
        if (reg.getNombre().contains(this.nombreBuscado)) {
            return true;
        } else {
            return false;
        }
    }

}
