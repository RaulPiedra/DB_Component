package com.terfezio.db_component;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComponentDB_TABLE_Controller {
    @FXML
    VBox vBox;
    @FXML
    HBox hBox;
    @FXML
    TableView<List<String>> tableView;
    private ArrayList<ArrayList<String>> rows;
    private List<String> columns;
    private List<CheckBox> checkBoxes;
    private HashMap<String, TableColumn> tableColumns;
    private ObservableList<List<String>> data;
    public void initialize() {
        columns = new ArrayList<>();
        checkBoxes = new ArrayList<>();
        tableColumns = new HashMap<>();

        data = FXCollections.observableArrayList();
    }

    public void setCheckBoxesAction() {
        for (CheckBox checkBox : checkBoxes) {
            checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {

                    System.out.println(checkBox.getText());
                    String columnName = checkBox.getText();
                    tableColumns.get(columnName).setVisible(!tableColumns.get(columnName).isVisible());

                }
            });
        }
    }

    public void setRows(ArrayList<ArrayList<String>> rowsString) {
        rows = rowsString;

    }

    public void setUpRows() {

        tableView.getItems().clear();
        data.addAll(rows);
        tableView.setItems(data);

    }

    public void setColumns(List<String> columnsString) {
        columns = columnsString;
    }


    public void setUpColumnsList() {
        tableView.getColumns().clear();
        vBox.getChildren().clear();
        Label label = new Label("Columnas:");
        vBox.getChildren().add(label);
        for (int i= 0; i < columns.size(); i++) {
            CheckBox checkBox = new CheckBox(columns.get(i));
            checkBox.setSelected(true);
            checkBoxes.add(checkBox);
            vBox.getChildren().add(checkBox);

            TableColumn<List<String>, String> tableColumn = new TableColumn<>(columns.get(i));
            tableColumns.put(columns.get(i), tableColumn);
            tableView.getColumns().add(tableColumn);
            int finalI = i;
            tableColumn.setCellValueFactory(listStringCellDataFeatures -> new ReadOnlyStringWrapper(listStringCellDataFeatures.getValue().get(finalI)));

        }
    }
}
