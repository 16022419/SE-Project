package UserInterface;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import UserInterface.CustomizeWindowController;

public class PrimaryWindowController extends Application{

    @FXML
    javafx.scene.control.DatePicker cldPicker;

    @FXML
    javafx.scene.layout.GridPane grdData;

    @FXML
    private String timeStamp;

    private HashMap<String, ArrayList<VBox>> statusMap = new HashMap<>();

    private ArrayList<Label> labels;

    private ArrayList<VBox> vboxs;

    Border border = new Border(new BorderStroke(Color.web("#121920"), BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(0.2)));

    Background background = new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY));
    Background check = new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));

    CustomizeWindowController window;

    @Override
    public void start(Stage stage) throws Exception {
        cldPicker = new javafx.scene.control.DatePicker();
        grdData = new  javafx.scene.layout.GridPane();

        Parent root = FXMLLoader.load(getClass().getResource("PrimaryWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Life lite");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void DatePicker (ActionEvent event) {
        LocalDate date = cldPicker.getValue();
        timeStamp = convertLocalDate(date);
        try {
            LoadCalendar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadCalendar () {
        // Rows of GridPane
        int rows = 6;

        // Columns of GridPane
        int cols = 7;

        // Count the number of Object will be created
        int GridCount = 1;

        // Count the number of Label will be created
        int LabelCount = 1;

        // Capture the date from user and convert to default format as below
        String date = cldPicker.getValue().format(DateTimeFormatter.ofPattern("M/1/yyyy"));
        String month = String.valueOf(cldPicker.getValue().getMonthValue());
        Date time = new Date(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);

        int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        grdData.getChildren().clear();
        grdData.setBorder(border);
        if (statusMap.get(month) == null){
            statusMap.put(month,createNewGridPane(rows,cols,GridCount,firstDay,LabelCount,daysInMonth));
        } else {
            fillDataFromList(rows,cols,statusMap.get(month));
        }
    }

    private void fillDataFromList(int row, int col, ArrayList<VBox> listBox){
        int k  = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grdData.add(listBox.get(k++),j,i);
            }
        }
    }

    private ArrayList<VBox> createNewGridPane(int row, int col, int GridCount, int firstDay, int LabelCount, int daysInMonth){
        ArrayList<VBox> listBox = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                VBox pane = new VBox();
                if (GridCount < firstDay) {
                    GridCount++;
                    pane.setBackground(background);
                    pane.setBorder(border);
                } else {
                    if (LabelCount > daysInMonth) {
                        pane.setBackground(background);
                        pane.setBorder(border);
                    } else {
                        Label label = new Label(Integer.toString(LabelCount));
                        label.setStyle("-fx-font: 18px \"System\" ");
                        pane.getChildren().add(label);
                        pane.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                            @Override
                            public void handle(javafx.scene.input.MouseEvent event) {
                                System.out.println("Clicked");
                                try {
                                    Stage stage = new Stage();
                                    String time = getTimeStamp();
                                    window = new CustomizeWindowController();
                                    System.out.println("Pickup" + time);
                                    window.setTime(time);
                                    window.start(stage);
                                } catch(Exception e) {
                                    System.out.print("ERROR");
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    LabelCount++;
                }
                listBox.add(pane);
                grdData.add(pane, j, i);
            }
        }
        return listBox;
    }

    public String convertLocalDate(LocalDate timeStamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return timeStamp.format(formatter);
    }

    public String getTimeStamp() { return timeStamp;}

    public static void main(String[] args) {
        launch(args);
    }
}
