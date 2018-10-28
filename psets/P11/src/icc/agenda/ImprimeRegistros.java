/* -*- jde -*- */
/* <ImprimeRegistros.java> */

package icc.agenda;

/* Lang packages */
import java.io.PrintStream;

/* Project packages */
import icc.util.Buscador;

/**ImprimeRegistros
* Usada para imprimir los registros de una DB
*/
public class ImprimeRegistros implements Buscador {

    public boolean esEste(Object o) {
        RegistroAgenda reg = (RegistroAgenda) o;
        System.out.println(reg);
        return false;
    }

}
