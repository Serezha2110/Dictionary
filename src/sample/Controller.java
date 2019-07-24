package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button table;

    @FXML
    private TextField word_ru;

    @FXML
    private Button insert;

    @FXML
    private TextField word_en;

    @FXML
    private Button update;

    @FXML
    private Label text;


    @FXML
    void initialize() {

        table.setOnAction(event -> {
            table.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/TableWindow.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });


        DatabaseHandler object = new DatabaseHandler();

        insert.setOnAction(event -> object.insert(word_ru.getText(),word_en.getText()));

        update.setOnAction(event -> object.update(word_ru.getText(),word_en.getText()));

    }
}

