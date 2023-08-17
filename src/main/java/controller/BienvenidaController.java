package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BienvenidaController {
    @FXML
    public ProgressIndicator progressIndicator;
    @FXML
    public void initialize(){
        // gira indeterminadamente
        progressIndicator.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);

        // se establece tiempo para cerrar la actual y cargar la nueva ventana
        Duration waitDuration = Duration.seconds(5);

        /*
          se establece la linea de tiempo pra que empieze a correr y una lambda para
          reecuperar el objeto perteneciente a la clase y cerrar ducha ventana
         */

        Timeline timeline = new Timeline(new KeyFrame(waitDuration, event -> {
            Stage stage = (Stage) progressIndicator.getScene().getWindow();
            stage.close();
        }));

        // se abre la ventana principal
        try{
            MainApp main = new MainApp();
            main.start(new Stage());
        }catch (Exception e){
            e.printStackTrace();
        }

        //se estabelce que la linea de tiempo se ejecute una sola vez y se ejecuta
        timeline.setCycleCount(1);
        timeline.play();
    }


}
