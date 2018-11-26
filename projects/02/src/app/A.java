package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import simulations.Plot;

import java.awt.*;

public class A extends Application {

    private String name = "Simulation";

    // UI attributes
    private int cellSize = 10;
    private int n = 10;
    private StackPane[][] grid = new StackPane[n][n];

    @Override
    public void start(Stage window) throws Exception {
        Pane root = new Pane();
        root.setPrefSize(this.n * this.cellSize, this.n * this.cellSize);

        for(int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                StackPane cell = new StackPane();
                cell.setTranslateX(i * this.n);
                cell.setTranslateY(j * this.n);
                Rectangle border = new Rectangle(this.n, this.n);
                border.setStroke(Color.LIGHTBLUE);
                cell.getChildren().addAll(border);
                grid[i][j] = cell;
                root.getChildren().add(cell);
            }
        }

        window.setTitle(this.name);
        window.setScene(new Scene(root));
        window.show();

        // Plot.display("Plot");
    }
}
