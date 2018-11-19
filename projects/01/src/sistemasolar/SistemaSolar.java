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

        // Asteroid belt
        Satelite a1 = new Satelite(Satelite.DatosSatelite.ASTEROID1, sol);
        Satelite a2 = new Satelite(Satelite.DatosSatelite.ASTEROID2, sol);
        Satelite a3 = new Satelite(Satelite.DatosSatelite.ASTEROID3, sol);
        Satelite a4 = new Satelite(Satelite.DatosSatelite.ASTEROID4, sol);
        Satelite a5 = new Satelite(Satelite.DatosSatelite.ASTEROID5, sol);
        Satelite a6 = new Satelite(Satelite.DatosSatelite.ASTEROID6, sol);
        Satelite a7 = new Satelite(Satelite.DatosSatelite.ASTEROID7, sol);
        Satelite a8 = new Satelite(Satelite.DatosSatelite.ASTEROID8, sol);
        Satelite a9 = new Satelite(Satelite.DatosSatelite.ASTEROID9, sol);
        Satelite a10 = new Satelite(Satelite.DatosSatelite.ASTEROID10, sol);
        Satelite a11 = new Satelite(Satelite.DatosSatelite.ASTEROID11, sol);
        Satelite a12 = new Satelite(Satelite.DatosSatelite.ASTEROID12, sol);
        Satelite a13 = new Satelite(Satelite.DatosSatelite.ASTEROID13, sol);
        Satelite a14 = new Satelite(Satelite.DatosSatelite.ASTEROID14, sol);
        Satelite a15 = new Satelite(Satelite.DatosSatelite.ASTEROID15, sol);
        Satelite a16 = new Satelite(Satelite.DatosSatelite.ASTEROID16, sol);
        Satelite a17 = new Satelite(Satelite.DatosSatelite.ASTEROID17, sol);
        Satelite a18 = new Satelite(Satelite.DatosSatelite.ASTEROID18, sol);
        Satelite a19 = new Satelite(Satelite.DatosSatelite.ASTEROID19, sol);
        Satelite a20 = new Satelite(Satelite.DatosSatelite.ASTEROID20, sol);
        Satelite a21 = new Satelite(Satelite.DatosSatelite.ASTEROID21, sol);
        Satelite a22 = new Satelite(Satelite.DatosSatelite.ASTEROID22, sol);
        Satelite a23 = new Satelite(Satelite.DatosSatelite.ASTEROID23, sol);
        Satelite a24 = new Satelite(Satelite.DatosSatelite.ASTEROID24, sol);
        Satelite a25 = new Satelite(Satelite.DatosSatelite.ASTEROID25, sol);
        Satelite a26 = new Satelite(Satelite.DatosSatelite.ASTEROID26, sol);
        Satelite a27 = new Satelite(Satelite.DatosSatelite.ASTEROID27, sol);
        Satelite a28 = new Satelite(Satelite.DatosSatelite.ASTEROID28, sol);
        Satelite a29 = new Satelite(Satelite.DatosSatelite.ASTEROID29, sol);
        Satelite a30 = new Satelite(Satelite.DatosSatelite.ASTEROID30, sol);
        Satelite a31 = new Satelite(Satelite.DatosSatelite.ASTEROID31, sol);
        Satelite a32 = new Satelite(Satelite.DatosSatelite.ASTEROID32, sol);
        Satelite a33 = new Satelite(Satelite.DatosSatelite.ASTEROID33, sol);
        Satelite a34 = new Satelite(Satelite.DatosSatelite.ASTEROID34, sol);
        Satelite a35 = new Satelite(Satelite.DatosSatelite.ASTEROID35, sol);
        Satelite a36 = new Satelite(Satelite.DatosSatelite.ASTEROID36, sol);
        Satelite a37 = new Satelite(Satelite.DatosSatelite.ASTEROID37, sol);
        Satelite a38 = new Satelite(Satelite.DatosSatelite.ASTEROID38, sol);
        Satelite a39 = new Satelite(Satelite.DatosSatelite.ASTEROID39, sol);
        Satelite a40 = new Satelite(Satelite.DatosSatelite.ASTEROID40, sol);
        Satelite a41 = new Satelite(Satelite.DatosSatelite.ASTEROID41, sol);
        Satelite a42 = new Satelite(Satelite.DatosSatelite.ASTEROID42, sol);
        Satelite a43 = new Satelite(Satelite.DatosSatelite.ASTEROID43, sol);
        Satelite a44 = new Satelite(Satelite.DatosSatelite.ASTEROID44, sol);
        Satelite a45 = new Satelite(Satelite.DatosSatelite.ASTEROID45, sol);
        Satelite a46 = new Satelite(Satelite.DatosSatelite.ASTEROID46, sol);
        Satelite a47 = new Satelite(Satelite.DatosSatelite.ASTEROID47, sol);
        Satelite a48 = new Satelite(Satelite.DatosSatelite.ASTEROID48, sol);
        Satelite a49 = new Satelite(Satelite.DatosSatelite.ASTEROID49, sol);
        Satelite a50 = new Satelite(Satelite.DatosSatelite.ASTEROID50, sol);
        Satelite a51 = new Satelite(Satelite.DatosSatelite.ASTEROID51, sol);
        Satelite a52 = new Satelite(Satelite.DatosSatelite.ASTEROID52, sol);
        Satelite a53 = new Satelite(Satelite.DatosSatelite.ASTEROID53, sol);
        Satelite a54 = new Satelite(Satelite.DatosSatelite.ASTEROID54, sol);
        Satelite a55 = new Satelite(Satelite.DatosSatelite.ASTEROID55, sol);
        Satelite a56 = new Satelite(Satelite.DatosSatelite.ASTEROID56, sol);
        Satelite a57 = new Satelite(Satelite.DatosSatelite.ASTEROID57, sol);
        Satelite a58 = new Satelite(Satelite.DatosSatelite.ASTEROID58, sol);
        Satelite a59 = new Satelite(Satelite.DatosSatelite.ASTEROID59, sol);
        Satelite a60 = new Satelite(Satelite.DatosSatelite.ASTEROID60, sol);
        Satelite a61 = new Satelite(Satelite.DatosSatelite.ASTEROID61, sol);
        Satelite a62 = new Satelite(Satelite.DatosSatelite.ASTEROID62, sol);
        Satelite a63 = new Satelite(Satelite.DatosSatelite.ASTEROID63, sol);
        Satelite a64 = new Satelite(Satelite.DatosSatelite.ASTEROID64, sol);
        Satelite a65 = new Satelite(Satelite.DatosSatelite.ASTEROID65, sol);
        Satelite a66 = new Satelite(Satelite.DatosSatelite.ASTEROID66, sol);
        Satelite a67 = new Satelite(Satelite.DatosSatelite.ASTEROID67, sol);
        Satelite a68 = new Satelite(Satelite.DatosSatelite.ASTEROID68, sol);
        Satelite a69 = new Satelite(Satelite.DatosSatelite.ASTEROID69, sol);
        Satelite a70 = new Satelite(Satelite.DatosSatelite.ASTEROID70, sol);
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
