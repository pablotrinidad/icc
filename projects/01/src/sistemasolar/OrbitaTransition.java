/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;

import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Asigna la translación total que debe aplicarse a un astro para rotar
 * alrededor del foco indicado.
 * @author blackzafiro
 */
public class OrbitaTransition extends Transition {

    /*
     * El satélite que va a orbitar alrededor de otro.
     */
    private final Satelite satelite;

    /*
     * Parámetros de la elipse.
     */
    private final double semiejeMayor;
    private final double semiejeMenor;
    private final double c;

    /**
     * Constructor con los datos de la órbita.
     * @param satelite
     * @param semiejeMayor
     * @param semiejeMenor
     * @param periodoOrbital
     */
    public OrbitaTransition(Satelite satelite,
            double semiejeMayor, double semiejeMenor,
            double periodoOrbital) {
        this.satelite = satelite;
        this.semiejeMayor = semiejeMayor;
        this.semiejeMenor = semiejeMenor;
        this.c = Math.sqrt(semiejeMayor * semiejeMayor - semiejeMenor * semiejeMenor);

        //setInterpolator(Interpolator.LINEAR);
        setInterpolator(new KeplerInterpolator());
        setCycleDuration(Duration.seconds(periodoOrbital));
        setCycleCount(Timeline.INDEFINITE);
    }

    /**
     * Asigna la translación total que debe aplicarse a un astro para rotar
     * alrededor del foco indicado.
     * @param frac número entre 0 y 1 indicando en qué tiempo de la animación
     * está el satélite.
     * Los valores extremos corresponden a los cero grados en la órbita.
     */
    @Override
    protected void interpolate(double frac) {
        // Coordenadas en la elipse con respecto al foco
        double t = 2 * Math.PI * frac;
        double i = this.satelite.getInclination();
        double x;
        if (i > 0) {
            x = (semiejeMayor * Math.cos(t)) + (semiejeMayor * Math.sin(t));
        } else {
            x = semiejeMayor * Math.cos(t);
        }
        double y = semiejeMenor * Math.sin(t);

        // Posición del centro del foco con respecto a su nodo padre
        Node foco = this.satelite.getFoco().getFigura();
        Bounds inSceneCoords = foco.localToParent(foco.getBoundsInLocal()); // Esquina superior izquierda
        Point2D origen = foco.localToParent(0, 0);
        double focoX = (inSceneCoords.getMinX() + inSceneCoords.getMaxX())/2; // Coords del centro
        double focoY = (inSceneCoords.getMinY() + inSceneCoords.getMaxY())/2;

        // Asignar la translación con respecto al centro del nodo padre
        this.satelite.getNodo().setTranslateX(origen.getX() - focoX + x);
        this.satelite.getNodo().setTranslateY(origen.getY() - focoY + y);
    }

}
