/** Clase Registro
* Almacena los datos de cada contacto.
*
*  @author Pablo Trindiad <github.com/pablotrinidad>
*/

package icc.contactos;


public class Registro {

    public String nombre, direccion, telefono;

    public Registro siguiente = null;

    /** Constructor principal
    * @param nombre         Nombre del contacto
    * @param direccion      Direccion del contacto
    * @param telefono       Teléfono del contacto
    *
    * @return Asigna valores recibidos a cada variable, sólo si no son nulos
    */
    public Registro (String nombre, String direccion, String telefono){
        this.nombre = nombre.length() != 0 ? nombre : "Default contact name";
        this.direccion = direccion.length() != 0 ? direccion : "Default contact address";
        this.telefono = telefono.length() != 0 ? telefono : "+XX XX XXXX XXXX";
    }

    /* Getter de nombre */
    public String getNombre() { return this.nombre; }

    /** Setter de nombre
    * @param nombre     Nombre del contacto
    *
    * @return Asigna el valor recibido sólo si no es nulo, si es nulo, último valor prevalece
    */
    public void setNombre(String nombre) {
        if (nombre != null) { this.nombre = nombre; }
    }

    /* Getter de direccion */
    public String getDireccion() { return this.direccion; }

    /** Setter de direccion
    * @param direccion     Dirección del contacto
    *
    * @return Asigna el valor recibido sólo si no es nulo, si es nulo, último valor prevalece
    */
    public void setDireccion(String direccion) {
        if (direccion != null) { this.direccion = direccion; }
    }

    /* Getter de telefono */
    public String getTelefono() { return this.telefono; }

    /** Setter de telefono
    * @param telefono     Teléfono del contacto
    *
    * @return Asigna el valor recibido sólo si no es nulo, si es nulo, último valor prevalece
    */
    public void setTelefono(String telefono) {
        if (telefono != null) { this.telefono = telefono; }
    }

    /** toString
    * @return Regresa los datos de la clase unidos por un espacio
    */
    public String toString() {
        return String.join("\t|\t", this.nombre, this.telefono, this.direccion);
    }

    /* Getter del siguiente contact */
    public Registro getSiguiente() {
        return this.siguiente;
    }

    /** Setter de siguiente contacto
    * @param siguiente     Siguiente contacto
    *
    * @return Asigna el valor recibido sólo si no es nulo, si es nulo, último valor prevalece
    */
    public void setSiguiente(Registro siguiente) {
        this.siguiente = siguiente;
    }

}
