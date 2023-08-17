package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BienvenidaApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Bienvenida.fxml")));
        primaryStage.setTitle("Bienvenida");
        primaryStage.setScene(new Scene(root,600,350));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
