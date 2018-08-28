package icc.primitivos;


public class Actividades {

    public static void main(String[] args) {
        ImpresoraBinario printer = new ImpresoraBinario();

        // 2.1
        System.out.println("====== Actividad 2.1 ======");
        System.out.println("Variable\t\tBase 10\t\tBase 2");

        int max = Integer.MAX_VALUE;
        System.out.print("max\t\t" + max + "\t");
        printer.imprime(max);

        int maxPlusOne = max + 1;
        System.out.print("max + 1\t\t" + maxPlusOne + "\t");
        printer.imprime(maxPlusOne);

        // 2.2
        System.out.println("\n\n====== Actividad 2.2 ======");
        System.out.println("Variable\tBase 2");

        double nan = Double.NaN;
        System.out.print(nan + "\t\t");
        printer.imprime(nan);

        double negativeInf = Double.NEGATIVE_INFINITY;
        System.out.print(negativeInf + "\t");
        printer.imprime(negativeInf);

        double positiveInf = Double.POSITIVE_INFINITY;
        System.out.print(positiveInf + "\t");
        printer.imprime(positiveInf);

        double zero = 0.0;
        System.out.print(zero + "\t\t");
        printer.imprime(zero);

        double negativeZero = -0.0;
        System.out.print(negativeZero + "\t\t");
        printer.imprime(negativeZero);

        // 2.3
        System.out.println("\n\n====== Actividad 2.3 ======");
        int permisos = Integer.parseInt("0754", 8);
        printer.imprime(permisos);
        System.out.println(permisos);
    }

}
