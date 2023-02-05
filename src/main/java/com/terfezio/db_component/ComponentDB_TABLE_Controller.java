package com.terfezio.db_component;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComponentDB_TABLE_Controller {
    @FXML VBox vBox;
    @FXML HBox hBox;
    private List<String[]> rows;
    private List<String> columns;
    private List<CheckBox> checkBoxes;
    private HashMap<String, ListView> tableColumns;
    public void initialize() {
        columns = new ArrayList<>();
        checkBoxes = new ArrayList<>();
        tableColumns = new HashMap<>();
        rows = new ArrayList<>();
        /*columns.add("col1");
        columns.add("col2");
        columns.add("col3");

        String[] row1 = {"val1", "val2"};
        String[] row2 = {"val2", "val4"};
        rows.add(row1);
        rows.add(row2);

        setUpColumnsList();

        setCheckBoxesAction();

        setUpRows();*/
    }

    public void setCheckBoxesAction() {
        for(CheckBox checkBox: checkBoxes) {
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

    public void setRows(List<String[]> rowsString) {
        rows = rowsString;

    }
    public void setUpRows() {
        for(String[] row: rows) {
            for (int i = 0; i < row.length; i++) {
                String columnName = checkBoxes.get(i).getText();
                System.out.println(columnName);
                tableColumns.get(columnName).getItems().add(row[i]);
            }

        }

    }
    public void setColumns(List<String> columnsString) {
        columns = columnsString;
    }
    /*public void setRows(ArrayList<String[]> rowsList) {
        rows = rowsList;
    }*/
    public void setUpColumnsList() {
       for (String column: columns) {
           CheckBox checkBox = new CheckBox(column);
           checkBoxes.add(checkBox);
           vBox.getChildren().add(checkBox);

           ListView<String> listView = new ListView<>();
           tableColumns.put(column, listView);
           hBox.getChildren().add(listView);
       }

    }
}
