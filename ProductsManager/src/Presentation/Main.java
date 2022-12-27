package Presentation;

import Dao.SingleDbConnection;
import Dao.entities.Commande;
import Dao.implementation.ClientImpl;
import Dao.implementation.CommandeImpl;
import Dao.implementation.ProduitImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) throws SQLException {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TabPane root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Style/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}