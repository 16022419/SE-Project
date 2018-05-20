package UserInterface;

import Business.Users;
import DataAccess.Operation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class StartUpWindowController extends Application implements EventHandler<KeyEvent>{
    @FXML
    javafx.scene.control.TextField txtUser;

    @FXML
    javafx.scene.control.Button btnSignIn;

    @FXML
    javafx.scene.control.PasswordField pswPassword;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("StartUpWindow.fxml"));
        Scene scene = new Scene(root);
        txtUser = new javafx.scene.control.TextField();
        btnSignIn = new javafx.scene.control.Button();
        pswPassword = new javafx.scene.control.PasswordField();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(KeyEvent event) {
        String content = event.getCode().toString();
        System.out.println(content);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private double x, y;

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
    public void SignIn (ActionEvent event) {
        String username = txtUser.getText();
        String password = pswPassword.getText();
        if (validateLogin(username, password)){
            Stage startUpStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            startUpStage.hide();
            try {
                Stage stage = new Stage();
                PrimaryWindowController window = new PrimaryWindowController();
                window.start(stage);
            } catch(Exception e) {
                System.out.print("ERROR");
            }
        } else {
            System.out.println("Error: Wrong username or password");
        }

    }

    @FXML
    public void SignUp (ActionEvent event) {
        try {
            Stage stage = new Stage();
            SignUpWindowController window = new SignUpWindowController();
            window.start(stage);
        } catch(Exception e) {
            System.out.print("ERROR");
        }
    }

    public static boolean validateLogin(String username, String password) {
        Operation dataAccess = Operation.getOperation();
        ArrayList<Users> listUser = dataAccess.getAllUser();
        for (Users u : listUser) {
            if (u.getName().equalsIgnoreCase(username) && u.getPassword().equalsIgnoreCase(password))
                return true;
        }
        return false;
    }
}
