/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import static javafx.application.Application.launch;
import java.util.Random;

/**
 * Simulación del sistema solar utilizando JavaFX
 * https://docs.oracle.com/javase/8/javafx/api/index.html
 * @author blackzafiro
 */
public class SistemaSolar extends Application {

    private final static int ANCHO_VENTANA_INICIAL = 2000;
    private final static int ALTO_VENTANA_INICIAL = 1000;
    private final static int RADIO_SOL = 30;

    // Planets
    private Astro sol;
    private Satelite mercury;
    private Satelite venus;
    private Satelite earth;
    private Satelite mars;
    private Satelite jupiter;
    private Satelite saturn;
    private Satelite uranus;
    private Satelite neptune;
    private Satelite pluto;

    // Planets' satellites
    private Satelite moon;

    private Satelite io;
    private Satelite europa;
    private Satelite ganymede;
    private Satelite callisto;

    // Asteroides
    // private Satelite asteroides;

    public static int getSolCentroX() {
        return ANCHO_VENTANA_INICIAL/2;
    }

    public static int getSolCentroY() {
        return ALTO_VENTANA_INICIAL/2;
    }

    /**
     * Crea al sol, los planteas y sus satélites, asignando quien gira
     * alrededor de quien.
     */
    private void creaAstros() {
        sol = new Astro(RADIO_SOL, Color.rgb(225, 69, 30));

        // Planets
        mercury = new Satelite(Satelite.DatosSatelite.MERCURY, sol);
        venus = new Satelite(Satelite.DatosSatelite.VENUS, sol);
        earth = new Satelite(Satelite.DatosSatelite.EARTH, sol);
        mars = new Satelite(Satelite.DatosSatelite.MARS, sol);
        jupiter = new Satelite(Satelite.DatosSatelite.JUPITER, sol);
        saturn = new Satelite(Satelite.DatosSatelite.SATURN, sol);
        uranus = new Satelite(Satelite.DatosSatelite.URANUS, sol);
        neptune = new Satelite(Satelite.DatosSatelite.NEPTUNE, sol);
        pluto = new Satelite(Satelite.DatosSatelite.PLUTO, sol);

        // Planets' satellites
        moon = new Satelite(Satelite.DatosSatelite.MOON, earth);
        io = new Satelite(Satelite.DatosSatelite.IO, jupiter);
        europa = new Satelite(Satelite.DatosSatelite.EUROPA, jupiter);
        ganymede = new Satelite(Satelite.DatosSatelite.GANYMEDE, jupiter);
        callisto = new Satelite(Satelite.DatosSatelite.CALLISTO, jupiter);

        int n = 1500; // Numero de asteroides
        Random r = new Random();
        Satelite[] asteroids = new Satelite[n];
        for (int i = 0; i < n; i++) {
            asteroids[i] = new Satelite(
                .1 + (.2 - .1) * r.nextDouble(), // .1 - .4
                .85 + (.89 - .85) * r.nextDouble(),  // .71 - .89
                .41 + (.59 - .41) * r.nextDouble(), // .41 - .59
                .51 + (1 - .51) * r.nextDouble(), // .71 - .79
                Color.rgb(255, 255, 255),
                0.0,
                sol
            );
        }

    }

    /**
     * Crea la escena y agrega los primeros nodos, sobre los cuales
     * se han agregado a los demás astros.
     * @return la escena con el sol, planetas y satélites.
     */
    private Scene montaNodos() {
        AnchorPane root = new AnchorPane();
        root.setLayoutX(getSolCentroX() - RADIO_SOL);
        root.setLayoutY(getSolCentroY() - RADIO_SOL);

        root.getChildren().add(sol.getNodo());

        Scene scene = new Scene(root, ANCHO_VENTANA_INICIAL, ALTO_VENTANA_INICIAL, Color.rgb(0, 0, 0));
        return scene;
    }

    /**
     * Acomoda los elementos en la intefaz e inicia la animación.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        creaAstros();

        Scene scene = montaNodos();
        primaryStage.setTitle("Sistema solar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Inicia la simulación.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
