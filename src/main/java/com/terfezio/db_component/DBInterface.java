package com.terfezio.db_component;

import java.sql.*;
import java.util.ArrayList;

public class DBInterface {
    private String urlConnection;
    private Connection connection;
    private DatabaseMetaData databaseMetaData;

    public DBInterface(String urlConnection) throws SQLException {
        this.urlConnection = urlConnection;
        connection = DriverManager.getConnection(urlConnection);
        databaseMetaData = connection.getMetaData();
    }
    public String[] getDBMetadata() throws SQLException {
        String[] metadata = new String[3];
        metadata[0] = databaseMetaData.getDatabaseProductName();
        metadata[1] = databaseMetaData.getDatabaseProductVersion();
        metadata[2] = databaseMetaData.getUserName();

        return metadata;
    }
    public ArrayList<String> getTables() throws SQLException {
        //Devuelve un arraylist con los nombres de todas las tablas
        ArrayList<String> tables = new ArrayList<>();
        String[] table = {"TABLE"};
        ResultSet resultSet = databaseMetaData.getTables(null, "PUBLIC", null, table);

        while (resultSet.next()) {
            String tableName = resultSet.getString(3);
            tables.add(tableName);
        }
        return tables;
    }
    public ArrayList<String> getColumns(String tableName) throws SQLException {
        ArrayList<String> columns = new ArrayList<>();
        ResultSet resultSetColumns = databaseMetaData.getColumns(null, null, tableName, null);

        while (resultSetColumns.next()) {
            String columnName = resultSetColumns.getString("COLUMN_NAME");
            columns.add(columnName);
        }
        return columns;
    }
    public ArrayList<String[]> getTableRows(String tableName) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName + ";");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        int columnCount = resultSetMetaData.getColumnCount();



        ArrayList<String[]> rows = new ArrayList<>();

        while (resultSet.next()) {

            String[] row = new String[columnCount];
            for (int j = 0; j < columnCount; j++) {
                row[j] =  resultSet.getObject(j+1).toString();

            }
            rows.add(row);
        }
        return rows;
    }
}
