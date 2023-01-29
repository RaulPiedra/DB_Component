package com.terfezio.db_component;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;

public class db_componentController {
    private DBInterface dbInterface;
    @FXML private ChoiceBox<String> choiceBoxTable;
    @FXML private TextField textFieldJDBC;
    @FXML private Button buttonConnect;
    @FXML private Button buttonLoad;
    public void initialize() {
        buttonLoad.setDisable(true);
    }
    public void connect(ActionEvent actionEvent) {
        String urlConnection = textFieldJDBC.getText();
        try {
            dbInterface = new DBInterface(urlConnection);
            loadTables();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void loadTable(ActionEvent actionEvent) {
    }
    private void loadTables() throws SQLException {
        ArrayList<String> tables = dbInterface.getTables();
        for (String table: tables) {
            choiceBoxTable.setItems(FXCollections.observableList(tables));
        }
        choiceBoxTable.getSelectionModel().select(0);
        buttonLoad.setDisable(false);
    }
}
