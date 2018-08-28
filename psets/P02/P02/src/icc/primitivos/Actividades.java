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
        System.out.println("Permissions: rwx r-x r--");
        String permissions_b8 = "0754";
        int permissions_b10 = Integer.parseInt(permissions_b8, 8);
        System.out.println("Base 8: " + permissions_b8);
        System.out.println("Base 10: " + permissions_b10);
        System.out.print("Base 2: ");
        printer.imprime(permissions_b10);

        // 2.4
        System.out.println("\n\n====== Actividad 2.4 ======");
        System.out.print("Original value: ");
        printer.imprime(permissions_b10);

        System.out.print("\n<< 1: ");
        printer.imprime(permissions_b10 << 1);
        System.out.print("<< 3: ");
        printer.imprime(permissions_b10 << 3);

        System.out.print("\n>> 1: ");
        printer.imprime(permissions_b10 >> 1);
        System.out.print(">> 3: ");
        printer.imprime(permissions_b10 >> 3);

        System.out.print("\n>>> 1: ");
        printer.imprime(permissions_b10 >>> 1);
        System.out.print(">>> 3: ");
        printer.imprime(permissions_b10 >>> 3);
    }

}
