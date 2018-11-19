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
        JUPITER(3, 0.9, .6, .8, Color.rgb(227, 200, 182), 0.0),
        SATURN(2.5, 1.2, .9, .9, Color.rgb(204, 167, 116), 0.0),
        URANUS(.5, 1.5, 1.3, 1, Color.rgb(160, 212, 244), 0.0),
        NEPTUNE(.5, 1.7, 1.5, 1.1, Color.rgb(71, 110, 254), 0.0),
        PLUTO(.5, 1.4, 1.6, .9, Color.rgb(255, 255, 255), 15),
        MOON(0.273, ESCALA_ORBITA_SATELITE * 0.00257, ESCALA_ORBITA_SATELITE * 0.002566, 0.05, Color.rgb(255, 255, 255), 0.0),
        IO(0.24, .11, .11, 0.2, Color.rgb(255, 243, 147), 0.0),
        EUROPA(0.2, .09, .09, .1, Color.rgb(242, 133, 0), 0.0),
        GANYMEDE(0.36, .13, .13, .6, Color.rgb(51, 102, 204), 0.0),
        CALLISTO(0.4, .15, .15, 0.5, Color.rgb(221, 51, 51), 0.0),

        // Asteroides
        ASTEROID1(0.2, 0.72, 0.48, 0.81, Color.rgb(255, 255, 255), 0.0),
        ASTEROID2(0.2, 0.76, 0.48, 0.86, Color.rgb(255, 255, 255), 0.0),
        ASTEROID3(0.1, 0.77, 0.55, 0.86, Color.rgb(255, 255, 255), 0.0),
        ASTEROID4(0.2, 0.72, 0.57, 0.84, Color.rgb(255, 255, 255), 0.0),
        ASTEROID5(0.1, 0.75, 0.51, 0.83, Color.rgb(255, 255, 255), 0.0),
        ASTEROID6(0.2, 0.72, 0.54, 0.87, Color.rgb(255, 255, 255), 0.0),
        ASTEROID7(0.1, 0.75, 0.42, 0.85, Color.rgb(255, 255, 255), 0.0),
        ASTEROID8(0.1, 0.75, 0.54, 0.84, Color.rgb(255, 255, 255), 0.0),
        ASTEROID9(0.1, 0.73, 0.47, 0.83, Color.rgb(255, 255, 255), 0.0),
        ASTEROID10(0.2, 0.78, 0.52, 0.85, Color.rgb(255, 255, 255), 0.0),
        ASTEROID11(0.1, 0.73, 0.57, 0.82, Color.rgb(255, 255, 255), 0.0),
        ASTEROID12(0.2, 0.71, 0.58, 0.86, Color.rgb(255, 255, 255), 0.0),
        ASTEROID13(0.1, 0.75, 0.43, 0.87, Color.rgb(255, 255, 255), 0.0),
        ASTEROID14(0.2, 0.76, 0.57, 0.84, Color.rgb(255, 255, 255), 0.0),
        ASTEROID15(0.2, 0.76, 0.45, 0.83, Color.rgb(255, 255, 255), 0.0),
        ASTEROID16(0.1, 0.76, 0.45, 0.86, Color.rgb(255, 255, 255), 0.0),
        ASTEROID17(0.1, 0.78, 0.43, 0.85, Color.rgb(255, 255, 255), 0.0),
        ASTEROID18(0.1, 0.78, 0.46, 0.81, Color.rgb(255, 255, 255), 0.0),
        ASTEROID19(0.2, 0.72, 0.48, 0.85, Color.rgb(255, 255, 255), 0.0),
        ASTEROID20(0.2, 0.75, 0.41, 0.88, Color.rgb(255, 255, 255), 0.0),
        ASTEROID21(0.2, 0.75, 0.49, 0.83, Color.rgb(255, 255, 255), 0.0),
        ASTEROID22(0.2, 0.71, 0.43, 0.83, Color.rgb(255, 255, 255), 0.0),
        ASTEROID23(0.2, 0.77, 0.56, 0.83, Color.rgb(255, 255, 255), 0.0),
        ASTEROID24(0.2, 0.75, 0.45, 0.85, Color.rgb(255, 255, 255), 0.0),
        ASTEROID25(0.1, 0.76, 0.52, 0.83, Color.rgb(255, 255, 255), 0.0),
        ASTEROID26(0.1, 0.72, 0.48, 0.86, Color.rgb(255, 255, 255), 0.0),
        ASTEROID27(0.1, 0.71, 0.45, 0.81, Color.rgb(255, 255, 255), 0.0),
        ASTEROID28(0.2, 0.71, 0.48, 0.82, Color.rgb(255, 255, 255), 0.0),
        ASTEROID29(0.2, 0.77, 0.55, 0.87, Color.rgb(255, 255, 255), 0.0),
        ASTEROID30(0.1, 0.73, 0.47, 0.81, Color.rgb(255, 255, 255), 0.0),
        ASTEROID31(0.2, 0.78, 0.45, 0.84, Color.rgb(255, 255, 255), 0.0),
        ASTEROID32(0.2, 0.71, 0.46, 0.88, Color.rgb(255, 255, 255), 0.0),
        ASTEROID33(0.2, 0.78, 0.48, 0.86, Color.rgb(255, 255, 255), 0.0),
        ASTEROID34(0.2, 0.76, 0.46, 0.81, Color.rgb(255, 255, 255), 0.0),
        ASTEROID35(0.1, 0.74, 0.41, 0.82, Color.rgb(255, 255, 255), 0.0),
        ASTEROID36(0.1, 0.72, 0.58, 0.88, Color.rgb(255, 255, 255), 0.0),
        ASTEROID37(0.1, 0.76, 0.52, 0.84, Color.rgb(255, 255, 255), 0.0),
        ASTEROID38(0.2, 0.74, 0.42, 0.88, Color.rgb(255, 255, 255), 0.0),
        ASTEROID39(0.1, 0.77, 0.47, 0.84, Color.rgb(255, 255, 255), 0.0),
        ASTEROID40(0.1, 0.74, 0.58, 0.82, Color.rgb(255, 255, 255), 0.0),
        ASTEROID41(0.2, 0.71, 0.48, 0.86, Color.rgb(255, 255, 255), 0.0),
        ASTEROID42(0.1, 0.72, 0.53, 0.87, Color.rgb(255, 255, 255), 0.0),
        ASTEROID43(0.2, 0.75, 0.42, 0.87, Color.rgb(255, 255, 255), 0.0),
        ASTEROID44(0.2, 0.77, 0.5, 0.83, Color.rgb(255, 255, 255), 0.0),
        ASTEROID45(0.1, 0.71, 0.44, 0.86, Color.rgb(255, 255, 255), 0.0),
        ASTEROID46(0.2, 0.73, 0.53, 0.88, Color.rgb(255, 255, 255), 0.0),
        ASTEROID47(0.2, 0.75, 0.51, 0.82, Color.rgb(255, 255, 255), 0.0),
        ASTEROID48(0.1, 0.74, 0.57, 0.81, Color.rgb(255, 255, 255), 0.0),
        ASTEROID49(0.2, 0.73, 0.53, 0.88, Color.rgb(255, 255, 255), 0.0),
        ASTEROID50(0.1, 0.75, 0.55, 0.88, Color.rgb(255, 255, 255), 0.0),
        ASTEROID51(0.2, 0.72, 0.41, 0.87, Color.rgb(255, 255, 255), 0.0),
        ASTEROID52(0.2, 0.75, 0.52, 0.86, Color.rgb(255, 255, 255), 0.0),
        ASTEROID53(0.2, 0.78, 0.46, 0.82, Color.rgb(255, 255, 255), 0.0),
        ASTEROID54(0.1, 0.78, 0.43, 0.83, Color.rgb(255, 255, 255), 0.0),
        ASTEROID55(0.1, 0.72, 0.55, 0.87, Color.rgb(255, 255, 255), 0.0),
        ASTEROID56(0.1, 0.72, 0.51, 0.85, Color.rgb(255, 255, 255), 0.0),
        ASTEROID57(0.2, 0.75, 0.48, 0.83, Color.rgb(255, 255, 255), 0.0),
        ASTEROID58(0.1, 0.71, 0.48, 0.86, Color.rgb(255, 255, 255), 0.0),
        ASTEROID59(0.1, 0.72, 0.46, 0.83, Color.rgb(255, 255, 255), 0.0),
        ASTEROID60(0.2, 0.76, 0.45, 0.82, Color.rgb(255, 255, 255), 0.0),
        ASTEROID61(0.2, 0.73, 0.42, 0.88, Color.rgb(255, 255, 255), 0.0),
        ASTEROID62(0.2, 0.72, 0.44, 0.85, Color.rgb(255, 255, 255), 0.0),
        ASTEROID63(0.1, 0.78, 0.43, 0.86, Color.rgb(255, 255, 255), 0.0),
        ASTEROID64(0.2, 0.77, 0.44, 0.84, Color.rgb(255, 255, 255), 0.0),
        ASTEROID65(0.2, 0.75, 0.58, 0.81, Color.rgb(255, 255, 255), 0.0),
        ASTEROID66(0.1, 0.78, 0.43, 0.86, Color.rgb(255, 255, 255), 0.0),
        ASTEROID67(0.2, 0.72, 0.53, 0.82, Color.rgb(255, 255, 255), 0.0),
        ASTEROID68(0.2, 0.71, 0.48, 0.84, Color.rgb(255, 255, 255), 0.0),
        ASTEROID69(0.1, 0.74, 0.44, 0.88, Color.rgb(255, 255, 255), 0.0),
        ASTEROID70(0.2, 0.72, 0.55, 0.82, Color.rgb(255, 255, 255), 0.0);;

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

    /**
     * Devuelve el nombre de este satélite.
     * @return nombre
     */
    public String getNombre() {
        return this.datos.toString();
    }
}
