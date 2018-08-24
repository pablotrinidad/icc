package icc.entrada;

/**
 * Imprime en la consola los argumentos que le fueron pasados a este programa.
 * Todo programa de Java se encuentra de una construcción llamada <code>class</code>.
 */
public class Entrada {

	/**
	 * Método principal, tú código comienza a ejecutarse aquí.
	 * @param args Esta variable permite acceder a cada argumento.
	 *             Los argumentos son cadenas de caracteres <code>String</code>.
	 */
	public static void main(String[] args) {

		if(args.length == 0) {

			/* Para usar colores en una consola de Linux se usan
			 * códigos como '\033[35m' ('\003' ó '\e' son códigos para 'escape').
			 * Si quieres jugar con ellos consulta las opciones en:
			 * https://misc.flogisoft.com/bash/tip_colors_and_formatting */

			System.out.println("\033[31mNo se recibieron indicaciones.\033[0m");
		}

		/* Imprime el contenido de args. */
		for(int i = 0; i < args.length; i++) {

			// Solicitamos al sistema que envíe un mensaje a la salida estándar.
			System.out.println("\033[35mArgumento " + i + ": \033[0m" + args[i] );
		}

	}

}
