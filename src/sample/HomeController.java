package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label text1;

    @FXML
    private ImageView imageButton;

    @FXML
    private Label text;

    @FXML
    void initialize() {
        assert text1 != null : "fx:id=\"text1\" was not injected: check your FXML file 'TableWindow.fxml'.";
        assert imageButton != null : "fx:id=\"imageButton\" was not injected: check your FXML file 'TableWindow.fxml'.";
        assert text != null : "fx:id=\"text\" was not injected: check your FXML file 'TableWindow.fxml'.";

    }
}
