module com.terfezio.db_component {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.terfezio.db_component to javafx.fxml;
    exports com.terfezio.db_component;
}