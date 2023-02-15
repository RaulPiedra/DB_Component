package com.terfezio.db_component;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ComponentDBController {
    @FXML
    private ChoiceBox<String> choiceBoxTable;
    @FXML private TextField textFieldJDBC;
    private ArrayList<String> tables;
    @FXML public void initialize() {

        textFieldJDBC.setText("jdbc:sqlite:hospital.db");
    }

    public String getJDBC() {
        return textFieldJDBC.getText();
    }

    public void setTables(ArrayList<String> tablesList) {
        tables = tablesList;
    }
    public String getSelectedTable() {
        return choiceBoxTable.getSelectionModel().getSelectedItem();
    }
    public void loadTables() {

        for (String table: tables) {
            choiceBoxTable.setItems(FXCollections.observableList(tables));
            System.out.println(table);
        }
        choiceBoxTable.getSelectionModel().select(0);
    }
}
