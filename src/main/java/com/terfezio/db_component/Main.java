package com.terfezio.db_component;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String urlConnection = "jdbc:sqlite:" + System.getProperty("user.dir") + "/hospital.db";
        System.out.println(urlConnection);
        try {
            DBInterface dbInterface = new DBInterface(urlConnection);
            ArrayList<String> columns = dbInterface.getColumns("usuario");
            for(String column: columns) {
                System.out.println(column);
            }
            ArrayList<String[]> tableRows = dbInterface.getTableRows("usuario");
            for (String[] row: tableRows) {
                for (String data: row) {
                    System.out.print(data + " ");
                }
                System.out.println();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}
