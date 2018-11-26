package automatas.seismic;

import java.util.Random;

public class Cell {

    private int state;
    private Cell neighbours[];

    public void updateState() {
        this.state += 1;
    }

    public int getState() {
        return this.state;
    }

    public void init(int upperBound) {
        Random gen = new Random();
        this.state = gen.nextInt(upperBound);
    }

    @Override
    public String toString() {
        return Integer.toString(this.state);
    }

    public void addNeighbour(Cell cell) {
    }
}
