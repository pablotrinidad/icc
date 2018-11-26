package app;

import automatas.seismic.SeismicActivity;

import java.util.Scanner;

public class Main {

    private Scanner in;

    public Main () {
        this.in = new Scanner(System.in);
    }

    public void start () {
        System.out.println("================================");
        System.out.println("ICC - Proyecto 2 (Autómatas)");
        System.out.println("================================");
        System.out.println("¿Qué modelo deseas correr?");
        System.out.println("\t[1] Actividad sísimica");
        System.out.println("\t[2] Propagación de epidemias");
        System.out.println("\t[3] Incendios forestales");

        int option = this.parseInput();
        this.runSimulation(option);
    }

    private void runSimulation(int option) {
        System.out.println("¿Por cuántos pasos temporales deseas correr la simulación?");
        int t = this.in.nextInt();
        System.out.println("¿Cuántas unidades de largo medirán los lados de la malla (cuadrada)?");
        int n = this.in.nextInt();
        switch (option) {
            case 1:
                System.out.println("Ingresa el valor umbral");
                int threshold  = this.in.nextInt();
                SeismicActivity simulation = new SeismicActivity(threshold, t, n);
                simulation.start();
                simulation.plot();
                break;
            default:
                System.out.println(option);
        }
    }

    private int parseInput() {
        boolean error = false;
        int option = -1;
        try {
            option = Integer.parseInt(in.nextLine());
            error = (option < 1) || (option > 3);
        } catch (NumberFormatException e) { error = true; }
        if (error) {
            System.out.println("Por favor ingresa un número que esté dentro del menú");
            System.exit(1);
        }
        return option;
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

}
