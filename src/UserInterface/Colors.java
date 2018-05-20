package UserInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Colors extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Colors.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Life lite");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
