/* Package definition */
package icc.agenda;

/* Lang libraries */
import java.util.Scanner;

/* Local libraries */
import icc.agenda.RegistroAgenda;


public class UsoBaseDeDatosAgenda {

    private Scanner in;

    public UsoBaseDeDatosAgenda() {
        in = new Scanner(System.in);
    }

    /* Print user menu */
    private void printMenu() {
        System.out.println("Escoje una opción:");
        System.out.println("\t1) Crear una base de datos");
        System.out.println("\t2) Cargar de disco");
        System.out.println("\t3) Guardar la agenda");
        System.out.println("\t4) Agregar un registro");
        System.out.println("\t5) Buscar por nombre");
        System.out.println("\t6) Buscar por teléfono");
        System.out.println("\t7) Imprimirla toda");
        System.out.println("\t8) Salir");
    }

    /* Parse main option from menu */
    private boolean parseOption(int o) {
        boolean action = true;
        switch (o) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            case 6:
                System.out.println("6");
                break;
            case 7:
                System.out.println("7");
                break;
            case 8:
                System.out.println("Adios!");
                action = false;
                break;
        }
        return action;
    }

    /* Get next option from the user's input */
    private int getNextOption() {
        boolean error = false;
        int option = -1;
        try {
            option = Integer.parseInt(in.nextLine());
            if (option < 1 || option > 8) { error = true; }
        } catch (NumberFormatException e) { error = true; }
        if (error) {
            System.out.println("Por favor ingresa un número que esté dentro del menú");
        }
        return option;
    }

    public void start() {
        boolean keepGoing = true;
        int mainOption;
        while (keepGoing) {
            printMenu();
            mainOption = getNextOption();
            keepGoing = parseOption(mainOption);
        }
    }

    /* Main method */
    public static void main(String[] args) {
        UsoBaseDeDatosAgenda app = new UsoBaseDeDatosAgenda();
        app.start();
    }

}
