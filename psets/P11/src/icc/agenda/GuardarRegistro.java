/* -*- jde -*- */
/* <Buscador.java> */

package icc.agenda;

/* Lang packages */
import java.io.PrintStream;

/* Project packages */
import icc.util.Buscador;

/**GuardarRegistro
* Usada para alamacenar los registros de la DB en un archivo
*/
public class GuardarRegistro implements Buscador {

    PrintStream out;

    public GuardarRegistro(PrintStream out) {
        this.out = out;
    }

    public boolean esEste(Object o) {
        RegistroAgenda reg = (RegistroAgenda) o;
        reg.writeEntry(this.out);
        return false;
    }

}
