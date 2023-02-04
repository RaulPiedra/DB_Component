package com.terfezio.db_component;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ComponentDB_TABLE_Controller {
    @FXML VBox vBox;
    private List<String> rows;
    private List<String> columns;
    public void initialize() {
        columns = new ArrayList<>();
        columns.add("col1");
        columns.add("col2");
        setUpColumns();
    }

    public void setRows(List<String> rowsString) {
        rows = rowsString;

    }
    public void setColumns(List<String> columnsString) {
        columns = columnsString;
    }
    public void setUpColumns() {
        for(String column: columns) {
            CheckBox checkBox = new CheckBox(column);
            vBox.getChildren().add(checkBox);
        }

    }
}
