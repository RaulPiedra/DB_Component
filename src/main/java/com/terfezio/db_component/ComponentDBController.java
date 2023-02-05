package com.terfezio.db_component;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;

public class ComponentDBController {
    @FXML
    private ChoiceBox<String> choiceBoxTable;
    @FXML private TextField textFieldJDBC;
    private ArrayList<String> tables;
    public String getJDBC() {
        String jdbc = textFieldJDBC.getText();
        return jdbc;
    }
    public void setTables(ArrayList<String> tablesList) {
        tables = tablesList;
        System.out.println("Tables setted");
    }
    public String getSelectedTable() {
        String selectedTable = choiceBoxTable.getSelectionModel().getSelectedItem();
        return selectedTable;
    }
    public void loadTables() throws SQLException {

        for (String table: tables) {
            choiceBoxTable.setItems(FXCollections.observableList(tables));
            System.out.println(table);
        }
        choiceBoxTable.getSelectionModel().select(0);
    }
}
