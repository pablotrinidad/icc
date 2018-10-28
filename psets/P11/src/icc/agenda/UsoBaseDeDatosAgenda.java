/* Package definition */
package icc.agenda;

/* Lang libraries */
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/* Local libraries */
import icc.agenda.RegistroAgenda;


public class UsoBaseDeDatosAgenda {

    private Scanner in;
    private BaseDeDatosAgenda db;

    // Database's data is stored in a list of lists like: [a, b, c..., n] where
    // a, b, c ..., n are of type [str:name, str:addr, str:phone]
    private List<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    /* Create instance with an STDIN reader */
    public UsoBaseDeDatosAgenda() {
        in = new Scanner(System.in);
        db = new BaseDeDatosAgenda();
    }

    /* Handle contact creation */
    private RegistroAgenda createNewContact() {
        String[] row = new String[3];
        String[] fields = {"nombre", "dirección", "teléfono"};
        for (int i=0; i<3 ; i++) {
            System.out.println("Ingrese " + fields[i] + " del nuevo contacto:");
            row[i] = in.nextLine();
        }
        return new RegistroAgenda(row[0], row[1], Integer.parseInt(row[2]));
    }

    /* Handle contact search by name */
    private void handleSearchByName() {
        System.out.println("Ingresa el nombre que deseas usar en la búsqueda:");
        String q = in.nextLine();
        System.out.println("Buscando contacto...");
        RegistroAgenda r = db.dameRegistroPorNombre(q);
        if (r != null) {
            System.out.println("Registro encontrado: " + r);
        } else {
            System.out.println("No se encontrón nada :(");
        }
    }

    /* Handle contact search by phone */
    private void handleSearchByPhone() {
        System.out.println("Ingresa el teléfono que deseas usar en la búsqueda:");
        int q = Integer.parseInt(in.nextLine());
        System.out.println("Buscando contacto...");
        RegistroAgenda r = db.dameRegistroPorTelefono(q);
        if (r != null) {
            System.out.println("Registro encontrado: " + r);
        } else {
            System.out.println("No se encontrón nada :(");
        }
    }

    /* Handle DB export (write in file) */
    private void handleDBExport() {
        System.out.println("Ingresa la ruta ABSOLUTA donde quieras guardar la agenda:");
        String location = in.nextLine();
        db.guardarAgenda(location);
    }

    /* Handle DB import (read from file) */
    private void handleDBImport() {
        System.out.println("Ingresa la ruta ABSOLUTA donde se encuentran los registros");
        String location = in.nextLine();
        try (Scanner fin = new Scanner(new FileReader(location))) {
            String[] row = new String[3];
            int index = 0;
            boolean keepGoing = true;
            while(keepGoing) {
                if (index == 3) {
                    RegistroAgenda newContact = new RegistroAgenda(row[0], row[1], Integer.parseInt(row[2]));
                    db.add(newContact);
                    System.out.println("Nuevo contacto creado: (" + newContact + ")");
                    index = 0;
                    keepGoing = fin.hasNextLine();
                } else {
                    String line = fin.nextLine();
                    row[index] = line;
                    index += 1;
                    keepGoing = fin.hasNextLine() || index == 3;
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("No se encontró el archivo " + location);
        }
    }

    /* Parse main option from menu */
    private boolean parseOption(int o) {
        boolean action = true;
        switch (o) {
            case 1:
                System.out.println("Base de datos lista!");
                break;
            case 2:
                handleDBImport();
                break;
            case 3:
                handleDBExport();
                break;
            case 4: // Add new contact
                RegistroAgenda newContact = createNewContact();
                db.add(newContact);
                System.out.println("Nuevo contacto creado: (" + newContact + ")");
                break;
            case 5: // Search contact by name
                handleSearchByName();
                break;
            case 6:
                handleSearchByPhone();
                break;
            case 7:
                db.printDBEntries();
                break;
            case 8:
                System.out.println("Adios!");
                action = false;
                break;
        }
        return action;
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

    /* Main method */
    public static void main(String[] args) {
        UsoBaseDeDatosAgenda app = new UsoBaseDeDatosAgenda();
        app.start();
    }

}
