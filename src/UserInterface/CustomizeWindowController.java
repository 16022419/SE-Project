package UserInterface;

import Business.Controller;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javafx.event.ActionEvent;

import java.sql.Time;
import java.sql.Timestamp;

import UserInterface.PrimaryWindowController;

public class CustomizeWindowController extends Application {

    private double x, y;

    @FXML
    javafx.scene.control.Button btnApply;

    @FXML
    javafx.scene.control.Button btnClose;

    @FXML
    javafx.scene.control.TextField txtFrom;

    @FXML
    javafx.scene.control.TextField txtTo;

    @FXML
    javafx.scene.control.TextArea txtArea;
    public String name;

    public static String timeStamp;

    private String startTime;

    private String endTime;

    public void setTime(String timestamp){
        CustomizeWindowController.timeStamp = timestamp;
    }

    @Override
    public void start(Stage stage) throws Exception {
        btnApply = new javafx.scene.control.Button();
        btnClose = new javafx.scene.control.Button();
        txtFrom = new javafx.scene.control.TextField();
        txtTo = new javafx.scene.control.TextField();

        Parent root = FXMLLoader.load(getClass().getResource("CustomizeWindow.fxml"));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Life lite");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void MousePressed (MouseEvent event) {
        x = event.getSceneX();
        y = event.getScreenY();
    }

    @FXML
    public void Drag (MouseEvent event) {
        Stage stage = (Stage) ((Node) event. getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    public void Close (ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void Apply(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        getInfo();
        stage.hide();
    }

    public void getInfo() {
        name = txtArea.getText();
        startTime = txtFrom.getText() + ":00";
        endTime = txtTo.getText() + ":00";
        String.format(startTime, "HH:mm:ss");
        String.format(endTime, "HH:mm:ss");
        String stamp = CustomizeWindowController.timeStamp;
        startTime = stamp + " " + startTime;
        endTime = stamp + " " + endTime;
        Timestamp start = Timestamp.valueOf(startTime);
        Timestamp end = Timestamp.valueOf(endTime);
        Controller dataAccess = new Controller();
        dataAccess.createNewActivities(System.currentTimeMillis() + "acti", name, start, end);
    }


    public static void main(String[] args) {
        launch(args);
    }

}