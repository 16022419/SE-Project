package UserInterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.StageStyle;

public class ListActivitiesController extends Application {

    @FXML
    double x, y;

    @FXML
    javafx.scene.control.Button btnEdit;

    @FXML
    javafx.scene.control.Button btnClose;

    @FXML
    javafx.scene.layout.VBox vbxBox;

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ListActivities.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Activities");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void MousePressed (MouseEvent event) {
        x = event.getSceneX();
        y = event.getScreenY();
    }

    @FXML
    public void Close (MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void Apply (MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
    }


}
