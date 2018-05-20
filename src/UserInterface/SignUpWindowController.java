package UserInterface;

import Business.Controller;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.sql.Connection;

public class SignUpWindowController extends Application implements EventHandler<KeyEvent>{

    @FXML
    javafx.scene.control.TextField txtUsername;

    @FXML
    javafx.scene.control.PasswordField pswPassword;

    @FXML
    javafx.scene.control.TextField txtEmail;

    @FXML
    javafx.scene.control.Button btnApply;

    @FXML
    javafx.scene.control.RadioButton btnMale;

    @FXML
    javafx.scene.control.RadioButton btnFemale;

    @FXML
    javafx.scene.control.RadioButton btnNotClear;

    @FXML
    javafx.scene.control.ToggleGroup GenderGroup;

    @FXML
    double x, y;

    private String username;

    private String password;

    private int gender;

    private String email;

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void handle(KeyEvent event) {
        String content = event.getCode().toString();
        System.out.println(content);
    }

    @Override
    public void start(Stage stage) throws Exception {
        txtUsername = new javafx.scene.control.TextField();
        pswPassword = new javafx.scene.control.PasswordField();
        txtEmail = new javafx.scene.control.TextField();
        btnApply = new javafx.scene.control.Button();
        btnMale = new javafx.scene.control.RadioButton();
        btnFemale = new javafx.scene.control.RadioButton();
        btnNotClear = new javafx.scene.control.RadioButton();
        GenderGroup = new javafx.scene.control.ToggleGroup();
        btnMale.setSelected(true);
        btnFemale.setToggleGroup(GenderGroup);
        btnMale.setToggleGroup(GenderGroup);
        btnNotClear.setToggleGroup(GenderGroup);

        Parent root = FXMLLoader.load(getClass().getResource("SignUpWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Sign up");
        scene.setCursor(Cursor.HAND);
        stage.initStyle(StageStyle.TRANSPARENT);
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
    public void Drag (MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    public void Cancel (MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void Apply (MouseEvent event) {
        getInfo();
        Controller dataAccess = new Controller();
        dataAccess.createNewUser(getUsername(), getPassword(), getGender(), getEmail());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
    }

    private void getInfo() {
        username = txtUsername.getText();
        password = pswPassword.getText();
        email = txtEmail.getText();
        RadioButton btnGender  = (RadioButton)  GenderGroup.getSelectedToggle();
        if (btnGender.getText().equals("Male")) {
            gender = 1;
        } else if (btnGender.getText().equals("Female")) {
            gender = 2;
        } else if (btnGender.getText().equals("Not Clear")) {
            gender = 3;
        }
    }

    public String getUsername() {return username; }

    public String getPassword() { return password; }

    public String getEmail() { return email; }

    public int getGender() { return  gender; }
}
