/* -*- jde -*- */
/* <BaseDeDatosAgenda.java> */

package icc.agenda;

import icc.agenda.RegistroAgenda;
import icc.util.ManejadorDeLista;

/**
 * Clase para representar una Base de Datos de agenda.
 *
 * Una base de datos debe ser capaz de obtener registros, y campos
 * de sus registros, y debe ser capaz de reconocer si un campo o registro
 * solicitado no existe, y dar una respuesta coherente.
 */
public class BaseDeDatosAgenda {

    /**
     * Este objeto llevará el control de los registros guardados en la lista.
     */
    private ManejadorDeLista tabla = new ManejadorDeLista();

    /**
     * Constructor.
     * @param datos Una cadena con el formato requerido por esta base
     *        con los registros de nombres, direcciones y teléfonos.
     * @param tam_nombre
     */
    public BaseDeDatosAgenda(String data, int nameLength, int addrLength, int phoneLength) {
        int entryLength = nameLength + addrLength + phoneLength;
        int index = 0;
        while (index < data.length()) {
            String name = data.substring(index, index + nameLength).trim();
            index += nameLength;

            String address = data.substring(index, index + addrLength).trim();
            index += addrLength;

            int phone = Integer.parseInt(data.substring(index, index + phoneLength).trim());
            index += phoneLength;

            RegistroAgenda dbEntry = new RegistroAgenda(name, address, phone);
            tabla.agrega(dbEntry);
        }
    }

    public RegistroAgenda dameRegistroPorNombre (String nombre) {
        // para encontrar el registro correcto dentro de la lista.
        BuscadorPorNombre s = new BuscadorPorNombre(nombre);
        return tabla.encuentra(s);
    }

    public RegistroAgenda dameRegistroPorTelefono (int tel) {
        // Usa BuscadorPorTelefono y el método encuentra de ManejadorDeLista
        // para encontrar el registro correcto dentro de la lista.
        BuscadorPorTelefono s = new BuscadorPorTelefono(tel);
        return tabla.encuentra(s);
    }
}
