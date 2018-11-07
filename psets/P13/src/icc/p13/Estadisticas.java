package icc.p13;

// Language libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Estadisticas {

    public double[] data;

    // Initialize class by populating the data attribute.
    public Estadisticas (String fileName) throws FileNotFoundException {
        this.data = this.cargaArreglo(fileName);
    }

    // Load data from text file (read PSet Description.pdf for more details on input format)
    private double[] cargaArreglo(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner in = new Scanner(file);

        int n = in.nextInt();
        double[] data = new double[n];

        for(int i=0; i<n; i++) {
            data[i] = in.nextDouble();
        }

        return data;
    }

    // Return "media" computed by the formula expressed in the problem set description
    public double media() {
        int n = this.data.length;
        double sum = 0.0;
        for(int i=0; i<n; i++) {
            sum += this.data[i];
        }
        return sum/n;
    }

    // Return "varianza" computed by the formula expressed in the problem set description
    public double varianza() {
        int n = this.data.length;
        double mean = this.media();
        double sum = 0.0;
        for(int i=0; i<n; i++) {
            sum += Math.pow(this.data[i] - mean, 2);
        }
        return sum/n;
    }

}
