package simulations;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public abstract class Cell {

    // UI Elements
    public Rectangle figure;

    // Automata data
    protected int state;

    // Auxiliaries
    protected Random prng; // Pseudo-random number generator

    public Cell() {
        this.prng = new Random();
    }

    // For simulations that doesn't require to explicitly know the time
    public abstract void updateState();

    // For simulations that require to know the value of t
    public abstract void updateState(int t);

    @Override
    public String toString() {
        return Integer.toString(this.state);
    }

}
