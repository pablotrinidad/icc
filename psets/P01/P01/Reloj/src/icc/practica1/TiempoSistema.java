/* -*- jde -*- */
/*  <TimepoSistema.java>  */

package icc.practica1;

import java.time.ZonedDateTime;

/**
 * Clase que asigna la hora del sistema a su reloj.
 * @author BlackZafiro
 */
public class TiempoSistema {

	/**
	 * Reloj que guarda la hora a mostrar.
	 */
	private Reloj reloj;	

	/**
	 * Constructor que recibe al reloj donde se guardará el tiempo.
	 */
	public TiempoSistema(Reloj reloj) {
		this.reloj = reloj;
		actualizaReloj();
	}

	/**
	 * Pregunta la hora al sistema y la guarda en el reloj.
	 */
	public void actualizaReloj() {
		ZonedDateTime now = ZonedDateTime.now();
		reloj.ponTiempo(now.getHour(), now.getMinute(), now.getSecond());
	}

	/**
	 * Muestra la hora actual del sistema en la interfaz gráfica durante
	 * el tiempo indicado.
	 * @param vista El objeto interfaz gráfica para el reloj.
	 * @param segundos Los segundos durante los cuales funcionará el reloj.
	 */
	public void funcionaUnRatito(VistaReloj vista, int segundos) {
		for(int i = 0; i < segundos; i++){
			vista.espera(1);
			actualizaReloj();
			vista.actualiza();
		}
	}
}

/*  <TimepoSistema.java>  */
