package simulations;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Plot {


    public static void display(String title) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 500, 500);

        window.setScene(scene);
        window.showAndWait();
    }
}
