module ProductsManager {
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.web;
    requires java.sql;
    requires mysql.connector.j;
    opens Presentation;
    opens Presentation.Controller;
    opens Dao.entities;
}