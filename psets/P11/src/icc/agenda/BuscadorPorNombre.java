/* -*- jde -*- */
/* <BuscadorPorNombre.java> */

package icc.agenda;

import icc.util.Buscador;

/**
 * Clase que busca registros agenda con un nombre dado.
 */
public class BuscadorPorNombre implements Buscador {

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
    public boolean esEste(Object o) {
        RegistroAgenda reg = (RegistroAgenda) o;
        if (reg.getNombre().contains(this.nombreBuscado)) {
            return true;
        } else {
            return false;
        }
    }

}
