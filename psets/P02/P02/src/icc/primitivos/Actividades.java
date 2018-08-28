package icc.primitivos;


public class Actividades {

    public static void main(String[] args) {
        ImpresoraBinario printer = new ImpresoraBinario();

        // 2.1
        System.out.println("Actividad 2.1");
        int max = Integer.MAX_VALUE;
        int maxPlusOne = max + 1;
        System.out.println("Variable\t\tBase 10\t\tBase 2");
        System.out.print("max\t\t" + max + "\t");
        printer.imprime(max);
        System.out.print("max + 1\t\t" + maxPlusOne + "\t");
        printer.imprime(maxPlusOne);
    }

}
