package icc.p13;

// Lang libraries
import java.io.FileNotFoundException;


public class UsoEstadisticas {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];

        Estadisticas stats = new Estadisticas(fileName);
        double mean = stats.media();
        double variance = stats.varianza();

        System.out.println("Media\t\t" + mean);
        System.out.println("Varianza\t" + variance);
    }

}
