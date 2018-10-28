/* -*- jde -*- */
/* <BaseDeDatosAgenda.java> */

package icc.agenda;

import icc.agenda.RegistroAgenda;
import icc.util.ManejadorDeLista;

/* Lang packages */
import java.io.FileNotFoundException;
import java.io.PrintStream;

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
    private ManejadorDeLista tabla;

    /**
    * Constructor vació
    *
    */
    public BaseDeDatosAgenda() {
        tabla = new ManejadorDeLista();
    }

    /**
     * Constructor.
     * @param datos Una cadena con el formato requerido por esta base
     *        con los registros de nombres, direcciones y teléfonos.
     * @param tam_nombre
     */
    public BaseDeDatosAgenda(String data, int nameLength, int addrLength, int phoneLength) {
        tabla = new ManejadorDeLista();
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

    /**
    * add
    * @param contact New contacto to be added to table
    */
    public void add(RegistroAgenda contact) {
        tabla.agrega(contact);
    }

    public RegistroAgenda dameRegistroPorNombre (String nombre) {
        // Usa BuscadorPorNombre y el método encuentra de ManejadorDeLista
        // para encontrar el registro correcto dentro de la lista.
        BuscadorPorNombre s = new BuscadorPorNombre(nombre);
        return (RegistroAgenda) tabla.encuentra(s);
    }

    public RegistroAgenda dameRegistroPorTelefono (int tel) {
        // Usa BuscadorPorTelefono y el método encuentra de ManejadorDeLista
        // para encontrar el registro correcto dentro de la lista.
        BuscadorPorTelefono s = new BuscadorPorTelefono(tel);
        return (RegistroAgenda) tabla.encuentra(s);
    }

    /**
    * guardarAgenda
    * @param nombreArchivo   nombre del archivo en el que guardará la DB (dirección absoluta).
    *
    * Inicializa el PrintStream que será usado por el resto de las clases
    */
    public void guardarAgenda(String nombreArchivo) {
        try (PrintStream  fout = new PrintStream(nombreArchivo)) {
            GuardarRegistro gr = new GuardarRegistro(fout);
            tabla.encuentra(gr);
        } catch (FileNotFoundException fnfe) {
            System.err.println(
                "No se encontró el archivo " +
                nombreArchivo + " y no pudo ser creado"
            );
        } catch (SecurityException se) {
            System.err.println(
                "No se tiene permiso de escritura sobre el archivo"
            );
        }
    }
}
