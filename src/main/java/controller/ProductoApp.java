package main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Producto;

import java.io.IOException;
import java.util.Objects;

public class ProductoApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Productos.fxml")));
        primaryStage.setTitle("Almacen");
        primaryStage.setScene(new Scene(root,750,500));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
