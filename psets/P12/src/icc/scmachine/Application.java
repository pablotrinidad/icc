/**
* Application is the entry point to the features of the
* "spare change machine (maquina de cambio)". It prints an
* interactive menu for the user to interact with the application.
*
* @author Pablo Trinidad <github.com/pablotrinidad>
*/

package icc.scmachine;

// Lang libraries
import java.util.ArrayList;
import java.util.Scanner;


public class Application {

    private MaquinaDeCambio machine;
    private Scanner in;

    /* Initialize app's spare change machine. */
    public Application() {
        in = new Scanner(System.in);
        machine = new MaquinaDeCambio();
    }

    private void handleMachineExecution() {
        System.out.println("Ingrese el valor que desea obtener: ");
        int n;
        n = Integer.parseInt(this.in.nextLine());
        ArrayList<Cambio> result = this.machine.computeSpareChangeSets(n);
        System.out.println("\n==================================================================");
        System.out.println(
            result.size() +
            " posibles combinaciones de cambio para formar $" +
            Integer.toString(n) +
            ":"
        );
        for(Cambio c: result) {
            System.out.println("\t" + c);
        }
        System.out.println("==================================================================\n");
    }

    /* Parse main option from menu */
    private boolean parseOption(int o) {
        boolean action = true;
        switch (o) {
            case 1:
                handleMachineExecution();
                break;
            case 2:
                System.out.println("Adios!");
                action = false;
                break;
        }
        return action;
    }

     /* Print user menu */
    private void printMenu() {
        System.out.println("Escoje una opción:");
        System.out.println("\t1) Obtener opciones de cambio");
        System.out.println("\t2) Salir");
    }

    /* Get next option from the user's input */
    private int getNextOption() {
        boolean error = false;
        int option = -1;
        try {
            option = Integer.parseInt(in.nextLine());
            if (option < 1 || option > 2) { error = true; }
        } catch (NumberFormatException e) { error = true; }
        if (error) {
            System.out.println("Por favor ingresa un número que esté dentro del menú");
        }
        return option;
    }

    /* Handle main application */
    public void start() {
        boolean keepGoing = true;
        int mainOption;
        while (keepGoing) {
            printMenu();
            mainOption = getNextOption();
            keepGoing = parseOption(mainOption);
        }
    }

    /* Let class constructor to handle program initialization and execution */
    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}
