package icc.clases;

/* Clase Ciudadano */
public class Ciudadano {

    private String nombre; // Nombre
    private String apellidoPaterno; // Apellido paterno
    private String apellidoMaterno; // Apellido materno
    private String fechaDeNacimiento; // Fecha de nacimiento con formato dd/mm/aaaa

    /* Constructor principal */
    public Ciudadano(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    /* Calcula RFC usando las reglas de la práctica
    * y regresa su valor en mayúsculas.
    */
    public String calculaRFC() {
        String rfc = this.apellidoPaterno.substring(0, 2) + // Primeras dos letras del apellido paterno
                     this.apellidoMaterno.substring(0, 1) + // Primera letra del apellido materno
                     this.nombre.substring(0, 1) + // Primera letra del nombre
                     this.fechaDeNacimiento.split("/")[2].substring(2, 4) + // Últimos dos dígitos del año de nacimiento
                     this.fechaDeNacimiento.split("/")[1] + // Dígitos del mes de nacimiento
                     this.fechaDeNacimiento.split("/")[0]; // Dígitos del día de nacimiento

        /* Versión en mayúsculas de la cadena recién calculada */
        return rfc.toUpperCase();
    }

    /* Regresa nombre, fecha de nacimiento y RFC separado por un guión (-) */
    public String toString() {
        return String.join(" - ", this.nombre, this.fechaDeNacimiento, this.calculaRFC());
    }

}
