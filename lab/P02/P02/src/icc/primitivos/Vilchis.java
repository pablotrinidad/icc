/* Vilchis
*
* Ejmplos dados en clase por el ayudante de
* laboratorio.
*/

package icc.primitivos;


public class Vilchis {

    // Main methods
    public static void main(String[] args) {
        ImpresoraBinario impresora = new ImpresoraBinario();

        // Imprime columnas usando el caracter de tabulación
        System.out.println("Int\t\t\t\tBinary");

        // Máximo valor posible para enteros
        int max = Integer.MAX_VALUE;
        System.out.print(max + "\t\t\t");
        impresora.imprime(max);

        // NaN
        double nan = Double.NaN;
        System.out.print(nan + "\t\t\t\t");
        impresora.imprime(nan);

        // Infinito positivo
        double positiveInf = Double.POSITIVE_INFINITY;
        System.out.print(positiveInf + "\t\t\t");
        impresora.imprime(positiveInf);

        // Infinito negativo
        double negativeInf = Double.NEGATIVE_INFINITY;
        System.out.print(negativeInf + "\t\t\t");
        impresora.imprime(negativeInf);

        // Cero decimal
        double zero = 0.0;
        System.out.print(zero + "\t\t\t\t");
        impresora.imprime(zero);

        // Cero negativo
        double negativeZero = -0.0;
        System.out.print(negativeZero + "\t\t\t\t");
        impresora.imprime(negativeZero);

        // Máximo valor decimal
        double maxDecimal = Double.MAX_VALUE;
        System.out.print(maxDecimal + "\t\t");
        impresora.imprime(maxDecimal);

        // Mínimo valor decimal
        double minDecimal = Double.MIN_VALUE;
        System.out.print(minDecimal + "\t\t\t");
        impresora.imprime(minDecimal);

    }

}
