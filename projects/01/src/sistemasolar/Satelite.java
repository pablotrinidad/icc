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
        MERCURY(0.4, 0.2, 0.15, 0.1, Color.rgb(163, 166, 175), 0.0),
        VENUS(0.9, 0.3, 0.2, 0.5, Color.rgb(228, 168, 72), 0.0),
        EARTH(1.0, 0.5, 0.3, .6, Color.rgb(44, 55, 177), 0.0),
        MARS(0.5, 0.7, 0.4, .7, Color.rgb(221, 51, 51), 0.0),
        JUPITER(3, 1.2, .9, .8, Color.rgb(227, 200, 182), 0.0),
        SATURN(2.5, 1.5, 1.2, .9, Color.rgb(204, 167, 116), 0.0),
        URANUS(.5, 1.5, 1.3, 1, Color.rgb(160, 212, 244), 0.0),
        NEPTUNE(.5, 1.7, 1.5, 1.1, Color.rgb(71, 110, 254), 0.0),
        PLUTO(.5, 1.4, 1.6, .9, Color.rgb(255, 255, 255), 15),
        MOON(0.273, ESCALA_ORBITA_SATELITE * 0.00257, ESCALA_ORBITA_SATELITE * 0.002566, 0.05, Color.rgb(255, 255, 255), 0.0),
        IO(0.24, .11, .11, 0.2, Color.rgb(255, 243, 147), 0.0),
        EUROPA(0.2, .09, .09, .1, Color.rgb(242, 133, 0), 0.0),
        GANYMEDE(0.36, .13, .13, .6, Color.rgb(51, 102, 204), 0.0),
        CALLISTO(0.4, .15, .15, 0.5, Color.rgb(221, 51, 51), 0.0),
        DEFAULT(0, 0, 0, 0, Color.rgb(255, 255, 255), 0);;
        private final double diametroEcuatorial;
        private final double semiejeMayor;
        private final double semiejeMenor;
        private final double periodoOrbital;
        private final double inclination;
        private final Color color;


        DatosSatelite(double diametroEcuatorial,
                  double semiejeMayor, double semiejeMenor,
                  double periodoOrbital, Color color, double inclination) {
            this.diametroEcuatorial = diametroEcuatorial;
            this.color = color;
            this.semiejeMayor = semiejeMayor;
            this.inclination = inclination;
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

    public double getInclination() {
      return datos.inclination;
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

    public Satelite(double d, double a, double b, double p, Color color, double inc, Astro foco) {
        super(d * ESCALA_RADIO, color);
        this.datos = Satelite.DatosSatelite.DEFAULT;
        // Crea orbita usando datos recibidos
        foco.getNodo().getChildren().add(this.nodo);
        this.foco = foco;
        orbita = new OrbitaTransition(this,
                    a * ESCALA_ORBITA,
                    b * ESCALA_ORBITA,
                    p * ESCALA_TIEMPO
        );
        orbita.play();
    }

    /**
     * Devuelve el nombre de este satélite.
     * @return nombre
     */
    public String getNombre() {
        return this.datos.toString();
    }
}
