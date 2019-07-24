package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableController extends DatabaseHandler {

    private ObservableList usersData = FXCollections.observableArrayList();

    @FXML
    private TableView tableWords;

    @FXML
    private TableColumn idColumn;

    @FXML
    private TableColumn column_ru;

    @FXML
    private TableColumn column_en;

    @FXML
    private Button back;


    // инициализируем форму данными
    @FXML
    private void initialize() throws SQLException {

        back.setOnAction(event -> {
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Main.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage stage2 = new Stage();
            Parent root = loader.getRoot();
            stage2.setScene(new Scene(root));
            stage2.showAndWait();
        });

        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        column_ru.setCellValueFactory(new PropertyValueFactory<>("wordRu"));
        column_en.setCellValueFactory(new PropertyValueFactory<>("wordEn"));

        // заполняем таблицу данными
        tableWords.setItems(usersData);
    }

    private void initData() throws SQLException {
        String select = "SELECT * FROM words";
        Statement stmt = DatabaseHandler.Conn().createStatement();
        int i = 1;

        ResultSet rs = stmt.executeQuery(select);
        while (rs.next()) {
            String wordRu = rs.getString("words_ru");
            String wordEn = rs.getString("words_en");
            usersData.add(new Words(i++, wordEn, wordRu));
        }
    }

}