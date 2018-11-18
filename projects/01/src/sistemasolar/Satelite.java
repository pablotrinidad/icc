/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;

import javafx.scene.paint.Color;

/**
 * Clase que describe astros que giran alrededor de otro.
 * @author blackzafiro
 */
public class Satelite extends Astro {

    // Escala para dibujar a los planetas
    private static final double ESCALA_RADIO = 10.0;
    private static final double ESCALA_ORBITA = 400.0;
    private static final double ESCALA_ORBITA_SATELITE = ESCALA_RADIO * 2;
    private static final double ESCALA_TIEMPO = 15.0;

    /**
     * Datos de cada planeta y satélite.
     * Deben ser ficticios, pues de otro modo la simulación no cabe en pantalla.
     */
    public enum DatosSatelite {
        MERCURY(0.4, 0.2, 0.2, 0.3, Color.rgb(163, 166, 175)),
        VENUS(0.9, 0.3, 0.3, 0.6, Color.rgb(228, 168, 72)),
        EARTH(1.0, 0.5, 0.5, 1.0, Color.rgb(44, 55, 177)),
        MARS(0.5, 0.7, 0.7, 1.8809, Color.rgb(221, 51, 51)),
        JUPITER(3, 1.2, 1.2, 3, Color.rgb(227, 200, 182)),
        SATURN(2.5, 1.6, 1.6, 3.2, Color.rgb(204, 167, 116)),
        URANUS(.5, 2, 2, 3.5, Color.rgb(160, 212, 244)),
        NEPTUNE(.5, 2.2, 2.2, 3.7, Color.rgb(71, 110, 254)),
        MOON(0.273, ESCALA_ORBITA_SATELITE * 0.00257, ESCALA_ORBITA_SATELITE * 0.002566, 0.0739, Color.rgb(255, 255, 255)),
        IO(0.24, .11, .11, 0.4, Color.rgb(255, 243, 147)),
        EUROPA(0.2, .09, .09, .3, Color.rgb(242, 133, 0)),
        GANYMEDE(0.36, .13, .13, .8, Color.rgb(51, 102, 204)),
        CALLISTO(0.4, .15, .15, 0.7, Color.rgb(221, 51, 51));;

        private final double diametroEcuatorial;
        private final double semiejeMayor;
        private final double semiejeMenor;
        private final double periodoOrbital;
        private final Color color;


        DatosSatelite(double diametroEcuatorial,
                  double semiejeMayor, double semiejeMenor,
                  double periodoOrbital, Color color) {
            this.diametroEcuatorial = diametroEcuatorial;
            this.color = color;
            this.semiejeMayor = semiejeMayor;
            this.semiejeMenor = semiejeMenor;
            this.periodoOrbital = periodoOrbital;
        }
    }

    /// Inician atributos

    private final DatosSatelite datos;
    private OrbitaTransition orbita;
    private Astro foco;


    /// Inician métodos

    /**
     * Astro alrededor del cual gira este satélite.
     * @return astro alrededor del cual girar este satélite.
     */
    public Astro getFoco() {
        return foco;
    }

    /**
     * Crea la órbita de este planea y lo pone a girar alrededor del foco.
     */
    private void creaOrbita(Astro foco) {
        foco.getNodo().getChildren().add(this.nodo);
        this.foco = foco;

        orbita = new OrbitaTransition(this,
                          datos.semiejeMayor * ESCALA_ORBITA,
                          datos.semiejeMenor * ESCALA_ORBITA,
                          datos.periodoOrbital * ESCALA_TIEMPO
        );
        orbita.play();
    }

    /**
     * Constructor.
     * @param datos información del astro y su órbita.
     * @param foco astro alrededor del cual gira este satélite.
     */
    public Satelite(DatosSatelite datos, Astro foco) {
        super(datos.diametroEcuatorial * ESCALA_RADIO, datos.color);
        this.datos = datos;
        creaOrbita(foco);
    }

    /**
     * Devuelve el nombre de este satélite.
     * @return nombre
     */
    public String getNombre() {
        return this.datos.toString();
    }
}
