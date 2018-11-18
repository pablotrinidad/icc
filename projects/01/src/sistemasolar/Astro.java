/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Clase que representa a todos los astros alrededor de los cuales pueden girar
 * otros astros.
 * @author blackzafiro
 */
public class Astro {

    /**
     * Panel sobre el cual se dibuja este astro y sus satélites.
     */
    protected Pane nodo;

    /**
     * Figura que representa a este astro.
     */
    protected Circle figura;

    /**
     * Constructor.
     * @param diametro Pixeles de diámetro.
     */
    public Astro(double diametro, Color color) {
        nodo = new StackPane();
        nodo.setMaxSize(100, 100);
        figura = new Circle(diametro);
        figura.setFill(color);
        nodo.getChildren().add(figura);
    }

    /**
     * Devuelve al panel sobre el cual se dibujará este astro y sus satélites.
     * @return nodo
     */
    public Pane getNodo() {
        return nodo;
    }

    /**
     * Devuelve el nodo figura que dibuja a este astro.
     * Sus coordenadas son relativas al panel que la contiene.
     * @return
     */
    public Node getFigura() {
        return figura;
    }

}
