package simulations;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
* Simulation
*
* Handle basic tasks like starting the simulation
* and calling specific methods to initialize automatas and
* run interface.
*
* */
public abstract class Simulation {

    // Simulation attributes
    private String name;

    // Global attributes
    protected int n;  // Length of square matrix
    protected int t;  // Amount of units of time in which the simulation will run

    // Grid attributes
    private final int tileSize = 20;
    private Cell[][] cells;

    public Simulation(int n, int t) {
        this.n = n;
        this.t = t;
    }

    // Run simulation and plotting
    public void run(Stage window) {
        this.setupUI(window);

        this.runSimulation();
    }

    // Run simulation t times
    final void runSimulation() {
        for (int localT = 0; localT < this.t; localT ++) {
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.n; j++) {
                    this.cells[i][j].updateState(localT);  // Send time t
                }
            }
        }
    }

    final void setupUI(Stage window) {
        Pane root = new Pane();
        root.setPrefSize(this.n * this.tileSize, this.n * this.tileSize);

        this.cells = this.createAutomatas();

        // Add cells to grid
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                Cell cell = this.cells[i][j];
                cell.translateX(i * this.n);
                cell.translateY(j * this.n);
                root.getChildren().add(cell.pane);
            }
        }

        window.setTitle(this.name);
        window.setScene(new Scene(root));
        window.show();
    }

    // Implementation is up to each simulation
    public abstract Cell[][] createAutomatas();
}
