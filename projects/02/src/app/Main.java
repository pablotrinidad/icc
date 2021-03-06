package app;

import javafx.application.Application;
import javafx.stage.Stage;
import simulations.Simulation;
import simulations.outbreak.OutbreakSimulation;
import simulations.seismic.SeismicActivitySimulation;
import simulations.wildfire.WildfireSimulation;

import java.util.Scanner;

public class Main extends Application {

    private Scanner in = new Scanner(System.in);
    private Stage window;

    public void start (Stage window) throws Exception {
        System.out.println("================================");
        System.out.println("ICC - Proyecto 2 (Autómatas)");
        System.out.println("================================");
        System.out.println("¿Qué modelo deseas correr?");
        System.out.println("\t[1] Actividad sísimica");
        System.out.println("\t[2] Propagación de epidemias");
        System.out.println("\t[3] Incendios forestales");

        int option = this.parseInput();
        this.window = window;
        this.runSimulation(option);
    }

    private void runSimulation(int option) throws Exception {
        System.out.println("¿Por cuántos pasos temporales deseas correr la simulación?");
        int t = this.in.nextInt();
        System.out.println("¿Cuántas celdas quieres por lado?");
        int n = this.in.nextInt();
        System.out.println("¿Cuántos milisegundos quieres que dure cada paso temporal?");
        int s = this.in.nextInt();
        Simulation simulation;
        switch (option) {
            case 1:
                System.out.println("Ingresa el valor umbral");
                int threshold  = this.in.nextInt();
                simulation = new SeismicActivitySimulation(n, t, s, threshold);
                simulation.run(this.window);
                break;
            case 2:
                System.out.println("Ingrese el valor correspondiente a 'a'");
                int a = this.in.nextInt();
                System.out.println("Ingrese el valor correspondiente a 'g'");
                int g2 = this.in.nextInt();
                simulation = new OutbreakSimulation(n, t, s, a, g2);
                simulation.run(this.window);
                break;
            case 3:
                System.out.println("Ingrese un valor entre 0 y 1 correspondiente a p");
                double p = this.in.nextDouble();
                System.out.println("Ingrese un valor entre 0 y 1 correspondiente a f");
                double f = this.in.nextDouble();
                System.out.println("Ingrese un valor entre 0 y 1 correspondiente a g");
                double g = this.in.nextDouble();
                simulation = new WildfireSimulation(n, t, s, p, f, g);
                simulation.run(this.window);
                break;
            default:
                System.out.println("INVALID OPTION!!");
                break;
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
        launch(args);
    }

}
