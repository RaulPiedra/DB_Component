package com.terfezio.db_component;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
        //rows = new ArrayList<>();
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

        /*
        columns.add("col1");
        columns.add("col2");
        columns.add("col3");

        ArrayList<String> row1 = new ArrayList<>();
        row1.add("1");
        row1.add("2");
        row1.add("3");

        ArrayList<String> row2 = new ArrayList<>();
        row2.add("1");
        row2.add("2");
        row2.add("3");

        //List[] rows = {row1, row2};
        rows = new ArrayList<>() ;
        rows.add(row1);
        rows.add(row2);

        setUpColumnsList();

        setCheckBoxesAction();

        setUpRows();

         */

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
        for (List<String> row : rows) {
            /*for (int i = 0; i < row.length; i++) {
                String columnName = checkBoxes.get(i).getText();
                System.out.println(columnName);
                //tableColumns.get(columnName).getItems().add(row[i]);
            }

             */

            data.add(row);


        }
        tableView.setItems(data);

    }

    public void setColumns(List<String> columnsString) {
        columns = columnsString;
    }

    /*public void setRows(ArrayList<String[]> rowsList) {
        rows = rowsList;
    }*/
    public void setUpColumnsList() {
        for (int i= 0; i < columns.size(); i++) {
            CheckBox checkBox = new CheckBox(columns.get(i));
            checkBoxes.add(checkBox);
            vBox.getChildren().add(checkBox);

            TableColumn<List<String>, String> tableColumn = new TableColumn<>(columns.get(i));
            tableColumns.put(columns.get(i), tableColumn);
            tableView.getColumns().add(tableColumn);
            int finalI = i;
            tableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> listStringCellDataFeatures) {
                    return new ReadOnlyStringWrapper(listStringCellDataFeatures.getValue().get(finalI));
                }
            });

        }
    }
}
