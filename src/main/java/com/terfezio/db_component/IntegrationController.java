package com.terfezio.db_component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.sql.SQLException;

public class IntegrationController {
    @FXML private ComponentDBController dbComponentController;
    @FXML private ComponentDB_TABLE_Controller tableComponentController;
    private DBInterface dbInterface;
    public void connectDB(ActionEvent actionEvent) throws SQLException {
        String urlConnection = dbComponentController.getJDBC();
        dbInterface = new DBInterface(urlConnection);
        dbComponentController.setTables(dbInterface.getTables());
        dbComponentController.loadTables();
    }

    public void loadTable(ActionEvent actionEvent) throws SQLException {
        String table = dbComponentController.getSelectedTable();
        tableComponentController.setColumns(dbInterface.getColumns(table));
        tableComponentController.setRows(dbInterface.getTableRows(table));

        tableComponentController.setUpColumnsList();
        tableComponentController.setCheckBoxesAction();
        tableComponentController.setUpRows();
    }
}
