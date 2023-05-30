import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WwmFX extends Application {

    @Override
    public void start(Stage stage) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuView.fxml"));
            BorderPane root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("My App");
            stage.show();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}