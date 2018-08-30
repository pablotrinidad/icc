package icc.p03;

public class Prueba {

    public static void main(String[] args) {
        // Ejercicio 1
        System.out.println("======= Ejercicio 1 =======");
        System.out.println("10.0 % 3.0 = " + 10.0 % 3.0);

        // Ejericio 2
        System.out.println("\n======= Ejercicio 2 =======");
        float x = 1F;
        float y = 0.00000001F;
        float z = x - y;
        System.out.println("z = " + z);

        // Ejericio 3
        System.out.println("\n======= Ejercicio 3 =======");
        System.out.println(1 >> 1);
        System.out.println(-1 >> 1);

        // Ejericio 4
        System.out.println("\n======= Ejercicio 4 =======");
        boolean p = true;
        boolean q = true;

        System.out.println("p\tq\t¬(p ^ q)\t¬p v ¬q");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(p + "\t" + q + "\t" + !(p || q) + "\t\t" + (!p && !q));
                q = !q;
            }
            p = !p;
        }

    }

}
