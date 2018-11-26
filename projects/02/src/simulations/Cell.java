package simulations;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public abstract class Cell {

    // UI Elements
    protected StackPane pane;
    private Rectangle figure;

    // Automata data
    protected int state;

    // Auxiliaries
    protected Random prng = new Random();  // Pseudo-random number generator

    // For simulations that doesn't require to explicitly know the time
    public abstract void updateState();

    // For simulations that require to know the value of t
    public abstract void updateState(int t);

    @Override
    public String toString() {
        return Integer.toString(this.state);
    }

    public void translateX(double x) {
        this.pane.setTranslateX(x);
    }

    public void translateY(double y) {
        this.pane.setTranslateY(y);
    }
}
