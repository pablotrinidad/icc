/* -*- jde -*- */
/* <VistaReloj.java> */

package icc.practica1;

/**
 * Interfaz para definir qué servicios debe proveer la representación gráfica
 * de un Reloj.
 * @author Canek
 */
public interface VistaReloj {

    /**
     * Regresa el Reloj contenido en esta vista.
     * @return el Reloj contenido en esta vista.
     */
    public Reloj getReloj();
    

    /**
     * Actualiza la vista de acuerdo a los valores del Reloj.
     */
    public void actualiza();

    /**
     * Detiene la ejecución del programa el número de segundos que se le pide.
     * @param segundos el número de segundos a esperar.
     */
    public void espera(int segundos);
}

/* </VistaReloj.java> */
