/**
* ICC Práctica 08
* UsoAjedrez.java
* Propósito: UI Para acceder a la funcionalidad de las clases
*
* @author Pablo Trinidad (github.com/pablotrinidad)
* @version 1.0 10/07/2018
*/
package icc.ajedrez;
import java.util.Scanner;

public class UsoAjedrez {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=============================================");
        System.out.println("=                  Ajedrez                  =");
        System.out.println("=============================================\n");

        boolean showMenu = true;
        while (showMenu) {
            showMainMenu();
            int choice = Integer.parseInt(in.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("\nIngresa las coordenadas");
                    System.out.println("Comencemos por la columna (a-h):");
                    int column = (int) (char) in.nextLine().charAt(0);

                    System.out.println("Ahora la fila (1-8):");
                    int row = Integer.parseInt(in.nextLine());

                    Posicion p = new Posicion('a', 1);
                    if (p.rowOutOfBound(row) || p.columnOutOfBound(column)) {
                        System.out.println("Coordenadas fuera del tablero!");
                        showMenu = true;
                    }

                    showPieceCreationMenu();
                    int pieceType = Integer.parseInt(in.nextLine());
                    int actionChoice;

                    switch (pieceType) {
                        case 1:
                            Reina reina = new Reina((char) column, row);
                            System.out.println("Nueva " + reina);
                            showPiceActionMenu();
                            actionChoice = Integer.parseInt(in.nextLine());
                            switch (actionChoice) {
                                case 1:
                                    System.out.println(reina.posiblesMovimientos());
                                    break;
                                case 2:
                                    System.out.println("¿Cuál es la columna (a-h)?:");
                                    column = (int) (char) in.nextLine().charAt(0);
                                    System.out.println("¿Cuá es la fila (1-8)?:");
                                    row = Integer.parseInt(in.nextLine());
                                    if (p.rowOutOfBound(row) || p.columnOutOfBound(column)) {
                                        System.out.println("Coordenadas fuera del tablero");
                                        showMenu = true;
                                    }
                                    if (reina.esValida(row, (char) column)) {
                                        System.out.println("Es un movimiento válido");
                                    } else {
                                        System.out.println("No es un movimiento válido");
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 2:
                            Caballo caballo = new Caballo((char) column, row);
                            System.out.println("Nuevo " + caballo);
                            showPiceActionMenu();
                            actionChoice = Integer.parseInt(in.nextLine());
                            switch (actionChoice) {
                                case 1:
                                    System.out.println(caballo.posiblesMovimientos());
                                    break;
                                case 2:
                                    System.out.println("¿Cuál es la columna (a-h)?:");
                                    column = (int) (char) in.nextLine().charAt(0);
                                    System.out.println("¿Cuá es la fila (1-8)?:");
                                    row = Integer.parseInt(in.nextLine());
                                    if (p.rowOutOfBound(row) || p.columnOutOfBound(column)) {
                                        System.out.println("Coordenadas fuera del tablero");
                                        showMenu = true;
                                    }
                                    if (caballo.esValida(row, (char) column)) {
                                        System.out.println("Es un movimiento válido");
                                    } else {
                                        System.out.println("No es un movimiento válido");
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 3:
                            Rey rey = new Rey((char) column, row);
                            System.out.println("Nuevo " + rey);
                            showPiceActionMenu();
                            actionChoice = Integer.parseInt(in.nextLine());
                            switch (actionChoice) {
                                case 1:
                                    System.out.println(rey.posiblesMovimientos());
                                    break;
                                case 2:
                                    System.out.println("¿Cuál es la columna (a-h)?:");
                                    column = (int) (char) in.nextLine().charAt(0);
                                    System.out.println("¿Cuá es la fila (1-8)?:");
                                    row = Integer.parseInt(in.nextLine());
                                    if (p.rowOutOfBound(row) || p.columnOutOfBound(column)) {
                                        System.out.println("Coordenadas fuera del tablero");
                                        showMenu = true;
                                    }
                                    if (rey.esValida(row, (char) column)) {
                                        System.out.println("Es un movimiento válido");
                                    } else {
                                        System.out.println("No es un movimiento válido");
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            showMenu = true;
                            break;
                    }
                    break;

                default:
                    showMenu = false;
                    break;
            }
        }
    }

    public static void showPiceActionMenu() {
         System.out.println("\nSelecciona la acción que quieras realizar");
        System.out.println("\t1) Ver todos los movimientos posibles");
        System.out.println("\t2) Consultar si movimento es válido");
        System.out.println("\t3) Regresar");
    }

    public static void showPieceCreationMenu() {
        System.out.println("\nSelecciona el tipo");
        System.out.println("\t1) Reina");
        System.out.println("\t2) Caballo");
        System.out.println("\t3) Rey");
        System.out.println("\t4) Regresar");
    }

    public static void showMainMenu() {
        System.out.println("Menú - Selecciona una opción:");
        System.out.println("\t1) Crear pieza");
        System.out.println("\t2) Salir");
    }

}
